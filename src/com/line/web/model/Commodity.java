package com.line.web.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Comoidty")
public class Commodity {
	
	private String id;
	
	private String name;
	
	private double price;
	
	private int stock;
	
	private int sales;

	private String description;
	
	private Shop enjoinShop;
	
	private List<CommodityAttribute> attributes; 
	
	@ManyToOne
	@JoinColumn(name="shop_id")
	public Shop getEnjoinShop() {
		return enjoinShop;
	}

	public void setEnjoinShop(Shop enjoinShop) {
		this.enjoinShop = enjoinShop;
	}

	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Id
	@GeneratedValue(generator="sd")
	@GenericGenerator(name="sd",strategy="assign")
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}
	
	@ManyToMany
	@JoinTable(name="com_ref_attr",
		joinColumns={@JoinColumn(name="com_id")},
		inverseJoinColumns={@JoinColumn(name="attr_id")}
	)
	public List<CommodityAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<CommodityAttribute> attributes) {
		this.attributes = attributes;
	}
	
}
