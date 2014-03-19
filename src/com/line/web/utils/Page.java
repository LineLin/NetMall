package com.line.web.utils;

public enum Page {
	INDEX("index"), ITEMLIST("itemlist");
	private String name;
	Page(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
