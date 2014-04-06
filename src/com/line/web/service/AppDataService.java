package com.line.web.service;

import java.util.List;

import com.line.web.view.support.PlateInfo;

public interface AppDataService {
	
	 List<PlateInfo> getIndexPlateInfo();
	
	 List<PlateInfo> getCommoShowList(List<PlateInfo>list,String property);
}
