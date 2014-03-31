package com.line.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.sys.SysSetting;
import com.line.web.utils.Page;
import com.line.web.view.support.PlateInfo;

@Service
@Transactional
public class AppDataServiceImpl implements AppDataService {
	
	public static final String COMMODITY_ORDER_PROPERTY = "sales";

	@Autowired
	private PlateService plateService;

	@Override
	public List<PlateInfo> getIndexPlateInfo(){
		return plateService.getIndexPlateInfo();
	}
	
	@Override
	public List<PlateInfo> getCommoShowList(List<PlateInfo>list,String property){
		
		if(property == null){
			property = AppDataServiceImpl.COMMODITY_ORDER_PROPERTY;
		}
		for(PlateInfo p : list){
			plateService.getPopularCommodity(p.getSubPlates(), property, SysSetting.getPageCommodityCount(Page.INDEX));
		}
		return list;
	}
}
