package com.idil.peoplesHealth.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idil.peoplesHealth.domain.Activity;
import com.idil.peoplesHealth.domain.FoodItem;
import com.idil.peoplesHealth.domain.User;
import com.idil.peoplesHealth.domain.User_Activity;
import com.idil.peoplesHealth.domain.User_Activity.User_ActivityPK;
import com.idil.peoplesHealth.domain.User_FoodItem;
import com.idil.peoplesHealth.domain.User_FoodItem.User_FoodItemPK;

@Component
public class ActivityDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@SuppressWarnings("unchecked")
	public ArrayList<Activity> getActivitiesWithNameLike(String activityName) {

		Criteria activityCriteria = sessionFactory.getCurrentSession().createCriteria(Activity.class,
				"activity");
		activityCriteria.add(Restrictions.like("activity.activityName", activityName+"%s"));

		List<Activity> activities = activityCriteria.list();
		if (activities == null || activities.size() == 0) {
			return null;
		}
		 ArrayList<Activity> activityList = new  ArrayList<Activity>();
		 activityList.addAll(activities);
	
		return activityList;
	}

	@Transactional
	public void addActivityForUser(String activityId, String email, String date, String hours) {
		
		Activity activity = (Activity) sessionFactory.getCurrentSession().get(Activity.class, Integer.valueOf(activityId));
		
		User user = (User) sessionFactory.getCurrentSession().get(User.class, email);
		
		User_ActivityPK activityKey = new User_ActivityPK();
		
		activityKey.setUser(user);
		
		activityKey.setHours(Double.valueOf(hours.replace(",", ".")));
		
		activityKey.setActivity(activity);
				
		activityKey.setDateTime(date);
		
		User_Activity userActivity = new User_Activity();
		userActivity.setUserActivityKey(activityKey);
		
		sessionFactory.getCurrentSession().save(userActivity);		
	}
}
