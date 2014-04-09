package com.line.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orderform")
public class OrderForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public OrderForm() {
	}

	public OrderForm(String id) {
		this.id = id;
	}

	private String id;
	
	private int count;
	
	private double price;
	
	private Date createTime;
	
	private Commodity enjoinCommodity;
	
	private User buyer;
	
	private Evaluate evaluate;
	
	@Id
	@GeneratedValue(generator="sd")
	@GenericGenerator(name="sd",strategy="uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@ManyToOne
	@JoinColumn(name="commodiy_id")
	public Commodity getEnjoinCommodity() {
		return enjoinCommodity;
	}

	public void setEnjoinCommodity(Commodity enjoinCommodity) {
		this.enjoinCommodity = enjoinCommodity;
	}

	@ManyToOne
	@JoinColumn(name="buyer_id")
	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@OneToOne
	public Evaluate getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(Evaluate evaluate) {
		this.evaluate = evaluate;
	}
}
