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
	
	private final int COUNT_OF_FIRST_LEVEL_PLATE = 8;
	
	private final int COUNT_OF_SECOND_LEVEL_PLATE = 8;
	
	private final int COUNT_OF_THIRD_LEVEL_PLATE = 8;
	
	/**
	 * 功能：得到商场主页的板块信息。
	 */
	@Transactional(readOnly=true)
	@Override
	public List<PlateInfo> getIndexPlateInfo() {
		
		List<Plate> tPList = plateDao.getByShowSeq(null,COUNT_OF_FIRST_LEVEL_PLATE);
		List<PlateInfo> platesInfo = new ArrayList<PlateInfo>();
		if(tPList.isEmpty()){
			tPList = initPlate();
		}else{
			for(Plate p : tPList){
				List<Plate> subPlates = plateDao.getByShowSeq(p.getId(),COUNT_OF_SECOND_LEVEL_PLATE);
				List<PlateInfo> subInfo = new ArrayList<PlateInfo>(); 
				for(Plate sp : subPlates){
					List<Plate> thirdPlates = plateDao.getByShowSeq(sp.getId(),COUNT_OF_THIRD_LEVEL_PLATE);
					List<PlateInfo> thirdInfo = new ArrayList<PlateInfo>();
					for(Plate tp : thirdPlates){
						PlateInfo temp = new PlateInfo();
						temp.setLinkPrefix("third");
						temp.setPlate(tp);
						temp.setSubPlate(null);
						thirdInfo.add(temp);
					}
					PlateInfo s = new PlateInfo();
					s.setPlate(sp);
					s.setSubPlate(thirdInfo);
					s.setLinkPrefix("second");
					subInfo.add(s);
				}
				PlateInfo pInfo = new PlateInfo();
				pInfo.setPlate(p);
				pInfo.setSubPlate(subInfo);
				pInfo.setLinkPrefix("first");
				platesInfo.add(pInfo);
			}
		}
		return platesInfo;
	}
	
	/**
	 * 功能：为系统初始化数据
	 */
	@Override
	public void initData() {
		initPlate();
	}	
	
	//初始化板块
	private List<Plate> initPlate(){
		List<Plate> plates = new ArrayList<>();
		String[] pNames = {"家具","珠宝","服装","图书","电子商品"};
		for(int i=0; i<pNames.length; i++){
			Plate plate = new Plate();
			plate.setName(pNames[i]);
			plate.setLevel(1);
			plateDao.save(plate);
			plates.add(plate);
		}
		return plates;
	}
	
}
