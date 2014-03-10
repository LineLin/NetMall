package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.Commodity;

public interface CommodityDao {
	
	public Commodity getById(String id);
	
	public List<Commodity> getByPlate(String plateId);
	
	public List<Commodity> getByPlate(String plateId,int count);
	
	public List<Commodity> getListWithOrder(String plateId,int count,String orderName,boolean isDisc);
}
