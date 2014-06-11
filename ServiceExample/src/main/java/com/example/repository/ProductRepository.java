package com.example.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.example.databaseutilities.HibernateUtilities;
import com.example.model.Barcode;
import com.example.model.Price;
import com.example.model.Product;

public class ProductRepository implements IRepository<Product>
{
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll()
	{
		List<Product> products = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		products = session.createQuery("from Product").list();
		
		for (Iterator<Product> iter = products.iterator(); iter.hasNext();)
		{
			Product element = (Product) iter.next();
			Hibernate.initialize(element.getBarcodesList());
			Hibernate.initialize(element.getPriceHistory());
		}
		session.getTransaction().commit();

		session.close();
		return products;
	}

	@Override
	public Product create(Product product)
	{
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();

		session.close();
		return product;
	}

	@Override
	public Product findById(int id)
	{
		Product element = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		element = (Product) session
				.createQuery("from Product p where p.id = :ID")
				.setParameter("ID", id).uniqueResult();

		return element;
	}

	@SuppressWarnings("unchecked")
	public List<Price> findAllPrices()
	{
		List<Price> prices = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		prices = session.createQuery("from Price").list();

		session.getTransaction().commit();

		session.close();
		return prices;
	}

	public Product addPrice(int productID, Price price)
	{
		Product element = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		element = (Product) session.load(Product.class, productID);

		element.addPrice(price);

		session.saveOrUpdate(element);
		session.getTransaction().commit();

		session.close();
		return element;
	}

	public Product addBarcode(int productID, Barcode barcode)
	{
		Product element = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		element = (Product) session.load(Product.class, productID);

		element.addBarcode(barcode);

		session.saveOrUpdate(element);
		session.getTransaction().commit();

		session.close();
		return element;
	}

	@Override
	public Product update(Product element)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id)
	{
		// TODO Auto-generated method stub

	}

}
