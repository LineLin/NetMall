package com.line.web.model;

import java.util.List;

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
	
	public void testAddWithPlate(){
		String[] images = {"003.png","005.jpg","com.jpg","ad.jpg"};
		try{
			Session session = HibernateUtil.getSession();
			String hql = "select p from Plate p where p.level=3";
			session.beginTransaction();
			List<Plate> lists = (List<Plate>) session.createQuery(hql).list();
			for(Plate p : lists){
				int i = 5;
				while(i-- != 0){
					Commodity comm = new Commodity();
					comm.setName("风衣");
					comm.setDescription("超薄舒适");
					comm.setPrice(299.9);
					comm.setEnjoinPlate(p);
					int r =(int) (Math.random() * 3) + 1;
					comm.setImage("public/img/" + images[r]);
					session.save(comm);
				}
			}
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
						.list().get(0);
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
