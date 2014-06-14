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
import com.example.repository.Repository;
import com.example.repository.IRepository;

@Path("units") // http://localhost:8080/ServiceExample/webapi/units
public class UnitResource
{
	private IRepository<Unit> unitRepository = new Repository<Unit>(Unit.class);

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Unit> getAllUnits()
	{
		return unitRepository.findAll();
	}	
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Unit addUnit(Unit unit)
	{
		return unitRepository.create(unit);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{unitId}") // http://localhost:8080/ServiceExample/webapi/units/1234
	public Response getUnit(@PathParam("unitId") int unitId)
	{
		if(unitId <0)
		{
			return Response.status(Status.BAD_REQUEST).build();
		}
		Unit unit = unitRepository.findById(unitId);
		
		if(unit == null)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(unit).build();
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(Unit unit)
	{
		unitRepository.update(unit);		
		return Response.ok().entity(unit).build();
	}
	
	@DELETE
	@Path("/delete/{unitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete(@PathParam("unitId") int unitId)
	{
		unitRepository.delete(unitId);
		return Response.ok().build();
	}
}
