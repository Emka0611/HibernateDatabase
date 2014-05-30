package com.example.emka;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.model.Category;
import com.example.repository.CategoryRepository;
import com.example.repository.CategoryRepositoryStub;

@Path("categories") // http://localhost:8080/ServiceExample/webapi/categories
public class CategoryResource
{
	private CategoryRepository categoryRepository = new CategoryRepositoryStub();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Category> getAllCategories()
	{
		return categoryRepository.findAllCategories();
	}

}

