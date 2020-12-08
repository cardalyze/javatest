package com.cafex.biller.menu;

public class DrinkMenuItem extends MenuItem {

	public DrinkMenuItem(String name, boolean cold, float price, int qty) {
		super(name, cold, price, qty);
	}

	public boolean isServiceChargeable()
	{
		return false;
	}
	
}
