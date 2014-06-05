package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PRICES")
@XmlRootElement
public class Price
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "PRICE")
	private double price;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "UNIT_ID")
	private Unit unit;
	
	@Column(name = "QUANTITY")
	private double quantity;
	
	@Column(name = "DATE")
	private Date date;

	public Price()
	{		
	}
	
	public Price(double price, Unit unit, double quantity)
	{
		this.price=price;
		this.unit=unit;
		this.quantity=quantity;
		this.date = new Date();
	}
	public int getId()
	{
		return id;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public Unit getUnit()
	{
		return unit;
	}
	
	public Date getDate()
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

	public void setUnit(Unit unit)
	{
		this.unit = unit;
	}

	public void setDate(Date date)
	{
		this.date = date;
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
		builder.append(unit.getName());
		return builder.toString();
	}

	public String unitPriceToString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(getUnitPrice() + "zl/");
		builder.append(unit.getName());
		return builder.toString();
	}

}
