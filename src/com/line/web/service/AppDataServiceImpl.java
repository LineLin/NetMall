package com.line.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.view.support.PlateInfo;

@Service
@Transactional
public class AppDataServiceImpl implements AppDataService {
	
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
}
