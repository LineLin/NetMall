package com.line.web.utils.enumtool;

public enum RoleEnum {
	
	SELLER("卖家"),BUYER("买家"),ROOT("超级账户"),SYS_ADMIN("系统管理员"),CONTENT_ADMIN("内容管理员");
	
	private  int type;
	
	private final String name;
	
	RoleEnum(String name){
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}
