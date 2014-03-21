package com.line.web.sys;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

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
	
	private static final String FILE_PATH = "./sys.xml";
	
	private static SAXReader reader = new SAXReader();
	
	private static OutputFormat format = OutputFormat.createPrettyPrint();
	
	private static XMLWriter writer;
	
	private static ConcurrentHashMap<String,Integer> siteMap = new ConcurrentHashMap<String,Integer>();
	
	private static final int DEFAULT_PlATE_SHOW_COUNT = 8;
	
	private static final int DEFAULT_COMMODITY_SHOW_COUNT = 8;
	
	static{
		init();
	}
	/**
	 * 系统默认初始化。
	 */
	public static void init(){
		File file = new File(FILE_PATH);
		Document doc;
		format.setNewlines(true);
		if(!file.exists()){
			System.out.println("新建系统配置文件");
			try {
				file.createNewFile();
				doc = DocumentHelper.createDocument();
			    doc.setXMLEncoding("uft8");
				Element root = doc.addElement("config");
				initIndexPageSetting(root);
				initCommodityShowCount(root);
	            format.setNewlines(true);
				writer = new XMLWriter(new FileWriter(file),format);
				writer.write(doc);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				doc = reader.read(file);
				List<Element> plateNodes = (List<Element>)doc.selectNodes("/config/page/index/plates/plate");
				for(Element e : plateNodes){
					String level = e.attributeValue("level");
					String key = getPageKey(Page.INDEX,level);
					String count = e.element("count").getText();
					Integer value;
					if(count.equals("*")){
						value = -1;
					}else{
						value = Integer.valueOf(count);
					}
					siteMap.put(key,value);
					System.out.println("plates key -->" + key + "     value--->" + value);
				}
				List<Element> commodityNodes = (List<Element>) doc.selectNodes("/config/commodity/*");
				for(Element e : commodityNodes){
					Page page = Page.getPageOfNmae(e.getName());
					if(page == null) continue;
					String key = getCommodityKey(page);
					String count = e.element("count").getText();
					Integer value;
					if(count.equals("*")){
						value = -1;
					}else{
						value = Integer.valueOf(count);
					}
					siteMap.put(key,value);
					System.out.println("commodity key -->" + key + "     value--->" + value);
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 功能：初始化首页的商品显示数目参数
	 * @param root
	 */
	private static void initCommodityShowCount(Element root){
		Element count;
		Element commodity = root.addElement("commodity");
		Element index = commodity.addElement("index");
		count = index.addElement("count");
		count.setText("8");
		Element first = commodity.addElement("first");
		count = first.addElement("count");
		count.setText("15");
		Element second = commodity.addElement("second");
		count = second.addElement("count");
		count.setText("8");
		Element third = commodity.addElement("third");
		count = third.addElement("count");
		count.setText("*");
	}
	/**
	 * 功能：初始化首页的页面设置
	 * @param root
	 */
	private static void initIndexPageSetting(Element root){
		Element count;
		Element page = root.addElement("page");
		Element index = page.addElement("index");
		Element plates = index.addElement("plates");
		Element top = plates.addElement("plate");
		top.addAttribute("level","1");
		count = top.addElement("count");
		count.setText("*");
		Element second = plates.addElement("plate");
		second.addAttribute("level", "2");
		count = second.addElement("count");
		count.setText("8");
		Element third = plates.addElement("plate");
		third.addAttribute("level","3");
		count = third.addElement("count");
		count.setText("10");
	}
	
	/**
	 * 功能：更改页面上某级{@param level}板块的显示数量
	 * @param page 页面
	 * @param level 级别
	 * @param newValue 新值
	 */
	
	public static void updatePagePlateCount(Page page,String level,int newValue){
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
	/**
	 * 功能：更改配置文件的商品显示数量的参数
	 * @param page 页面
	 * @param newValue 更改值
	 */
	public static void updataCommodityCount(Page page,int newValue){
		try {
			File file = new File(FILE_PATH);
			Document doc = reader.read(file);
			String xPath = getCommodityKey(page);
			Element e = (Element)doc.selectSingleNode(xPath);
			e.element("count").setText(String.valueOf(newValue));
			writer = new XMLWriter(new FileWriter(file),format);
			writer.write(doc);
			writer.close();
		}catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 功能：根据页面和板块的级别，返回显示的个数。如果要显示全部，则返回-1
	 * @param page 页面
	 * @param level 板块级数
	 * @return -1 当要显示全部某级别的全部板块时。 count 要显示的板块数。
	 */
	public static int getPagePlateCount(Page page,String level){
		String key = getPageKey(page,level);
		if(siteMap.containsKey(key)){
			return siteMap.get(key);
		}else{
			Integer count = DEFAULT_PlATE_SHOW_COUNT;
			File file = new File(FILE_PATH);
			try {
				Document doc = reader.read(file);
				Element e = (Element)doc.selectSingleNode((key));
				String countText = e.element("count").getText();
				if(countText.equals("*")){
					return -1;
				}
				count = Integer.valueOf(countText);
				siteMap.put(key, count);
			}catch (DocumentException | NumberFormatException e) {
				e.printStackTrace();
			}
			return count;
		}
	}
	
	/**
	 * 功能：根据不同的页面返回要在页面上显示的商品数量。如果要显示全部，那么返回-1 。否则返回其商品数
	 * @param page 页面
	 * @return
	 */
	public static int getPageCommodityCount(Page page){
		String key = getCommodityKey(page);
		if(siteMap.contains(key)){
			return siteMap.get(key);
		}else{
			Integer count = DEFAULT_COMMODITY_SHOW_COUNT;
			try{
				File file = new File(FILE_PATH);
				Document doc = reader.read(file);
				Element e = (Element) doc.selectSingleNode(key);
			    String countText = e.element("count").getText();
			    if(countText.equals("*")){
			    	return -1;
			    }
			    count = Integer.valueOf(countText);
			    siteMap.put(key, count);
			}catch(DocumentException | NumberFormatException e){
				e.printStackTrace();
			}
			return count;
		}
	}
	
	private static String getPageKey(Page page,String level){
		String key = "config/page/" + page.getName() + "/plates/plate[@level=" + level + "]";
		return key;
	}
	
	private static String getCommodityKey(Page page){
		String key = "config/commodity/" + page.getName();
		return key;
	}
}
