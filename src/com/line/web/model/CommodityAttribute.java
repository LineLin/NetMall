package com.line.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 商品的订制属性，适用于不同商品拥有丰富的属性。
 * @author line
 */
@Entity
@Table(name="commodity_attr")
public class CommodityAttribute {
	
	public CommodityAttribute() {
	}

	public CommodityAttribute(String id) {
		this.id = id;
	}

	private String id;
	
	private String name;
	
	private String value;
	
	@Id
	@GeneratedValue(generator="sd")
	@GenericGenerator(name="sd",strategy="uuid")
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
