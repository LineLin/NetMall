package com.line.web.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="plate")
public class Plate {	
	
	private String id;
	//板块名
	private String name;
	//板块类型
	private int level;
	//板块显示级别
	private int showSeq;
	
	private String path;
	
	//从属版块
	private List<Plate> childPlate;
	//所属板块
	private Plate parentPlate;
	

	public Plate() {
	}
	
	public Plate(String name,int level,int showSeq){
		this(name,level);
		this.showSeq = showSeq;
	}
	
	public Plate(String name,int level){
		this.name = name;
		this.level = level;
	}
	
	@ManyToOne
	@JoinColumn(name="pid")
	public Plate getParentPlate() {
		return parentPlate;
	}
	
	public void setParentPlate(Plate parentPlate) {
		this.parentPlate = parentPlate;
		
		if(parentPlate == null) return ;
		
		if(parentPlate.path != null){
			setPath(parentPlate.path + "-" + parentPlate.id);
		}else{
			setPath("-" + parentPlate.id);
		}
		
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
	
	@OneToMany(mappedBy="parentPlate")
	public List<Plate> getChildPlate() {
		return childPlate;
	}

	public void setChildPlate(List<Plate> childPlate) {
		this.childPlate = childPlate;
	}

	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Column(columnDefinition="int default 0")
	public int getShowSeq() {
		return showSeq;
	}

	public void setShowSeq(int showSeq) {
		this.showSeq = showSeq;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath(){
		return this.path;
	}
}
