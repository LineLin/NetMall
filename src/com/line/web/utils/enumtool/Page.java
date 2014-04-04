package com.line.web.utils.enumtool;

import com.line.web.sys.SysSetting;

public enum Page {
	INDEX("index"), FIRSR("first"),SECOND("second"),THIRD("third");
	private String name;
	Page(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPlateShowCount(String level){
		return SysSetting.getPagePlateCount(this, level);
	}
	
	public static Page getPageOfNmae(String name){
		for(Page p : values()){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	
}
