package com.java.Connect;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.Model.Product;

public class Connect {
	public static SessionFactory fac;
	
	public Connect(){
		fac = new Configuration().configure("hiber_con.xml").addAnnotatedClass(Product.class).buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		
		Connect c = new Connect();
		return fac;
	}
}
