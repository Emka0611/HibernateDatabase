package com.example.model;

public class Price
{
	private int id;
	
	private Product product;
	private double price;
	//private Unit unit;
	private double quantity;
	
	private String date;

	public Price()
	{
		
	}
	
	public Price(Product product, double price, /*Unit unit,*/ double quantity)
	{
		this.product=product;
		this.price=price;
		//this.unit=unit;
		this.quantity=quantity;
	}
	public long getId()
	{
		return id;
	}
	
	public Product getProduct()
	{
		return product;
	}
	
	public double getPrice()
	{
		return price;
	}
	
/*	public Unit getUnit()
	{
		return unit;
	}*/
	
	public String getDate()
	{
		return date;
	}
	
	public double getQuantity()
	{
		return quantity;
	}

	public void setQuantity(double quantity)
	{
		this.quantity = quantity;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

/*	public void setUnit(Unit unit)
	{
		this.unit = unit;
	}*/

	public void setDate(String date)
	{
		this.date = date;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}
	
	public double getUnitPrice()
	{
		double unitPrice = price/quantity;
		unitPrice *= 100;
		unitPrice = Math.round(unitPrice);
	    unitPrice/= 100; 
		
	    return unitPrice;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(price);
		builder.append("zl ");
		builder.append(getUnitPrice() + "zl/");
		//builder.append(unit.getName());
		return builder.toString();
	}

	public String unitPriceToString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(getUnitPrice() + "zl/");
		//builder.append(unit.getName());
		return builder.toString();
	}

}
