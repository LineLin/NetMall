package com.line.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.model.Plate;
import com.line.web.model.dao.PlateDao;

@Service
@Transactional
public class AppDataServiceImpl implements AppDataService {
	
	@Autowired
	private PlateDao plateDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Plate> getTopLevelPlate() {
		return plateDao.getTopLevelPlate();
	}
	
	/**
	 * 功能：为系统初始化数据
	 */
	@Override
	public void initData() {
		initPlate();
	}	
	
	private void initPlate(){
		
		List<Plate> plates = new ArrayList<>();
		String[] pNames = {"家具","珠宝","服装","图书","电子商品"};
		for(int i=0; i<pNames.length; i++){
			Plate plate = new Plate();
			plate.setName(pNames[i]);
			plate.setLevel(1);
			plateDao.savePlate(plate);
			plates.add(plate);
		}
	}

	@Transactional(readOnly=true)
	@Override
	public List<Plate> getSubPlate(Plate parentPlate) {
		return null;
	}
	
}
