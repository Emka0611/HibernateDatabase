package com.example.repository;

import java.util.List;

import org.hibernate.Session;

import com.example.databaseutilities.HibernateUtilities;
import com.example.model.Price;
import com.example.model.Product;

public class ProductRepositoryStub implements ProductRepository
{

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProducts()
	{
		List<Product> products = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		products = session.createQuery(
				"from Product p left join fetch p.priceHistory").list();
		session.getTransaction().commit();

		session.close();
		return products;
	}

	@Override
	public Product saveProduct(Product product)
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
	@Override
	public List<Price> findAllPrices()
	{
		List<Price> prices = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		prices = session.createQuery("from Price").list();

/*		for (Iterator<Price> iter = prices.iterator(); iter.hasNext();)
		{
			Price element = (Price) iter.next();
			Hibernate.initialize(element.getUnit());
		}*/

		session.getTransaction().commit();

		session.close();
		return prices;
	}

	@Override
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

}
