package com.line.web.service;

import java.util.List;

import com.line.web.view.support.PlateInfo;

public interface AppDataService {
	
	public List<PlateInfo> getIndexPlateInfo();
	
	public List<PlateInfo> getCommoShowList(List<PlateInfo>list,String property);
}
