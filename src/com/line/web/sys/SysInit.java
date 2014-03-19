package com.line.web.sys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.model.Plate;
import com.line.web.model.dao.PlateDao;

@Transactional
public class SysInit {
	
	@Autowired
	private static PlateDao plateDao;
	
	public static List<Plate> initIndexPlates(){
		String[] pNames = {"家具","珠宝","服装","图书","化妆品","电脑办公","虚拟币","生活服务"};
		List<Plate> list = new ArrayList<Plate>();
		for(int i=0; i<pNames.length; i++){
			Plate plate = new Plate(pNames[i],1);
			plateDao.save(plate);
			list.add(plate);
		}
		addSecondPlate(list);
		addDefaultThirdPlate();
		return list;
	}
	
	public static void addSecondPlate(List<Plate> fPlates){
		String[][] names = {{"客厅家具","餐厅家具","卧室家具","床","书房家具"},
				{"翡翠","黄金","白银","砖石","水晶"},
				{"女装","儿装","男装","大肚装"},
				{"人文社科","人物传记","教育","文艺","辅导书","儿童书"},
				{"爽肤水","粉底","睫毛膏","祛痘","面膜","口红"},
				{"平板","台式电脑","电脑配件","电脑外设"},
				{"充值","购物"},
				{"彩票","教育培训","餐饮美食","休闲娱乐","电影演出"}};
		for(int i=0; i<fPlates.size(); i++){
			for(int j=0; j<names[i].length;j++){
				Plate p = new Plate();
				p.setName(names[i][j]);
				p.setParentPlate(fPlates.get(i));
				p.setLevel(2);
				plateDao.save(p);
			}
		}
	}
	
	public static void addDefaultThirdPlate(){
		List<Plate> list = plateDao.getByLevel(2);
		for(Plate p : list){
			int j = 20;
			while(j-- != 0){
				Plate temp = new Plate("测试",3);
				temp.setParentPlate(p);
				plateDao.save(temp);
			}
		}
	}
	
	public static void main(){
		
	}
}
