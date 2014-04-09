package com.line.web.model.dao;

import org.springframework.stereotype.Repository;

import com.line.web.model.Shop;
import com.line.web.service.ShopService;

@Repository
public class ShopDaoImpl extends BasicDaoImpl<Shop> implements ShopDao {

	@Override
	public Shop findByName(String name) {
		return (Shop) getSession().createQuery("from Shop p where p.name = :name")
				.setParameter("name",name)
				.uniqueResult();
	}

}
