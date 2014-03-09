package com.line.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.model.Plate;
import com.line.web.model.dao.PlateDao;
import com.line.web.view.support.PlateInfo;

@Service
@Transactional
public class AppDataServiceImpl implements AppDataService {
	
	@Autowired
	private PlateDao plateDao;
	
	/**
	 * 功能：得到商场主页的板块信息。
	 */
	@Transactional(readOnly=true)
	@Override
	public List<PlateInfo> getIndexPlateInfo() {
		
		List<Plate> tPList = plateDao.getByShowSeq(null,getPlateShowCount(1));
		List<PlateInfo> platesInfo = new ArrayList<PlateInfo>();
		if(tPList.isEmpty()){
			tPList = initPlate();
		}
		for(Plate p : tPList){
			PlateInfo info = new PlateInfo(p);
			info.setLinkPrefix(getLinkPrefix(p));
			info.setSubPlate(getSubPlateInfo(p));
			platesInfo.add(info);
		}
		return platesInfo;
	}
	
	/**
	 * 功能：由父板块得到子版块的页面展示信息列表
	 * @param plate 父板块
	 * @return 子板块信息列表
	 */
	public List<PlateInfo> getSubPlateInfo(Plate plate){
		List<Plate> subPlates = (List<Plate>) plateDao.getByShowSeq(plate.getId(),getPlateShowCount(plate.getLevel()+1));
		List<PlateInfo> pInfo = new ArrayList<PlateInfo>();
		
		if(!subPlates.isEmpty()){
			for(Plate p : subPlates){
				PlateInfo info = new PlateInfo();
				info.setPlate(p);
				info.setLinkPrefix(getLinkPrefix(p));
				info.setSubPlate(getSubPlateInfo(p));
				pInfo.add(info);
			}
			return pInfo;
		}
		return null;
	}
	
	/**
	 * 功能：取得板块在前台显示链接的前缀
	 * @param p
	 * @return
	 */
	public String getLinkPrefix(Plate p){
		
		return null;
	}
	
	/**
	 * 功能：取得要某级板块的显示个数
	 * @param level 板块级数
	 * @return
	 */
	public int getPlateShowCount(int level){
		return 8;
	}
	
	/**
	 * 功能：为系统初始化数据
	 */
	@Override
	public void initData() {
		initPlate();
	}	
	
	/**
	 * 功能：初始化板块
	 * @return
	 */
	private List<Plate> initPlate(){
		List<Plate> plates = new ArrayList<>();
		String[] pNames = {"家具","珠宝","服装","图书","电子商品"};
		for(int i=0; i<pNames.length; i++){
			Plate plate = new Plate();
			plate.setName(pNames[i]);
			plate.setLevel(1);
			plateDao.save(plate);
//			Plate splate = new Plate();
//			splate.setName("子"+pNames[i]);
//			splate.setLevel(2);
//			splate.setParentPlate(plate);
//			plateDao.save(splate);
			plates.add(plate);
		}
		return plates;
	}
	
}
