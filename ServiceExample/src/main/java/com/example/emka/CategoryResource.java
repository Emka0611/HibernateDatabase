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

import com.example.model.Category;
import com.example.repository.IRepository;
import com.example.repository.Repository;

@Path("categories") // http://localhost:8080/ServiceExample/webapi/categories
public class CategoryResource
{
	private IRepository<Category> categoryRepository = new Repository<Category>(Category.class);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Category> getAllCategories()
	{
		return categoryRepository.findAll();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Category addCategory(Category category)
	{
		return categoryRepository.create(category);
	}	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{categoryId}") // http://localhost:8080/ServiceExample/webapi/units/1234
	public Response getUnit(@PathParam("categoryId") int categoryId)
	{
		if(categoryId <0)
		{
			return Response.status(Status.BAD_REQUEST).build();
		}
		Category category = categoryRepository.findById(categoryId);
		
		if(category == null)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(category).build();
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(Category category)
	{
		categoryRepository.update(category);		
		return Response.ok().entity(category).build();
	}
	
	@DELETE
	@Path("/delete/{categoryId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete(@PathParam("categoryId") int categoryId)
	{
		categoryRepository.delete(categoryId);
		return Response.ok().build();
	}

}

