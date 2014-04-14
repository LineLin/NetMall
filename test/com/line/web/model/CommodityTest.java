package com.line.web.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.utils.Sys;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-common.xml" })  
@Transactional
public class CommodityTest {
	
	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	@Test
	public void testAddClassification(){
	
		Sys.echo("测试商品类添加分类信息");
		ClassItem item = new ClassItem("颜色");
		getSession().save(item);
		Classification kind = new Classification();
		kind.setClassItem(item);
		Commodity commodity = new Commodity();
		commodity.setName("立白");
		List<Classification> kinds = new ArrayList<Classification>();
		kinds.add(kind);
		commodity.setKinds(kinds);
		getSession().save(commodity);
		
		List<Commodity> coms = getSession().createQuery("from Commodity c").list();
		for(Commodity com : coms){
			Sys.echo("商品名：" + com.getName());
			Assert.assertEquals("立白",com.getName());
			Assert.assertNotNull(com.getKinds());
			Sys.echo("分类名：" + com.getKinds().get(0).getClassItem().getName());
			Assert.assertEquals("颜色",com.getKinds().get(0).getClassItem().getName());
		}
	}
}
