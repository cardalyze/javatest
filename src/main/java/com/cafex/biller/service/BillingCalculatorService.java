package com.cafex.biller.service;

import java.util.List;

import com.cafex.biller.menu.MenuItem;

public interface BillingCalculatorService {
	public double calculateTotalBill(List<MenuItem> items);
	public void printBill(List<MenuItem> items);
}
