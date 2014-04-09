package com.line.web.view.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.line.web.model.Plate;

public class PlateVo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	public PlateVo(){
	}
	
	public PlateVo(String id,String name){
		this.id = id;
		this.name = name;
	}

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
	
	public static List<PlateVo> converToVo(List<Plate> plates){
		List<PlateVo> platesVo = new ArrayList<PlateVo>();
		for(Plate p : plates){
			PlateVo vo = new PlateVo(p.getId(),p.getName());
			platesVo.add(vo);
		}
		return platesVo;
	}
}
