package com.java.Client;

import java.util.Scanner;
import com.java.Service.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Service ser = new Service();
		while(true)
		{
		System.out.println("1...Add new item");
		System.out.println("2...RemoveItem");
		System.out.println("3...Update Price");
		System.out.println("4...Calculate Bill");
		System.out.println("5...Exiting");
		System.out.println("Enter your Choice");
		int ch=sc.nextInt();
		if(ch==1)
		{
			ser.AddProduct();
			
		}
		else if(ch==2) {
			ser.DeleteProduct();
		}
		else if(ch==3) {
			ser.UpdatePrice();
		}
		else if(ch==4) {
		    ser.CalculateTotalBill();
		}
		else {
			break;
		}
			
		}
		
		}
	}
