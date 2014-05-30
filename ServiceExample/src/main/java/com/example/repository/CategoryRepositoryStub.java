package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.example.databaseutilities.HibernateUtilities;
import com.example.model.Category;

public class CategoryRepositoryStub implements CategoryRepository
{

	@Override
	public List<Category> findAllCategories()
	{
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		session.beginTransaction();
		Category category = new Category("kategoria");
		session.save(category);
		session.getTransaction().commit();
	
		session.beginTransaction();		
		Category loadedCategory = (Category) session.get(Category.class, 1);
		session.getTransaction().commit();	
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
		
		List<Category> categories = new ArrayList<Category>();
		categories.add(loadedCategory);
		
		return categories;
	}

}
