package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.Commodity;
import com.line.web.model.Plate;

public interface CommodityDao {
	
	public Commodity getById(String id);
	
	public List<Commodity> getByPlate(String plateId);
	
	public List<Commodity> getByPlate(String plateId,int count);
	
	public List<Commodity> getListWithOrder(String plateId,int count,String property,boolean isDesc);

	public List<Commodity> getListWithOrder(String plateId,int count,String property);
	
	public List<Commodity> getByPlates(List<Plate> plates,String property,int count,boolean isDesc);
	
	public List<Commodity> getByPlates(List<Plate> plates,String property,int count);
}
