package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.example.databaseutilities.HibernateUtilities;
import com.example.model.Activity;
import com.example.model.Unit;
import com.example.model.User;

public class ActivityRepositoryStub implements ActivityRepository
{
	public ActivityRepositoryStub()
	{

	}
	
	public List<Activity> findAllActivities()
	{
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		Unit unit = new Unit("kg");
		session.save(unit);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtilities.getSessionFactory().close();
		
		List<Activity> activites = new ArrayList<Activity>();
		
		Activity activity1 =  new Activity();
		Activity activity2 = new Activity();
		
		activity1.setDescription("Siemka 1");
		activity1.setDuration(10);

		activity2.setDescription("Siemka 2");
		activity2.setDuration(10);

		activites.add(activity1);
		activites.add(activity2);
		
		return activites;
	}

	@Override
	public Activity findActivity(String activityId)
	{
		if(activityId.equals("7777"))
		{
			return null;
		}
		
		Activity activity1 =  new Activity();
		
		activity1.setId("1234");
		activity1.setDescription("Siemka " + activityId);
		activity1.setDuration(10);
		
		User user = new User();
		user.setId("5678");
		user.setName("Emka");
		
		activity1.setUser(user);
		
		return activity1;
	}

	@Override
	public void create(Activity activity)
	{
		// TODO Auto-generated method stub INSERT statement		
	}

	@Override
	public Activity update(Activity activity)
	{
		// TODO Auto-generated method stub
		// jezeli nie istenieje stworz, jezeli istaniej update istniejacy

		return activity;	
	}

	@Override
	public void delete(String activityId)
	{
		// TODO Auto-generated method stub
		// delete from activity where id == activity id
	}
}
