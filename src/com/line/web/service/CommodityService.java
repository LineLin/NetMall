package com.line.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.model.ClassItem;
import com.line.web.model.Classification;
import com.line.web.model.ClassificationValue;
import com.line.web.model.Commodity;
import com.line.web.model.Shop;
import com.line.web.model.dao.ClassItemDao;
import com.line.web.model.dao.ClassificationDaoImpl;
import com.line.web.model.dao.ClassificationValueDao;
import com.line.web.model.dao.CommodityDao;

@Service
@Transactional
public class CommodityService {
	
	private static final int MAIL_COMMODITY_SHOW_PAGE_SZIE = 20;
	
	private final int page_start_index = 1;
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	private ClassItemDao classItemDao;
	
	@Autowired
	private ClassificationDaoImpl classificationDao;
	
	@Autowired
	private ClassificationValueDao clzValueDao;
	
	public void saveCommodity(Commodity commodity){
		commodityDao.save(commodity);
	}
	
	public List<Commodity> getCommoditiesByShop(Shop shop){
		return getCommoditiesByShop(shop,page_start_index);
	}
	
	public List<Commodity> getCommoditiesByShop(Shop shop,int page){
		return commodityDao.getByShop(shop, page, MAIL_COMMODITY_SHOW_PAGE_SZIE);
	}
	
	public void updateCommodityInfo(Commodity commodity){
		commodityDao.update(commodity);
	}
	
	public ClassItem getClassItemById(String id){
		return classItemDao.getById(id);
	}
	
	public List<ClassItem> getAllClassItem(){
		return classItemDao.getAll();
	}
	
	public void saveClassification(Classification csfc){
		classificationDao.save(csfc);
	}
	
	public void saveClassificationValue(ClassificationValue value){
		clzValueDao.save(value);
	}
}
