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
import com.line.web.view.support.PlateInfo;

@Service
@Transactional
public class PlateServiceImpl implements PlateService {
	
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
		
		List<Plate> tPList = plateDao.getPlateOrderByShowSeq(null,getPlateShowCount(1));
		List<PlateInfo> platesInfo = new ArrayList<PlateInfo>();
		if(tPList.isEmpty()){
			tPList = initPlate();
		}
		for(Plate p : tPList){
			PlateInfo info = new PlateInfo(p);
			info.setLinkPrefix(getLinkPrefix(p));
			info.setSubPlates(getSubPlateInfo(p));
			platesInfo.add(info);
		}
		return platesInfo;
	}
	
	public List<PlateInfo> getSecondPlateInfo(String plateId){
		Plate p = plateDao.findById(plateId);
		return getSubPlateInfo(p);
	}

	/**
	 * 功能：由父板块得到子版块的页面展示信息列表
	 * @param plate 父板块
	 * @return 子板块信息列表
	 */
	public List<PlateInfo> getSubPlateInfo(Plate plate){
		
		if(plate.getLevel() > 3){
			return null;
		}
		List<Plate> subPlates = (List<Plate>) plateDao.getPlateOrderByShowSeq(plate.getId(),getPlateShowCount(plate.getLevel()+1));
		List<PlateInfo> pInfo = new ArrayList<PlateInfo>();
		
		if(!subPlates.isEmpty()){
			for(Plate p : subPlates){
				PlateInfo info = new PlateInfo();
				info.setPlate(p);
				info.setLinkPrefix(getLinkPrefix(p));
				//递归构建板块的显示辅助类
				info.setSubPlates(getSubPlateInfo(p));
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
	public Plate getPlate(String id){
		return plateDao.findById(id);
	}
	/**
	 * 功能：初始化板块
	 * @return
	 */
	@Override
	public List<Plate> initPlate(){
		List<Plate> plates = new ArrayList<>();
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
	}
	
	
	/**
	 * 功能：取得板块在前台显示链接的前缀
	 * @param p
	 * @return
	 */
	private String getLinkPrefix(Plate p){
		switch(p.getLevel()){
			case 1: return "first";
			case 2: return "second";
			case 3: return "third";
			default:return "";
		}
	}
	
	/**
	 * 功能：取得要某级板块的显示个数
	 * @param level 板块级数
	 * @return
	 */
	private int getPlateShowCount(int level){
		return 8;
	}
	
	/**
	 * 功能：得到某板块下的叶子板块，并将叶子板块放在list列表中
	 * @param p 父板块
	 * @param list 叶子板块存储列表
	 */
	private void getLeafPlate(Plate p,List<Plate> list){
		
		List<Plate> childs = plateDao.getByPid(p.getId());
		
		if(childs.isEmpty()){
			list.add(p);
			return;
		}else{
			for(Plate cp : childs){
				getLeafPlate(cp,list);
			}
		}
	}
	/**
	 * 功能：取得某板块下在要展示的商品
	 * @param list 板块展示列表
	 * @param property 排序的属性
	 * @param count 取得的商品数量
	 */
	public List<PlateInfo> getPopularCommodity(List<PlateInfo> list,String property,int count){
		for(PlateInfo p : list){
			for(PlateInfo sp : p.getSubPlates()){
				List<Plate> leafPlates = new ArrayList<Plate>();
				getLeafPlate(sp.getPlate(),leafPlates);
				List<Commodity> commodities = commodityDao.getByPlates(leafPlates,property,count);
				sp.setCommodities(commodities);
			}
		}
		return list;
	}
}
