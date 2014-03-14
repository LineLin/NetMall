package com.line.web.sys;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

@SuppressWarnings("unchecked")
final public class SysSetting {
	private static final String FILE_NAME = "sys.xml";
	
	private static SAXReader reader = new SAXReader();
	
	private static OutputFormat format = OutputFormat.createPrettyPrint();
	
	private static XMLWriter writer;
	//顶级板块展示的个数
	private static AtomicInteger topLevelPlateCount = new AtomicInteger();
	//二级板块展示的个数
	private static AtomicInteger secondLevelPlateCount = new AtomicInteger();
	//三级板块展示的个数
	private static AtomicInteger thirdLevelPlateCount = new AtomicInteger();
	//主页每个栏目下展示的商品的数目
	private static AtomicInteger indexCommodityCount = new AtomicInteger();
	
	public static void init(){
		File file = new File(SysSetting.FILE_NAME);
		Document doc;
		Element count;
		format.setNewlines(true);
		if(!file.exists()){
			try {
				file.createNewFile();
				doc = DocumentHelper.createDocument();
			    doc.setXMLEncoding("uft8");
				Element root = doc.addElement("config");
				Element index = root.addElement("index");
				Element plates = index.addElement("plates");
				Element top = plates.addElement("plate");
				top.addAttribute("level","1");
				count = top.addElement("count");
				count.setText("8");
				Element second = plates.addElement("plate");
				second.addAttribute("level", "2");
				count = second.addElement("count");
				count.setText("8");
				Element third = plates.addElement("plate");
				third.addAttribute("level","3");
				count = third.addElement("count");
				count.setText("8");
				Element commodity = index.addElement("commodity");
				count = commodity.addElement("count");
				count.setText("8");
	            format.setNewlines(true);
				writer = new XMLWriter(new FileWriter(file),format);
				writer.write(doc);
				writer.close();
				
				topLevelPlateCount = secondLevelPlateCount = thirdLevelPlateCount = new AtomicInteger(8);
				indexCommodityCount = new AtomicInteger(8);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				doc = reader.read(file);
				List<Element> plateNodes = (List<Element>)doc.selectNodes("/config/index/plates/plate");
				for(Element e : plateNodes){
					 System.out.println(e.attributeValue("level"));
					 int level = Integer.valueOf(e.attributeValue("level"));
					 int c = Integer.valueOf(e.element("count").getText());
					 switch(level){
					 case 1: topLevelPlateCount.set(c); break;
					 case 2: secondLevelPlateCount.set(c);break;
					 case 3: thirdLevelPlateCount.set(c);break;
					 }
				}
				Element commodityElement = (Element)doc.selectSingleNode("/config/index/commodity");
				int c = Integer.valueOf(commodityElement.element("count").getText());
				indexCommodityCount.set(c);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}
	private static void updatePlateCount(String level,int newValue){
		try {
			File file = new File(SysSetting.FILE_NAME);
			Document doc = reader.read(file);
			Element e = (Element)doc.selectSingleNode("/config/index/plates/plate[@level=+"+level+"]");
			e.element("count").setText(String.valueOf(newValue));
			writer = new XMLWriter(new FileWriter(file),format);
			writer.write(doc);
			writer.close();
		}catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void updataIndexCommodityCount(int newValue){
		try {
			File file = new File(SysSetting.FILE_NAME);
			Document doc = reader.read(file);
			Element e = (Element)doc.selectSingleNode("config/index/commodity");
			e.element("count").setText(String.valueOf(newValue));
			writer = new XMLWriter(new FileWriter(file),format);
			writer.write(doc);
			writer.close();
		}catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	public static int getTopLevelPlateCount() {
		return topLevelPlateCount.intValue();
	}

	public static void setTopLevelPlateCount(int newValue) {
		updatePlateCount("1",newValue);
		SysSetting.topLevelPlateCount.set(newValue);
	}

	public static int getSecondLevelPlateCount() {
		return secondLevelPlateCount.intValue();
	}

	public static void setSecondLevelPlateCount(int newValue) {
		updatePlateCount("2",newValue);
		SysSetting.secondLevelPlateCount.set(newValue);
	}

	public static int getThirdLevelPlateCount() {
		return thirdLevelPlateCount.intValue();
	}

	public static void setThirdLevelPlateCount(int newValue) {
		updatePlateCount("3",newValue);
		SysSetting.thirdLevelPlateCount.set(newValue);
	}

	public static int getIndexCommodityCount() {
		return indexCommodityCount.intValue();
	}

	public static void setIndexCommodityCount(int newValue) {
		updataIndexCommodityCount(newValue);
		SysSetting.indexCommodityCount.set(newValue);
	}
	
	public static void main(String[] args){
		init();
		setIndexCommodityCount(10);
	}

}
