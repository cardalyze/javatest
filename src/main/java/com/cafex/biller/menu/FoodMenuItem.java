package com.cafex.biller.menu;

public class FoodMenuItem extends MenuItem {

	public FoodMenuItem(String name, boolean cold, float price, int qty) {
		super(name, cold, price, qty);
	}

	public boolean isServiceChargeable() {
		return true;
	}

}
