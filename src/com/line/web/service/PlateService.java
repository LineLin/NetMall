package com.line.web.service;

import java.util.List;

import com.line.web.model.Plate;
import com.line.web.view.support.PlateInfo;

public interface PlateService {
	
	public List<PlateInfo> getIndexPlateInfo();
	
	public List<Plate> initPlate();
	
	public Plate getPlate(String id);
}
