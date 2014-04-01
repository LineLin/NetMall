package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.Commodity;
import com.line.web.model.Plate;

public interface CommodityDao extends BasicDao<Commodity>{
	
	public Commodity getById(String id);
	
	public List<Commodity> getByPlate(Plate plateId);
	
	public List<Commodity> getByPlate(Plate plateId,int count);
	
	public List<Commodity> getByPlate(Plate plate,int page,int pageSize,String sortBy,boolean isDesc);
	
	public List<Commodity> getListWithOrder(Plate plateId,int count,String property,boolean isDesc);

	public List<Commodity> getListWithOrder(Plate plateId,int count,String property);
	
	public List<Commodity> getByPlates(List<Plate> plates,String property,int count,boolean isDesc);
	
	public List<Commodity> getByPlates(List<Plate> plates,String property,int count);
}
