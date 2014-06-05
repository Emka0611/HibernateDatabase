package com.example.repository;

import java.util.List;

import com.example.model.Price;
import com.example.model.Product;

public interface ProductRepository
{

	List<Product> findAllProducts();

	Product saveProduct(Product product);
	
	Product findById(int id);
	
	List<Price> findAllPrices();

	Product addPrice(int productID, Price price);

}
