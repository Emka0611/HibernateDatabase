package com.example.emka;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.model.Category;
import com.example.model.Price;
import com.example.model.Product;
import com.example.model.Unit;
import com.example.repository.HibernateRepository;
import com.example.repository.ProductRepository;
import com.example.repository.Repository;

@Path("products") // http://localhost:8080/ServiceExample/webapi/products
public class ProductResource
{
	private ProductRepository productRepository = new ProductRepository();
	private Repository<Category> categoryRepository = new HibernateRepository<Category>(Category.class);
	private Repository<Unit> unitRepository = new HibernateRepository<Unit>(Unit.class);
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	@GET
	@Path("/add/{name}/{categoryID}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Product addNewProduct(@PathParam("name") String name, @PathParam("categoryID") int categoryID)
	{
		Category category = categoryRepository.findById(categoryID);
		Product product = new Product(name, category);
		return productRepository.create(product);
	}

	@GET
	@Path("/{productID}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Product getProduct(@PathParam("productID") int productID)
	{
		return productRepository.findById(productID);
	}
	
	@GET
	@Path("/{productID}/addPrice/{unitID}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Product addPrice(@PathParam("productID") int productID, @PathParam("unitID") int unitID)
	{
		Unit unit = unitRepository.findById(unitID);
		productRepository.addPrice(productID, new Price(10, unit, 10));
		return productRepository.findById(productID);
	}
}
