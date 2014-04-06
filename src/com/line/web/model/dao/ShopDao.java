package com.line.web.model.dao;

import com.line.web.model.Shop;

public interface ShopDao extends BasicDao<Shop> {
	
	 Shop findByName(String name);
}
