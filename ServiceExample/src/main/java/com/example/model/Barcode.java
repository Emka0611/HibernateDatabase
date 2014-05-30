package com.example.model;

public class Barcode
{
	private long id;
	
	private String barcode;
	private Product product;

	public long getId()
	{
		return id;
	}
	
	public String getBarcode()
	{
		return barcode;
	}

	public Product getProduct()
	{
		return product;
	}
	
	public void setProduct(Product product)
	{
		this.product = product;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}

	public void setBarcode(String barcode)
	{
		this.barcode = barcode;
	}

	@Override
	public String toString()
	{
		return barcode;
	}
}