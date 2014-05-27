package com.example.model;

import java.util.List;

public class Product implements Comparable<Product>
{
	private int id;

	private String name;
	private Category category;
	private List<Price> priceHistory;
	private List<Barcode> barcodesList;
	

	public long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public Category getCategory()
	{
		return category;
	}
	
	public List<Price> getPriceHistory()
	{
		return priceHistory;
	}

	public void setPriceHistory(List<Price> priceHistory)
	{
		this.priceHistory = priceHistory;
	}

	public List<Barcode> getBarcodesList()
	{
		return barcodesList;
	}

	public void setBarcodesList(List<Barcode> barcodesList)
	{
		this.barcodesList = barcodesList;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	public void addPrice(Price price)
	{
		price.setProduct(this);
		priceHistory.add(price);
	}

	public void addBarcode(Barcode barcode)
	{
		barcode.setProduct(this);
		barcodesList.add(barcode);
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		return builder.toString();
	}

	@Override
	public int compareTo(Product arg)
	{
		return getName().compareTo(arg.getName());
	}
}
