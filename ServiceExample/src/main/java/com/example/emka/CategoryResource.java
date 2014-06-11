package com.example.emka;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.model.Category;
import com.example.repository.Repository;
import com.example.repository.IRepository;

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
	
	@GET
	@Path("/add/{name}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Category addCategory(@PathParam("name") String name)
	{
		Category category = new Category(name);
		return categoryRepository.create(category);
	}

}

