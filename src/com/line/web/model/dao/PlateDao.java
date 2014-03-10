package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.Plate;

public interface PlateDao {
	
	public void save(Plate plate);
	
	public List<Plate> getPlateOrderByShowSeq(String pid,int count);
	
	public void del(String plateId);
	
	public void update(Plate plate);
	
	public Plate findById(String id);
	
}
