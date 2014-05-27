package com.example.emka.client;

import java.util.List;

import junit.framework.TestCase;

import com.example.model.Unit;

public class UnitClientTest extends TestCase
{

	public void testDelete()
	{
		UnitClient client = new UnitClient();
		client.delete("1234");
	}
	public void testPut()
	{
		Unit activity = new Unit();
		
		activity.setId(3456);
		activity.setName("Put example");
		
		UnitClient client = new UnitClient();
		client.update(activity);
		
	}
	public void testCreate()
	{
		UnitClient client = new UnitClient();
		Unit activity = new Unit();
		activity.setName("Hejka siemka nowy obiekt");

		activity = client.create(activity);
		
		assertNotNull(activity);
	}
	
	public void testGet()
	{
		UnitClient client = new UnitClient();
		Unit activity = client.get("1234");
		
		System.out.println(activity);
		
		assertNotNull(activity);
	}
	
	public void testGetList()
	{
		UnitClient client = new UnitClient();
		List<Unit> activities = client.get();
		
		System.out.println(activities);
		
		assertNotNull(activities);
	}
}
