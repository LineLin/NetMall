package com.line.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="classification_value")
public class ClassificationValue {
	
	private String id;
	
	private String description;
	
	private String image;
	
	private Classification classification;

	@Id
	@GeneratedValue(generator="sd")
	@GenericGenerator(name="sd",strategy="uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="class_description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="image_path")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@ManyToOne
	@JoinColumn(name="classification_id")
	public Classification getClassification() {
		return classification;
	}
	
	public void setClassification(Classification classification) {
		this.classification = classification;
	}
	
}
