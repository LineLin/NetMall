package com.line.web.view.support;

import java.util.List;
import com.line.web.model.Plate;

public class PlateInfo {
	
	private Plate plate;
	
	private String linkPrefix;
	
	private List<PlateInfo> subPlate;
	
	public PlateInfo(){}
	
	public PlateInfo(Plate plate){
		this.plate = plate;
	}

	public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	public String getLinkPrefix() {
		return linkPrefix;
	}

	public void setLinkPrefix(String linkPrefix) {
		this.linkPrefix = linkPrefix;
	}

	public List<PlateInfo> getSubPlate() {
		return subPlate;
	}

	public void setSubPlate(List<PlateInfo> subPlate) {
		this.subPlate = subPlate;
	}	
	
}
