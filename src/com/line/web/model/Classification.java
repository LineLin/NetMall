package com.line.web.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 商品的订制属性，适用于不同商品拥有丰富的属性。
 * @author line
 */
@Entity
@Table(name="classification")
public class Classification {
	
	private String id;
	
	private ClassItem classItem;
	
	private List<ClassificationValue> values;
	
	private Commodity commodity;
	
	@Id
	@GeneratedValue(generator="sd")
	@GenericGenerator(name="sd",strategy="uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="classitem_id")
	public ClassItem getClassItem() {
		return classItem;
	}

	public void setClassItem(ClassItem classItem) {
		this.classItem = classItem;
	}
	
	@ManyToOne
	@JoinColumn(name="commodity_id")
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@OneToMany(mappedBy="classification")
	public List<ClassificationValue> getValues() {
		return values;
	}

	public void setValues(List<ClassificationValue> values) {
		this.values = values;
	}
}
