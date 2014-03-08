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
@Table(name="commodity")
public class Commodity {
	
	private String id;
	
	//商品名
	private String name;
	
	//价格
	private double price;
	
	//库存
	private int stock;
	
	//销量
	private int sales;
	
	//图片
	private String image;

	//描述
	private String description;
	
	//所属商店
	private Shop enjoinShop;
	
	//所属板块
	private Plate enjoinPlate;
	
	//特别属性
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@ManyToOne
	@JoinColumn(name="plate_id")
	public Plate getEnjoinPlate() {
		return enjoinPlate;
	}

	public void setEnjoinPlate(Plate enjoinPlate) {
		this.enjoinPlate = enjoinPlate;
	}

}
