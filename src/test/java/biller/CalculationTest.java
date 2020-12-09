package biller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.cafex.biller.menu.DrinkMenuItem;
import com.cafex.biller.menu.FoodMenuItem;
import com.cafex.biller.menu.MenuItem;
import com.cafex.biller.service.BillingCalculatorServiceImpl;

public class CalculationTest {

	@Test
	public void testTotalMix() {
		BillingCalculatorServiceImpl billingService = new BillingCalculatorServiceImpl();
		ArrayList<MenuItem>items = new ArrayList<MenuItem>();
		items.add(new DrinkMenuItem("Cola", true, 0.50f, 1));
		items.add(new FoodMenuItem("Cheese Sandwich", false, 2.00f, 1));
		items.add(new FoodMenuItem("Steak Sandwich", false, 4.50f, 1));
		assertEquals(7.65d, billingService.calculateTotalBill(items), 0);
	}
	
	@Test
	public void testTotalOnlyDrinks() {
		BillingCalculatorServiceImpl billingService = new BillingCalculatorServiceImpl();
		ArrayList<MenuItem>items = new ArrayList<MenuItem>();
		items.add(new DrinkMenuItem("Cola", true, 0.50f, 1));
		assertEquals(0.50d, billingService.calculateTotalBill(items), 0);
	}
	@Test
	public void testTotalMultipleQtyMix() {
		BillingCalculatorServiceImpl billingService = new BillingCalculatorServiceImpl();
		ArrayList<MenuItem>items = new ArrayList<MenuItem>();
		items.add(new DrinkMenuItem("Cola", true, 0.50f, 2));
		items.add(new FoodMenuItem("Cheese Sandwich", false, 2.00f, 3));
		items.add(new FoodMenuItem("Steak Sandwich", false, 4.50f, 2));
		assertEquals(17.50d, billingService.calculateTotalBill(items), 0);
	}
}
