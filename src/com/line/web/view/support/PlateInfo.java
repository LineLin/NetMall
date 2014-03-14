package com.line.web.view.support;

import java.util.List;

import com.line.web.model.Commodity;
import com.line.web.model.Plate;

public class PlateInfo {
	
	private Plate plate;
	
	private String linkPrefix;
	
	private List<PlateInfo> subPlates;
	
	private List<Commodity> commodities;
	
	private int listSize;
	
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

	public List<PlateInfo> getSubPlates() {
		return subPlates;
	}

	public void setSubPlates(List<PlateInfo> subPlates) {
		this.subPlates = subPlates;
		if(subPlates != null){
			this.listSize = subPlates.size();
		}else{
			this.listSize = 0;
		}
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}	
	
}
