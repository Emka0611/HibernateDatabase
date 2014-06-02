package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product implements Comparable<Product>
{
	private int id;

	private String name;
	//private Category category;
	private List<Price> priceHistory = new ArrayList<Price>();
	//private List<Barcode> barcodesList;
	
	public Product()
	{
		
	}
	
	public Product(String name)
	{
		this.name = name;;
	}
	
/*	public Product(String name, Category category)
	{
		this.name = name;
		this.category = category;
	}*/

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

/*	public Category getCategory()
	{
		return category;
	}*/
	
	public List<Price> getPriceHistory()
	{
		return priceHistory;
	}

	public void setPriceHistory(List<Price> priceHistory)
	{
		this.priceHistory = priceHistory;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

/*	public void setCategory(Category category)
	{
		this.category = category;
	}*/

	public void addPrice(Price price)
	{
		price.setProduct(this);
		priceHistory.add(price);
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
