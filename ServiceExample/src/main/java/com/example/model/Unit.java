package com.example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Unit
{
	private int id;
	private String name;

	public Unit()
	{
		
	}
	public Unit(String name)
	{
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
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}

}
