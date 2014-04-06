package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.Plate;

public interface PlateDao extends BasicDao<Plate>{
	
//	 void save(Plate plate);
	
	 List<Plate> getPlateOrderByShowSeq(String pid,int count);
	
	 List<Plate> getByLevel(int level);
	
//	 void del(String plateId);
	
//	 void update(Plate plate);
	
	 Plate getById(String id);
	
	 List<Plate> getByPid(Plate parent);
	
	 List<Plate> getLeafPlate(Plate plate);
	
}
