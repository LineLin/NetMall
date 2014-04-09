package com.line.web.view.support;

import org.springframework.web.multipart.MultipartFile;

import com.line.web.model.ClassificationValue;

public class CommodityForm {
	
	private String name;
	
	private String comDescription;
	
	private MultipartFile photo;
	
	private String plateId;
	
//	private String multipart;
	
//	private String[] 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComDescription() {
		return comDescription;
	}

	public void setComDescription(String comDescription) {
		this.comDescription = comDescription;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getPlateId() {
		return plateId;
	}

	public void setPlateId(String plateId) {
		this.plateId = plateId;
	}

//	public ClassificationValue getValue() {
//		return value;
//	}
//
//	public void setValue(ClassificationValue value) {
//		this.value = value;
//	}
}
