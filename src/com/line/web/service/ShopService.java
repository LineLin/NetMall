package com.line.web.service;

import com.line.web.model.Shop;

public interface ShopService {
	boolean checkShopInfo(Shop shop);
	
	void saveShop(Shop shop);
	
//	void initShopDefaultInfo(Shop shop);
}
