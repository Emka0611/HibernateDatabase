package com.example.model;

public class Barcode
{
	private long m_id;
	private String m_barcode;
	private Product m_product;

	public long getId()
	{
		return m_id;
	}
	
	public String getBarcode()
	{
		return m_barcode;
	}

	public Product getProduct()
	{
		return m_product;
	}
	
	public void setProduct(Product product)
	{
		m_product = product;
	}
	
	@Override
	public String toString()
	{
		return m_barcode;
	}

}