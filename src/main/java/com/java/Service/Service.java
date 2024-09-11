package com.java.Service;

import java.util.Scanner;

import com.java.Dao.Dao;
import com.java.Dao.DaoInterface;



public class Service {
	DaoInterface di;
	Scanner sc;
	
	public Service(){
		di = new Dao();
		sc=new Scanner(System.in);
	}
	
	public boolean AddProduct() {
		
		System.out.println("enter product id :");
		int id=sc.nextInt();
		System.out.println("enter product name:");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("enter product price:");
		double price = sc.nextDouble();
		System.out.println("enter product quantity:");
		int qty=sc.nextInt();
		if(di.addItem(id, name, price, qty)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean DeleteProduct() {
		
		System.out.println("enter product id:");
		int id=sc.nextInt();
		if(di.removeItem(id)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
public boolean UpdatePrice() {
		
		System.out.println("enter user Id");
		int id=sc.nextInt();
		System.out.println("enter new product price");
		double price = sc.nextDouble();
		if(di.updatePrice(id, price)) {
			return true;
		}
		else {
			return false;
		}
	}

public void CalculateTotalBill() {
	
		System.out.println("Enter the Product code");
		int id=sc.nextInt();
		System.out.println("Enter the Product quantity");
		int quantity=sc.nextInt();
		di.calculateTotalBill(id, quantity);
}
}
