package com.line.web.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {
	
	private static SessionFactory sf;
	
	private static Configuration cfg;
	
	
	static{
		try{
			cfg = new AnnotationConfiguration().configure();
			sf = cfg.buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private HibernateUtil(){
	}
	
	public static SessionFactory getSessionFactory(){
		return sf;
	}
	
	public static Session getSession(){
		return sf.openSession();
	}
	
	public static void close(Session session){
		if(session != null){
			session.close();
		}
	}
	
	public static void main(String arg[]){
		
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
		System.out.println("yes");
	}
}
