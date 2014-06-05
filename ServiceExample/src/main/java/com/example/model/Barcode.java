package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "BARCODES")
@XmlRootElement
public class Barcode
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "BARCODE")
	private String barcode;
	
	
	private Product product;

	public int getId()
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
	
	public void setId(int id)
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