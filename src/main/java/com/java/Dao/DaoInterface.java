package com.java.Dao;

public interface DaoInterface {
	boolean addItem(int itemCode, String name, double price, int quantity);

    boolean removeItem(int itemCode);

    boolean updatePrice(int itemCode, double newPrice);

    double calculateTotalBill(int itemCode, int quantity);
}
