package com.example.emka.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.model.Unit;

public class UnitClient
{

	private Client client;
	
	public UnitClient()
	{
		client = ClientBuilder.newClient();
	}
	
	public Unit get(String id)
	{
		//http://localhost:8080/ServiceExample/webapi/activities/1234
		WebTarget target = client.target("http://localhost:8080/ServiceExample/webapi");
		Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
		
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus() + "there was an error on the server.");
		}	
		else
		{
			return response.readEntity(Unit.class);
		}		
	}
	
	public List<Unit> get()
	{
		//http://localhost:8080/ServiceExample/webapi/activities/1234
		WebTarget target = client.target("http://localhost:8080/ServiceExample/webapi");
		List<Unit> response = target.path("activities/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Unit>>() {});
		
		return response;
	}

	public Unit create(Unit activity)
	{
		WebTarget target = client.target("http://localhost:8080/ServiceExample/webapi");
		Response response = target.path("activities/activity")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus() + "there was an error on the server.");
		}	
		else
		{
			return response.readEntity(Unit.class);
		}		

	}

	public Unit update(Unit activity)
	{
		WebTarget target = client.target("http://localhost:8080/ServiceExample/webapi");
		
		Response response = target.path("activities/activity" + activity.getId())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus() + "there was an error on the server.");
		}	
		else
		{
			return response.readEntity(Unit.class);
		}		
	}

	public void delete(String activityId)
	{
		WebTarget target = client.target("http://localhost:8080/ServiceExample/webapi");
		Response response = target.path("activities/" + activityId).request(MediaType.APPLICATION_JSON).delete();
		
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus() + "there was an error on the server.");
		}	
	}
	
}
