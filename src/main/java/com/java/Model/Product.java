package com.java.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	
	@Id
	int Pid;
	@Column
	String Name;
	@Column
	double Price;
	@Column
	int Qty;
	
	public Product(){
		
	}
	
	public Product(int pid, String name, double price,int qty) {
		super();
		Pid = pid;
		Name = name;
		Price = price;
		Qty = qty;
	}

	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Product [Pid=" + Pid + ", Name=" + Name + ", Price=" + Price + ", Qty=" + Qty + "]";
	}
	
}
