package com.line.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.model.Commodity;
import com.line.web.model.dao.CommodityDao;

@Service
@Transactional
public class CommodityService {
	
	@Autowired
	private CommodityDao commodityDao;
	
	public void addCommodity(Commodity commodity){
		commodityDao.save(commodity);
	}
}
