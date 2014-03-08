package com.line.web.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.line.web.model.Plate;

@Repository("plateDao")
@SuppressWarnings("unchecked")
public class PlateDaoImpl implements PlateDao {

	@Autowired
	private SessionFactory sf;
	
	/**
	 * 功能：得到某板块下{count}个按展示级别升序的板块,如果pPlate为null，那么返回一级板块,
	 * 		如果count == Integer.MAX_VALUE的话，那么返回符合条件的所有结果。
	 * @param pPlate 父板块
	 * @param count 取得的板块数
	 */
	@Override
	public List<Plate> getByShowSeq(String pid,int count) {
		
		String hql;
		if(pid == null){
			hql = "select p from Plate p where p.level = 1 order by p.showSeq";
		}else{
			hql = "select p from Plate p where p.pid ='" + pid
					+"' order by p.showSeq";
		}
		
		Query query = sf.getCurrentSession().createQuery(hql);
		
		if(count == Integer.MAX_VALUE){
			query.setFetchSize(count);
		}
		List<Plate> plates = query.list();
		
		return plates;
	}
	
	@Override
	public void save(Plate plate){
		sf.getCurrentSession().save(plate);
	}
	
	@Override
	public void del(String plateId){
		Session session = sf.getCurrentSession();
		Plate plate = (Plate) session.get(Plate.class,plateId);
		session.delete(plate);
	}
	
	@Override
	public void update(Plate plate){
		sf.getCurrentSession().update(plate);
	}
	
}
