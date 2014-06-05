package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PRODUCTS")
@XmlRootElement
public class Product implements Comparable<Product>
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Price> priceHistory = new ArrayList<Price>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Barcode> barcodesList = new ArrayList<Barcode>();
	
	public Product()
	{
		
	}
	
	public Product(String name, Category category)
	{
		this.name = name;
		this.category = category;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Category getCategory()
	{
		return category;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
	}

	public List<Price> getPriceHistory()
	{
		return priceHistory;
	}

	public void setPriceHistory(List<Price> priceHistory)
	{
		this.priceHistory = priceHistory;
	}
	
	public void addPrice(Price price)
	{
		priceHistory.add(price);
	}

	public List<Barcode> getBarcodesList()
	{
		return barcodesList;
	}

	public void setBarcodesList(List<Barcode> barcodesList)
	{
		this.barcodesList = barcodesList;
	}

	public void addBarcode(Barcode barcode)
	{
		barcodesList.add(barcode);		
	}

	@Override
	public int compareTo(Product arg)
	{
		return getName().compareTo(arg.getName());
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		return builder.toString();
	}
}
