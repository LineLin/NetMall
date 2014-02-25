package com.line.web.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.line.web.model.Plate;

@Repository("plateDao")
public class PlateDaoImpl implements PlateDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Plate> getTopLevelPlate() {
		
		String hql = "select p from Plate p where p.level=1";
		List<Plate> plates = sf.getCurrentSession().createQuery(hql).list();
		return plates;
	}
	
	@Override
	public void addPlate(Plate plate){
		sf.getCurrentSession().save(plate);
	}
}
