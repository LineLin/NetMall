package com.line.web.model;

import junit.framework.TestCase;

import org.hibernate.Session;

import com.line.web.utils.HibernateUtil;

public class CommodityTest extends TestCase {
	private Session session;
	
	//测试添加商品实例。
	public void testAddCommo(){
		
		Shop shop = new Shop();
		shop.setName("Line");
		
		Commodity com = new Commodity();
		
		com.setName("猪肉");
		com.setPrice(11);
		com.setEnjoinShop(shop);
		
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(shop);
			session.save(com);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.close(session);
		}
	}
	
	public void testGetCom(){
		
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			Commodity com = (Commodity) session.createQuery("from Commodity com where com.name = ? ")
						.setParameter(0, "猪肉")
						.uniqueResult();
			assertNotNull(com);
			assertEquals(com.getName(),"猪肉");
			assertEquals(com.getEnjoinShop().getName(),"Line");
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.close(session);
		}
		
	}
	
}
