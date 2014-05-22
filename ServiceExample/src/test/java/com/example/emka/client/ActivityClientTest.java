package com.example.emka.client;

import java.util.List;

import junit.framework.TestCase;

import com.example.model.Activity;

public class ActivityClientTest extends TestCase
{

	public void testDelete()
	{
		ActivityClient client = new ActivityClient();
		client.delete("1234");
	}
	public void testPut()
	{
		Activity activity = new Activity();
		
		activity.setId("3456");
		activity.setDescription("Put example");
		activity.setDuration(80);
		
		ActivityClient client = new ActivityClient();
		client.update(activity);
		
	}
	public void testCreate()
	{
		ActivityClient client = new ActivityClient();
		Activity activity = new Activity();
		activity.setDescription("Hejka siemka nowy obiekt");
		activity.setDuration(15);
		
		activity = client.create(activity);
		
		assertNotNull(activity);
	}
	
	public void testGet()
	{
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("1234");
		
		System.out.println(activity);
		
		assertNotNull(activity);
	}
	
	public void testGetList()
	{
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.get();
		
		System.out.println(activities);
		
		assertNotNull(activities);
	}
}
