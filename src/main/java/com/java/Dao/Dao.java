package com.java.Dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.java.Connect.Connect;
import com.java.Model.Product;




public class Dao implements DaoInterface{
	Scanner sc;
	SessionFactory f;
	public Dao()
	{
		f=Connect.getSessionFactory();
		
		sc= new Scanner (System.in);
			
	}

	@Override
	public boolean addItem(int itemCode, String name, double price, int quantity) {
		
		try{Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
		String hql="from Product p where p.Pid=:p";
		Query q=ses.createQuery(hql, Product.class);
		q.setParameter("p", itemCode);
		List<Product> l=q.getResultList();
		
		if(l!=null &&!l.isEmpty() )
		{
			System.out.println("Product already exists");
			return false;
		}
		else
		{
		Product p = new Product();
		p.setPid(itemCode);
		p.setName(name);
		p.setPrice(price);
		p.setQty(quantity);
		ses.save(p);
		tx.commit();
		ses.close();
		System.out.println("added suucessfully");
		return true;
		}
		}
		catch(Exception e) {
			System.out.println("product addition failed");
			return false;
		}
	}

	@Override
	public boolean removeItem(int itemCode) {
		
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
    	
   	 	String hql="delete from Product p where p.Pid=:id ";
   	 	Query q =ses.createQuery(hql);
   	 	q.setParameter("id", itemCode);

   	 	int a;
   	 	a=q.executeUpdate();
   	 	tx.commit();
   	 	if(a>0)
   	 	{
   	 		System.out.println("Item Removed");
   	 	}
   	 	else
   	 	{
   	 		System.out.println("Failed to remove , try again");
   	 	}	

		return false;
		
		
	}

	@Override
	public boolean updatePrice(int itemCode, double newPrice) {
		
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
		
		String hql="UPDATE Product p set p.Price=:price where p.Pid=:id ";
    	
   	 	Query q =ses.createQuery(hql);
   	
   	 	q.setParameter("id", itemCode);
   	 	q.setParameter("price", newPrice);

		int a;
		a=q.executeUpdate();
		tx.commit();
		if(a>0)
		{
  	     System.out.println("price updated");
  	     return true;
		}
		else
		{
  	     System.out.println("failed to updated");
  	     return false;
		}

	}

	@Override
	public double calculateTotalBill(int itemCode, int quantity) {
		
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
		double totalBill=0;
		
		String hql = "FROM Product p WHERE p.Pid = :itemCode AND Qty >= :quantity";
        
        Query q = ses.createQuery(hql, Product.class);
        q.setParameter("itemCode", itemCode);
        q.setParameter("quantity", quantity);
        
        Product item = (Product) q.uniqueResult();
        
        if (item != null) {
           
            totalBill = item.getPrice() * quantity;
            System.out.println("your total bill :"+ totalBill);
        } else {
            System.out.println("Item not found or insufficient quantity.");
            totalBill = -1;  
        }
        
      
        tx.commit();
		ses.close();
		return 0;
	}

}
