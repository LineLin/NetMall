package com.line.web.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 商品的订制属性，适用于不同商品拥有丰富的属性。
 * @author line
 *
 */
@Entity
@Table(name="commodity_attr")
public class CommodityAttribute {
	
	private String id;
	
	private String name;
	
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
