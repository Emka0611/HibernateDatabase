package com.example.model;

public class Unit
{
	private long id;
	private String name;

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

	@Override
	public String toString()
	{
		return name;
	}

}
