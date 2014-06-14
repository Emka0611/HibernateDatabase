package com.example.repository;

import java.util.List;

import org.hibernate.Session;

import com.example.databaseutilities.HibernateUtilities;

public class Repository<T> implements IRepository<T>
{
	private Class<T> persistentClass;

	public Repository(Class<T> type)
	{
		this.persistentClass = type;
	}
	
    public Class<T> getPersistentClass() {  
        return persistentClass;  
    }  

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll()
	{
		List<T> list = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		list = session
				.createQuery("from " + getPersistentClass().getSimpleName() + " p")
				.list();
		session.getTransaction().commit();

		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(int id)
	{
		T element = null;
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		session.beginTransaction();
		element = (T) session.createQuery("from " + getPersistentClass().getSimpleName() + " p where p.id = :ID").setParameter("ID", id).uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return element;
	}

	@Override
	public T create(T element)
	{
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		session.saveOrUpdate(element);
		session.getTransaction().commit();

		session.close();
		return element;
	}

	@Override
	public T update(T element)
	{
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		session.update(element);
		session.getTransaction().commit();

		session.close();
		return element;
	}

	@Override
	public void delete(int id)
	{
		Session session = HibernateUtilities.getSessionFactory().openSession();

		session.beginTransaction();
		session.createQuery("delete from "+ getPersistentClass().getSimpleName() + " p where p.id = :ID").setParameter("ID", id).executeUpdate();
		session.getTransaction().commit();

		session.close();
	}
}
