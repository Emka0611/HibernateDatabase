package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.example.databaseutilities.HibernateUtilities;
import com.example.model.Unit;

public class UnitRepositoryStub implements UnitRepository
{
	public UnitRepositoryStub()
	{

	}
	
	public List<Unit> findAllUnits()
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
		
		List<Unit> units = new ArrayList<Unit>();
		units.add(loadedUnit);
		
		return units;
	}

	@Override
	public Unit findUnit(String unitId)
	{
		if(unitId.equals("7777"))
		{
			return null;
		}
		
		Unit unit1 =  new Unit("Znaleziona jednostka");
		unit1.setId(1234);
		
		return unit1;
	}

	@Override
	public void create(Unit unit)
	{
		// TODO Auto-generated method stub INSERT statement		
	}

	@Override
	public Unit update(Unit unit)
	{
		// TODO Auto-generated method stub
		// jezeli nie istenieje stworz, jezeli istaniej update istniejacy

		return unit;	
	}

	@Override
	public void delete(String unitId)
	{
		// TODO Auto-generated method stub
		// delete from activity where id == activity id
	}
}
