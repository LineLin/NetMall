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

@Entity
@Table(name="plate")
public class Plate {	

	public Plate() {
	}

	private String id;
	
	private String name;
	
	private int level;
	
	private int showSeq;
	
	private List<Plate> childPlate;

	private Plate parentPlate;
	
	@ManyToOne
	@JoinColumn(name="pid")
	public Plate getParentPlate() {
		return parentPlate;
	}
	
	public void setParentPlate(Plate parentPlate) {
		this.parentPlate = parentPlate;
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

	public int getShowSeq() {
		return showSeq;
	}

	public void setShowSeq(int showSeq) {
		this.showSeq = showSeq;
	}
}
