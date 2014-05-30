package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.example.databaseutilities.HibernateUtilities;
import com.example.model.Price;
import com.example.model.Unit;

public class PriceRepositoryStub implements PriceRepository
{

	@Override
	public List<Price> getAllPrices()
	{
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		session.beginTransaction();
		Unit unit = new Unit("jednostka");
		session.save(unit);
		session.getTransaction().commit();
	
		session.beginTransaction();		
		Unit loadedUnit = (Unit) session.get(Unit.class, 1);
		session.getTransaction().commit();	
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
		
		List<Price> prices = new ArrayList<Price>();
		
		return prices;
	}
	
}
