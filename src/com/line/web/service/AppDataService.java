package com.line.web.service;

import java.util.List;

import com.line.web.model.Plate;

public interface AppDataService {
	
	public void initData();
	
	public List<Plate> getTopLevelPlate();
	
	public List<Plate> getSubPlate(Plate parentPlate);
	
//	public List<>
}
