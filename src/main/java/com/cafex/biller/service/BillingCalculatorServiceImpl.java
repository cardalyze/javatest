package com.cafex.biller.service;

import java.util.ArrayList;
import java.util.List;

import com.cafex.biller.menu.DrinkMenuItem;
import com.cafex.biller.menu.FoodMenuItem;
import com.cafex.biller.menu.MenuItem;

public class BillingCalculatorServiceImpl implements BillingCalculatorService {

	public double calculateTotalBill(List<MenuItem> items) 
	{
		double totalBill = 0;
		for(MenuItem menuItem:items)
		{
			totalBill += menuItem.getTotalWithService();
		}
		return totalBill;
	}

	public void printBill(List<MenuItem> items) {
		double totalBill = 0;
		System.out.println("======================================================================================================");
		System.out.println("   Name \t\t      Qty \tUnit Price \t Item Total \t Service Charge \t Total   ");
		System.out.println("  ------\t\t      --- \t---------- \t ---------- \t -------------- \t -----   ");
		for(MenuItem menuItem: items)
		{
			totalBill += menuItem.getTotalWithService();
			System.out.println("   "+ String.format("%-15s",menuItem.getName()) + "\t\t" + menuItem.getQty() + "\t"+ String.format("%.2f", menuItem.getPrice()) + "   \t\t  "+ String.format("%.2f",menuItem.getItemTotal()) + "\t\t  " + String.format("%.2f",menuItem.getServiceCharge())  + "   \t\t " + String.format("%.2f",menuItem.getTotalWithService()));
		}
		System.out.println("======================================================================================================");
		System.out.println("                                                                                    Grand Total: "+ String.format("%.2f", totalBill));
	}
	public static void main(String[] args)
	{
		BillingCalculatorServiceImpl billingService = new BillingCalculatorServiceImpl();
		
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		items.add(new DrinkMenuItem("Cola", true, 0.50f, 1));
		items.add(new FoodMenuItem("Cheese Sandwich", false, 2.00f, 1));
		items.add(new FoodMenuItem("Steak Sandwich", false, 4.50f, 1));
		billingService.printBill(items);

	}
}
