package com.line.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.view.support.PlateInfo;

@Service
@Transactional
public class AppDataServiceImpl implements AppDataService {
	
	public static final String COMMODITY_DEFAULT_PROPERTY = "sales";
	@Autowired
	private PlateService plateService;
	/**
	 * 功能：为系统初始化数据
	 */
	@Override
	public void initData() {
		plateService.initPlate();
	}	
	
	@Override
	public List<PlateInfo> getIndexPlateInfo(){
		return plateService.getIndexPlateInfo();
	}
	
	public List<PlateInfo> getCommoShowList(List<PlateInfo>list,String property){
		if(property == null){
			property = AppDataServiceImpl.COMMODITY_DEFAULT_PROPERTY;
		}
		return plateService.getPopularCommodity(list, property, 8);
	}
}
