package com.line.web.view.support;

import org.springframework.web.multipart.MultipartFile;

import com.line.web.model.ClassificationValue;

public class CommodityForm {
	
	private String name;
	
	private String comDescription;
	
	private MultipartFile photo;
	
	private String plateId;
	
	private MultipartFile[] classValueImage;
	
	private int[] count;
	
	private String[] classitemId;
	
	private String[] classValue;
	
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

	public MultipartFile[] getClassValueImage() {
		return classValueImage;
	}

	public void setClassValueImage(MultipartFile[] classValueImage) {
		this.classValueImage = classValueImage;
	}

	public int[] getCount() {
		return count;
	}

	public void setCount(int[] count) {
		this.count = count;
	}

	public String[] getClassitemId() {
		return classitemId;
	}

	public void setClassitemId(String[] classitemId) {
		this.classitemId = classitemId;
	}

	public String[] getClassValue() {
		return classValue;
	}

	public void setClassValue(String[] classValue) {
		this.classValue = classValue;
	}

}
