package com.cafex.biller.menu;

public abstract class MenuItem 
{
	private static final double TAX_RATE = 0.10;
	private String name;
	private boolean cold;
	private float price;
	private int qty;

	public MenuItem(String name, boolean cold, float price, int qty) {
		super();
		this.name = name;
		this.cold = cold;
		this.price = price;
		this.qty = qty;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCold() {
		return cold;
	}

	public void setCold(boolean cold) {
		this.cold = cold;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	public double getItemTotal()
	{
		float total = 0;
		total = this.getPrice()*this.getQty();
		return total;
	}
	public double getServiceCharge()
	{
		if(isServiceChargeable())
		{
			return getItemTotal()* TAX_RATE;
		}
		else return 0;
	}
	public double getTotalWithService()
	{
		return getItemTotal() + getServiceCharge();
	}
	public abstract boolean isServiceChargeable();
}
