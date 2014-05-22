package com.example.model;

import java.util.List;

public class Product implements Comparable<Product>
{
	private long m_id;

	private String m_name;
	private Category m_category;
	private List<Price> m_priceHistory;
	private List<Barcode> m_barcodesList;
	

	public long getId()
	{
		return m_id;
	}

	public String getName()
	{
		return m_name;
	}

	public Category getCategory()
	{
		return m_category;
	}
	
	public void addPrice(Price price)
	{
		price.setProduct(this);
		m_priceHistory.add(price);
	}

	public void addBarcode(Barcode barcode)
	{
		barcode.setProduct(this);
		m_barcodesList.add(barcode);
	}

	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(m_name);
		return builder.toString();
	}

	@Override
	public int compareTo(Product arg)
	{
		return getName().compareTo(arg.getName());
	}
}
