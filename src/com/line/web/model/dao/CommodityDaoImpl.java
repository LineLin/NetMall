package com.line.web.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.line.web.model.Commodity;

@Repository
@SuppressWarnings("unchecked")
public class CommodityDaoImpl implements CommodityDao {
	
	@Autowired
	private SessionFactory sf;
	
	/**
	 * 功能：通过id查找商品 
	 */
	@Override
	public Commodity getById(String id) {
		Commodity com =(Commodity) sf.getCurrentSession().get(Commodity.class,id); 
		return com;
	}
	
	/**
	 * @param plateId 所属板块的id
	 * @return 板块下所有的商品
	 */
	@Override
	public List<Commodity> getByPlate(String plateId) {
		
		return getByPlate(plateId,Integer.MAX_VALUE);
	}
	
	@Override
	public List<Commodity> getByPlate(String plateId,int count) {
		String hql = "select c from Commodity c where c.enjoinPlate =?1";
	
		return sf.getCurrentSession().createQuery(hql)
				.setParameter("1",plateId)
				.setFetchSize(count)
				.list();
	}
	
	/**
	 * 功能：取得某个板块下按某个关键字排列的count个商品
	 * @param plateId 所属板块id
	 * @param count 取得的商品数
	 * @param orderName 排序关键字，注意，orderName必须是Commodity里的属性名。
	 * @param isDisc 是否降序排列
	 */
	@Override
	public List<Commodity> getListWithOrder(String plateId,int count,String orderName,boolean isDisc){
		String hql = "select c from Commodity c where c.enjoinPlate =?1 order by c." + orderName;
		if(isDisc){
			hql += " disc";
		}
		
		return sf.getCurrentSession().createQuery(hql)
				.setParameter("1",plateId)
				.setFetchSize(count)
				.list();
	}

}
