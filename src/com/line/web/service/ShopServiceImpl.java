package com.line.web.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.model.Shop;
import com.line.web.model.dao.ShopDao;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	
	/**
	 * @param shop 店铺信息
	 * @return true 当店铺信息符合基本要求时。
	 */
	@Override
	public boolean checkShopInfo(Shop shop) {
		return shopDao.findByName(shop.getName())  == null ? true : false;
	}
	
	@Override
	public void saveShop(Shop shop) {
		shop.setCreateDate(new Date());
		shop.setStatus(Shop.ShopStatus.AUDIT);
	    shopDao.save(shop);
	}
	
}
