package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.example.databaseutilities.HibernateUtilities;
import com.example.model.Price;
import com.example.model.Product;

public class ProductRepositoryStub implements ProductRepository
{

	@Override
	public List<Product> findAllProducts()
	{
		List<Product> products = new ArrayList<Product>();
				
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Unit unit = new Unit("kg");
		
		Product prod = new Product("Produkt");
		
		prod.addPrice(new Price(prod,10,10));
		prod.addPrice(new Price(prod,15,10));
		
		session.save(prod);
		session.getTransaction().commit();
		
		products.add(prod);
		return products;
	}

}
