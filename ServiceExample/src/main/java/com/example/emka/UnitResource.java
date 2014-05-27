package com.example.emka;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.model.Unit;
import com.example.repository.UnitRepository;
import com.example.repository.UnitRepositoryStub;

@Path("units") // http://localhost:8080/ServiceExample/webapi/units
public class UnitResource
{
	private UnitRepository unitRepository = new UnitRepositoryStub();

	@DELETE
	@Path("{unitId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete(@PathParam("unitId") String unitId)
	{
		System.out.println(unitId);

		unitRepository.delete(unitId);
		
		return Response.ok().build();
	}
	
	@PUT
	@Path("activity/{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(Unit unit)
	{
		System.out.println(unit.getId());

		unitRepository.update(unit);
		
		return Response.ok().entity(unit).build();
	}
	
	@POST
	@Path("unit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Unit createUnit(Unit unit)
	{
		System.out.println(unit.getName());
		
		unitRepository.create(unit);
		return unit;
	}
	
	@POST
	@Path("unit") // http://localhost:8080/ServiceExample/webapi/units/unit // params -> MultivaluedMap<String, String>
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Unit createUnitParams(String param)
	{
		System.out.println(param);

		Unit u = new Unit(param);
		unitRepository.create(u);
		
		return u;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Unit> getAllUnits()
	{
		return unitRepository.findAllUnits();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{unitId}") // http://localhost:8080/ServiceExample/webapi/units/1234
	public Response getUnit(@PathParam("unitId") String unitId)
	{
		if(unitId == null || unitId.length() < 4)
		{
			return Response.status(Status.BAD_REQUEST).build();
		}
		Unit unit = unitRepository.findUnit(unitId);
		
		if(unit == null)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
		
		System.out.println("Getting unit ID: " + unitId);
		
		return Response.ok().entity(unit).build();
	}
	
/*	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}/user") // http://localhost:8080/ServiceExample/webapi/units/1234/user
	public User getunitUser(@PathParam("unitId") String unitId)
	{
		return unitRepository.findUnit(unitId).getUser();
	}*/

}
