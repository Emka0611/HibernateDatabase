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

import com.example.model.Product;
import com.example.repository.ProductRepository;

@Path("products")
public class ProductResource
{
	private ProductRepository productRepository = new ProductRepository(Product.class);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}

	@GET
	@Path("/{productId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Product getProductById(@PathParam("productId") int productID)
	{
		return productRepository.findById(productID);
	}
	
	@GET
	@Path("/product/name/{productName}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Product getProductByName(@PathParam("productName") String productName)
	{
		return productRepository.findByName(productName);
	}
	
	@GET
	@Path("/product/catId/{categoryId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Product> findProductsByCategory(@PathParam("categoryId") int categoryId)
	{
		return productRepository.findProductsByCategory(categoryId);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Product addNewProduct(Product product)
	{
		return productRepository.create(product);
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(Product product)
	{
		productRepository.update(product);		
		return Response.ok().entity(product).build();
	}
	
	@DELETE
	@Path("/delete/{productId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete(@PathParam("productId") int productId)
	{
		productRepository.delete(productId);
		return Response.ok().build();
	}
}
