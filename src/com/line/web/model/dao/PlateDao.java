package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.Plate;

public interface PlateDao {
	
	public void save(Plate plate);
	
	public List<Plate> getByShowSeq(String pid,int count);
	
	public void del(String plateId);
	
	public void update(Plate plate);
}
