package com.line.web.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-common.xml" })  
@Transactional
public class PlateTest{
	
	@Autowired
	private SessionFactory sf;
	
	@Test
	public void testAddPlate(){
			Session session = sf.getCurrentSession();
			int i;
			for(i=0; i<10; i++){
				Plate p = new Plate();
				p.setName("板块"+i+1);
				p.setLevel(1);
				session.save(p);
			}
	}

}
