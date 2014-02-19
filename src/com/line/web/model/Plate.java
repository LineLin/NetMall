package com.line.web.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Plate")
public class Plate {
	
	private String id;
	
	private String name;
	
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
}
