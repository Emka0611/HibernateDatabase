package com.example.model;

public class Price
{
	private int id;
	private Product product;

	public Price()
	{
		
	}

	public int getId()
	{
		return id;
	}
	
	public Product getProduct()
	{
		return product;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append("CENA zl ");
		return builder.toString();
	}
}
