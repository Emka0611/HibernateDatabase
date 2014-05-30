package com.example.emka;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.repository.ProductRepositoryStub;

@Path("products") // http://localhost:8080/ServiceExample/webapi/products
public class ProductResource
{
	private ProductRepository productRepository = new ProductRepositoryStub();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Product> getAllProducts()
	{
		return productRepository.findAllProducts();
	}

}
