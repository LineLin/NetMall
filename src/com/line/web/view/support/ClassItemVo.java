package com.line.web.view.support;

public class ClassItemVo {
	public String name;
	
	public String id;
	
	public ClassItemVo(){
		
	}
	
	public ClassItemVo(String id,String name){
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
