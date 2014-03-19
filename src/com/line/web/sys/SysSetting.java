package com.line.web.sys;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.line.web.utils.Page;

@SuppressWarnings("unchecked")
final public class SysSetting {
	
	private static final String FILE_PATH = "sys.xml";
	
	private static SAXReader reader = new SAXReader();
	
	private static OutputFormat format = OutputFormat.createPrettyPrint();
	
	private static XMLWriter writer;
	
	private static ConcurrentHashMap<String,Integer> siteMap = new ConcurrentHashMap<String,Integer>();
	
	private final int DEFAULT_PlATE_SHOW_COUNT = 8;
	
	static{
		
	}
	
	public static void init(){
		File file = new File(FILE_PATH);
		Document doc;
		format.setNewlines(true);
		if(!file.exists()){
			try {
				file.createNewFile();
				doc = DocumentHelper.createDocument();
			    doc.setXMLEncoding("uft8");
				Element root = doc.addElement("config");
				Element page = doc.addElement("page");
				initIndexPageSetting(page);
				initItemListPageSetting(page);
	            format.setNewlines(true);
				writer = new XMLWriter(new FileWriter(file),format);
				writer.write(doc);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				doc = reader.read(file);
				List<Element> plateNodes = (List<Element>)doc.selectNodes("/config/index/plates/plate");
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void initIndexPageSetting(Element root){
		Element count;
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
	}
	
	private static void initItemListPageSetting(Element page){
		Element count;
		Element index = page.addElement("item-list");
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
	}
	private static void updatePagePlateCount(Page page,String level,int newValue){
		try {
			String xPath = getPageKey(page,level);
			File file = new File(FILE_PATH);
			Document doc = reader.read(file);
			Element e = (Element)doc.selectSingleNode(xPath);
			e.element("count").setText(String.valueOf(newValue));
			writer = new XMLWriter(new FileWriter(file),format);
			writer.write(doc);
			writer.close();
		}catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void updataCommodityCount(Page page,int newValue){
		try {
			File file = new File(FILE_PATH);
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
	
	public int getPagePlateCount(Page page,String level){
		String key = getPageKey(page,level);
		if(siteMap.containsKey(key)){
			return (Integer)siteMap.get(key);
		}else{
			int count = DEFAULT_PlATE_SHOW_COUNT;
			File file = new File(FILE_PATH);
			try {
				Document doc = reader.read(file);
				Element e = (Element)doc.selectNodes(key);
				count = Integer.valueOf(e.element("count").getText());
				siteMap.put(key, count);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			return count;
		}
	}
	
	private static String getPageKey(Page page,String level){
		String key = "config/page/" + page.getName() + "/plates/plate[@level=" + level + "]";
		return key;
	}
}
