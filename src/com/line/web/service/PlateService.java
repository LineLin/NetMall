package com.line.web.service;

import java.util.List;

import com.line.web.model.Commodity;
import com.line.web.model.Plate;
import com.line.web.utils.Page;
import com.line.web.view.support.PlateInfo;

public interface PlateService {
	
	public List<PlateInfo> getIndexPlateInfo();
	
	public List<PlateInfo> getSubPlateInfo(Plate plate,int deptch,Page page);
	
	public List<Plate> initPlate();
	
	public Plate getPlate(String id);
	
	public void getPopularCommodity(List<PlateInfo> list,String property,int count);
	
	public List<Commodity> getPageCommodity(Plate plate,String sortBy,boolean isDesc,int page,int pageSize);
		
}
