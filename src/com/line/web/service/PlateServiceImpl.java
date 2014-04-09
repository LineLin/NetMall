package com.line.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.model.Commodity;
import com.line.web.model.Plate;
import com.line.web.model.dao.CommodityDao;
import com.line.web.model.dao.PlateDao;
import com.line.web.sys.SysInit;
import com.line.web.sys.SysSetting;
import com.line.web.utils.enumtool.Page;
import com.line.web.view.support.PlateInfo;

@Service
@Transactional
public class PlateServiceImpl implements PlateService {
	
	//顶级板块的level
	private final int TOP_PLATE_LEVEL = 1;
	
	//一级板块显示页面的链接地址
	private final String TOP_PLATE_SHOW_LINK_PATH = "first";
	
	//二级板块显示页面的链接地址
	private final String SECOND_PLATE_SHOW_LINK_PATH = "second";
	
	//三级板块显示页面的链接地址
	private final String THIRD_PLATE_SHOW_LINK_PATH = "items";
	
	private final String DEFAULT_PLATE_SHOW_LINK_PATH = "";
	
	private final int INDEX_PLATE_SHOW_DEPTH = 3; 
	
	@Autowired
	private PlateDao plateDao;
	
	@Autowired
	private CommodityDao commodityDao;
	
	/**
	 * 功能：得到商场主页的板块信息。
	 */
	@Transactional(readOnly=true)
	@Override
	public List<PlateInfo> getIndexPlateInfo() {
		
		List<Plate> tPList = plateDao.getPlateOrderByShowSeq(null,getPlateShowCount(Page.INDEX,TOP_PLATE_LEVEL));
		List<PlateInfo> platesInfo = new ArrayList<PlateInfo>();
		if(tPList.isEmpty()){
			tPList = initPlate();
		}
		for(Plate p : tPList){
			PlateInfo info = new PlateInfo(p);
			info.setLinkPath(getLinkPath(p));
			info.setSubPlates(getSubPlateInfo(p,INDEX_PLATE_SHOW_DEPTH,Page.INDEX));
			platesInfo.add(info);
		}
		
		return platesInfo;
	}

	/**
	 * 功能：由父板块得到子版块的页面展示信息列表
	 * @param plate 父板块
	 * @return 子板块信息列表
	 */
	public List<PlateInfo> getSubPlateInfo(Plate plate,int depth,Page page){
		
		if(plate.getLevel() >= depth){
			return null;
		}
		
		List<Plate> subPlates = (List<Plate>) plateDao.getPlateOrderByShowSeq(plate.getId(),getPlateShowCount(page,plate.getLevel()+1));
		
		List<PlateInfo> pInfo = new ArrayList<PlateInfo>();
		
		if(!subPlates.isEmpty()){
			for(Plate p : subPlates){
				PlateInfo info = new PlateInfo();
				info.setPlate(p);
				info.setLinkPath(getLinkPath(p));
				//递归构建板块的显示辅助类
				info.setSubPlates(getSubPlateInfo(p,depth,page));
				pInfo.add(info);
			}
			return pInfo;
		}
		return null;
	}
	
	/**
	 * 功能：根据Id找板块
	 */
	@Override
	public Plate getPlateById(String id){
		return plateDao.getById(id);
	}
	
	/**
	 * 功能：取得板块在前台显示链接的前缀
	 * @param p
	 * @return
	 */
	private String getLinkPath(Plate p){
		switch(p.getLevel()){
			case 1: return TOP_PLATE_SHOW_LINK_PATH;
			case 2: return SECOND_PLATE_SHOW_LINK_PATH;
			case 3: return THIRD_PLATE_SHOW_LINK_PATH;
			default:return DEFAULT_PLATE_SHOW_LINK_PATH;
		}
	}
	
	/**
	 * 功能：取得要某级板块的显示个数
	 * @param level 板块级数
	 * @return
	 */
	private int getPlateShowCount(Page page,int level){
		return SysSetting.getPagePlateCount(page, String.valueOf(level));
	}
	
	/**
	 * 功能：得到某板块下的叶子板块，并将叶子板块放在list列表中
	 * @param p 父板块
	 * @param list 叶子板块存储列表
	 */
//	private void getLeafPlate(Plate p,List<Plate> list){
//		
//		List<Plate> childs = plateDao.getByPid(p);
//		if(childs.isEmpty()){
//			list.add(p);
//			return;
//		}else{
//			for(Plate cp : childs){
//				getLeafPlate(cp,list);
//			}
//		}
//	}
	
	/**
	 * 功能：取得list中每个板块下要展示的商品
	 * @param list 板块展示列表
	 * @param property 排序的属性
	 * @param count 取得的商品数量
	 */
	@Override
	public void getPopularCommodity(List<PlateInfo> list,String property,int count){
		for(PlateInfo p : list){
			if(p.getSubPlates() == null){
				List<Commodity> commodities = commodityDao.getByPlate(p.getPlate(), count);
				p.setCommodities(commodities);
			}else{
				List<Plate> leafPlates;
//				getLeafPlate(p.getPlate(),leafPlates);
				leafPlates = plateDao.getLeafPlate(p.getPlate());
				System.out.println(leafPlates.size());
				List<Commodity> commodities = commodityDao.getByPlates(leafPlates,property,count);
				p.setCommodities(commodities);
			}
		}
	}
	
	/**
	 * 功能：初始化板块
	 * @return
	 */
	@Override
	public List<Plate> initPlate(){
		return SysInit.getInstance(plateDao).initIndexPlates();
		/*List<Plate> plates = new ArrayList<>();
		String[] pNames = {"家具","珠宝","服装","图书","化妆品","电脑办公","虚拟币","生活服务"};
		String[][] secondName = {{"客厅家具","餐厅家具","卧室家具","床","书房家具"},
								{"翡翠","黄金","白银","砖石","水晶"},
								{"女装","儿装","男装","大肚装"},
								{"人文社科","人物传记","教育","文艺","辅导书","儿童书"},
								{"爽肤水","粉底","睫毛膏","祛痘","面膜","口红"},
								{"平板","台式电脑","电脑配件","电脑外设"},
								{"充值","购物"},
								{"彩票","教育培训","餐饮美食","休闲娱乐","电影演出"}};
		for(int i=0; i<pNames.length; i++){
			Plate plate = new Plate();
			plate.setName(pNames[i]);
			plate.setLevel(1);
			plateDao.save(plate);
			for(int j=0; j<secondName[i].length;j++){
				Plate p = new Plate();
				p.setName(secondName[i][j]);
				p.setParentPlate(plate);
				p.setLevel(2);
				plateDao.save(p);
			}
			plates.add(plate);
		}
		return plates;
		*/
	}

	@Override
	public List<Commodity> getPageCommodity(Plate plate, String sortBy, boolean isDesc,
			int page, int pageSize) {
		List<Commodity> list;
		list = commodityDao.getByPlate(plate, page, pageSize, sortBy, isDesc);
		return list;
	}

	/**
	 * 功能：取得某个级别的板块集合
	 * @param level 板块级别
	 */
	@Override
	public List<Plate> getPlateByLevel(int level) {
		return plateDao.getByLevel(level);
	}
	
	/**
	 * 功能：取得某个板块下的直接子板块
	 * @param parentId 父板块的id
	 */
	@Override
	public List<Plate> getByParentPlate(String parentId) {
		return plateDao.getByPid(parentId);
	}

}
