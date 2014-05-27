package com.example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Category
{
	private int id;
	private String name;
	
	public Category(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public long getId()
	{
		return id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return name;
	}
	
}
