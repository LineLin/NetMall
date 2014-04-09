package com.line.web.service;

import java.util.List;

import com.line.web.model.Commodity;
import com.line.web.model.Plate;
import com.line.web.utils.enumtool.Page;
import com.line.web.view.support.PlateInfo;

public interface PlateService {
	
	 List<PlateInfo> getIndexPlateInfo();
	
	 List<PlateInfo> getSubPlateInfo(Plate plate,int deptch,Page page);
	
	 List<Plate> initPlate();
	
	 Plate getPlateById(String id);
	 
	 List<Plate> getByParentPlate(String parentId);
	 
	 List<Plate> getPlateByLevel(int level);
	
	 void getPopularCommodity(List<PlateInfo> list,String property,int count);
	
	 List<Commodity> getPageCommodity(Plate plate,String sortBy,boolean isDesc,int page,int pageSize);
		
}
