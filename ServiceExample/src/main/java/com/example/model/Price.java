package com.example.model;

public class Price
{
	private long m_id;
	private Product m_product;
	private double m_price;
	private Unit m_unit;
	private double m_quantity;
	
	private String m_date;

	public long getId()
	{
		return m_id;
	}
	
	public Product getProduct()
	{
		return m_product;
	}
	
	public double getPrice()
	{
		return m_price;
	}
	
	public Unit getUnit()
	{
		return m_unit;
	}
	
	public String getDate()
	{
		return m_date;
	}
	
	public void setProduct(Product product)
	{
		m_product = product;
	}
	
	public double getUnitPrice()
	{
		double unitPrice = m_price/m_quantity;
		unitPrice *= 100;
		unitPrice = Math.round(unitPrice);
	    unitPrice/= 100; 
		
	    return unitPrice;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(m_price);
		builder.append("zl ");
		builder.append(getUnitPrice() + "zl/");
		builder.append(m_unit.getName());
		return builder.toString();
	}

	public String unitPriceToString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(getUnitPrice() + "zl/");
		builder.append(m_unit.getName());
		return builder.toString();
	}

}
