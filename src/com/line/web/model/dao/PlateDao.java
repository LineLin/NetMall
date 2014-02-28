package com.line.web.model.dao;

import java.util.List;

import com.line.web.model.Plate;

public interface PlateDao {
	
	public List<Plate> getTopLevelPlate();
	
	public void savePlate(Plate plate);
}
