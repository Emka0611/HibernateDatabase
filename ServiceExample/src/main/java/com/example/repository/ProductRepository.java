package com.example.repository;

import java.util.List;

import com.example.model.Product;

public interface ProductRepository
{

	List<Product> findAllProducts();

}
