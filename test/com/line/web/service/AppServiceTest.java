package com.line.web.service;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.view.support.PlateInfo;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-*.xml"})  
public class AppServiceTest {
	
	@Autowired
	AppDataService appService;
	
	@Test
	public void testGetPlateInfo(){
		List<PlateInfo> lists = appService.getIndexPlateInfo();
		for(PlateInfo info : lists){
			print(info);
		}
	}

	public void print(PlateInfo p){
		System.out.println("pName --->" + p.getPlate().getName());
		System.out.println("plevel---->" + p.getPlate().getLevel());
		System.out.println("linkPrefix---->" + p.getLinkPrefix());
		if(p.getSubPlate() != null){
			for(PlateInfo info : p.getSubPlate()){
				print(info);
			}
		}
	}
}
