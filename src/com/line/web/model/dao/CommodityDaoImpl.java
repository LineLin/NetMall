package com.line.web.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.line.web.model.Commodity;
import com.line.web.model.Plate;

@Repository
@SuppressWarnings("unchecked")
public class CommodityDaoImpl extends BasicDaoImpl<Commodity> implements CommodityDao {
	
	/**
	 * 功能：通过id查找商品 
	 */
	@Override
	public Commodity getById(String id) {
		Commodity com =(Commodity) sf.getCurrentSession().get(Commodity.class,id); 
		return com;
	}
	
	/**
	 * @param plate 所属板块的id
	 * @return 板块下所有的商品
	 */
	@Override
	public List<Commodity> getByPlate(Plate plate) {
		
		return getByPlate(plate,Integer.MAX_VALUE);
	}
	
	/**
	 * @param plate 父板块
	 * @count 要取得的商品数
	 * @return 目标商品列表
	 */
	@Override
	public List<Commodity> getByPlate(Plate plate,int count) {
		String hql = "select c from Commodity c where c.enjoinPlate =:plate";
		return sf.getCurrentSession().createQuery(hql)
				.setParameter("plate",plate)
				.setFirstResult(0)
				.setMaxResults(count)
				.list();
	}
	
	/**
	 * 功能：取得某个板块下按某个关键字排列的count个商品
	 * @param plate 所属板块id
	 * @param count 取得的商品数
	 * @param property 排序关键字，注意，property必须是Commodity里的属性名。
	 * @param isDisc 是否降序排列
	 */
	@Override
	public List<Commodity> getListWithOrder(Plate plate,int count,String property,boolean isDesc){
		String hql = "select c from Commodity c where c.enjoinPlate =:plate order by :property";
		if(isDesc){
			hql += " desc";
		}
		
		return sf.getCurrentSession().createQuery(hql)
				.setParameter("plate",plate)
				.setParameter("property","c."+property)
				.setFirstResult(0)
				.setMaxResults(count)
				.list();
	}

	/**
	 * @param plate 父板块
	 * @param count 数量
	 * @param property 排序字段
	 */
	@Override
	public List<Commodity> getListWithOrder(Plate plate, int count,
			String property) {
		return getListWithOrder(plate,count,property,false);
	}

	/**
	 * 功能:取得某些板块下的商品列表
	 * @param plates 父板块列表
	 * @param count 要取得的商品数
	 * @param property 排序字段
	 * @param isDesc 是否倒序排序
	 * @return 目标商品列表
	 */
	@Override
	public List<Commodity> getByPlates(List<Plate> plates, String property,int count,
			boolean isDesc) {
		String hql = "select c from Commodity c where c.enjoinPlate in ( ";
		for(Plate p : plates){
			hql += "'" + p.getId() + "',";
		}
		hql = hql.substring(0, hql.lastIndexOf(",")) + ") order by c."+property;
		if(isDesc){
			hql += " desc"; 
		}
		return sf.getCurrentSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(count)
				.list();
	}

	@Override
	public List<Commodity> getByPlates(List<Plate> plates,String property,int count) {
		return getByPlates(plates,property,count,false);
	}
	/**
	 * @param plate 父板块
	 * @param page 请求页面数
	 * @param pageSize 每页显示的数量
	 * @param sortBy 排序字段
	 * @param sort 排序
	 */
	@Override
	public List<Commodity> getByPlate(Plate plate, int page, int pageSize,
			String sortBy, boolean isDesc) {
		String hql = "from Commodity c where c.enjoinPlate = :plate";
		if(sortBy != null){
			hql += " order by c." + sortBy;
		}
		if(isDesc){
			hql += " desc";
		}
		return sf.getCurrentSession().createQuery(hql)
				.setParameter("plate",plate)
				.setFirstResult((page-1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}

}
