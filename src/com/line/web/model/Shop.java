package com.line.web.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shop")
public class Shop {
	
	//商店状态枚举类
	static public enum ShopStatus{
		AUDIT("待审核"),NORMAL("正常"),BAN("封禁");
		
		private final String status;
		
		ShopStatus(String status){
			this.status = status;
		}
		
		public String getStatus(){
			return status;
		}
	}
	
	//主键ID
	private String id;
	
	//店铺名
	private String name;
	
	//信誉星级
	private int start;
	
	//店铺的描述
	private String description;
	
	//创建时间
	private Date createDate;
	
	//店铺状态
	private ShopStatus status;
	
	//店铺商品
	private List<Commodity> commoidities;
	
	//店铺所属的用户
	private User shopKeeper;
	
	@Id
	@GeneratedValue(generator="sd")
	@GenericGenerator(name="sd",strategy="uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name="user_id")
	public User getShopKeeper() {
		return shopKeeper;
	}
	
	public void setShopKeeper(User shopKeeper) {
		this.shopKeeper = shopKeeper;
	}
	
	@Column(unique=true,nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(columnDefinition="int default 0")
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	@OneToMany(mappedBy="enjoinShop")
	public List<Commodity> getCommoidities() {
		return commoidities;
	}

	public void setCommoidities(List<Commodity> commoidities) {
		this.commoidities = commoidities;
	}

	public ShopStatus getStatus() {
		return status;
	}

	public void setStatus(ShopStatus status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
