package com.line.web.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="commodity")
public class Commodity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	
	//商品销售类种
	private List<Classification> kinds;
	
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
	
	@OneToMany(mappedBy="commodity")
	public List<Classification> getKinds() {
		return kinds;
	}

	public void setKinds(List<Classification> kinds) {
		this.kinds = kinds;
	}

}
