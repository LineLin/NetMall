package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.Commodity;
import com.line.web.model.Plate;
import com.line.web.model.Shop;

public interface CommodityDao extends BasicDao<Commodity>{
	 
	 List<Commodity> getAll();
	 
	 List<Commodity> getByShop(Shop shop,int page,int pageSize);
	
	 List<Commodity> getByPlate(Plate plateId);
	
	 List<Commodity> getByPlate(Plate plateId,int count);
	
	 List<Commodity> getByPlate(Plate plate,int page,int pageSize,String sortBy,boolean isDesc);
	
	 List<Commodity> getListWithOrder(Plate plateId,int count,String property,boolean isDesc);

	 List<Commodity> getListWithOrder(Plate plateId,int count,String property);
	
	 List<Commodity> getByPlates(List<Plate> plates,String property,int count,boolean isDesc);
	
	 List<Commodity> getByPlates(List<Plate> plates,String property,int count);
}
