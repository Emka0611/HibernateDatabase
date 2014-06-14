package com.example.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.example.databaseutilities.HibernateUtilities;
import com.example.model.Product;

public class ProductRepository extends Repository<Product>
{
	public ProductRepository(Class<Product> type)
	{
		super(type);
	}

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
			Product element = iter.next();
			Hibernate.initialize(element.getBarcodesList());
			Hibernate.initialize(element.getPriceHistory());
		}
		session.getTransaction().commit();

		session.close();
		return products;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product>  findProductsByCategory(int categoryId)
	{
		List<Product> products = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		products = session.createQuery("from Product p where p.category.id = :ID")
				.setParameter("ID", categoryId).list();
		
		for (Iterator<Product> iter = products.iterator(); iter.hasNext();)
		{
			Product element = iter.next();
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
		
		Hibernate.initialize(element.getBarcodesList());
		Hibernate.initialize(element.getPriceHistory());
		
		session.getTransaction().commit();
		session.close();

		return element;
	}
	
	public Product findByName(String name)
	{
		Product element = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		element = (Product) session
				.createQuery("from Product p where p.name = :NAME")
				.setParameter("NAME", name).uniqueResult();
		
		Hibernate.initialize(element.getBarcodesList());
		Hibernate.initialize(element.getPriceHistory());
		
		session.getTransaction().commit();
		session.close();

		return element;
	}
}
