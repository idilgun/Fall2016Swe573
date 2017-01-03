package com.idil.peoplesHealth.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idil.peoplesHealth.domain.Activity;
import com.idil.peoplesHealth.domain.ActvityHistoryItem;
import com.idil.peoplesHealth.domain.CalorieHistory;
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

		Criteria activityCriteria = sessionFactory.getCurrentSession().createCriteria(Activity.class, "activity");
		activityCriteria.add(Restrictions.like("activity.activityName", activityName + "%"));

		List<Activity> activities = activityCriteria.list();
		if (activities == null || activities.size() == 0) {
			return null;
		}
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		activityList.addAll(activities);

		return activityList;
	}

	@Transactional
	public void addActivityForUser(String activityId, String email, String date, String hours) {

		Activity activity = (Activity) sessionFactory.getCurrentSession().get(Activity.class,
				Integer.valueOf(activityId));

		User user = (User) sessionFactory.getCurrentSession().get(User.class, email);

		User_ActivityPK activityKey = new User_ActivityPK();

		activityKey.setUser(user);

		activityKey.setActivity(activity);

		activityKey.setDateTime(date);

		User_Activity userActivity = new User_Activity();
		userActivity.setUserActivityKey(activityKey);
		userActivity.setHours(Double.valueOf(hours.replace(",", ".")));

		sessionFactory.getCurrentSession().save(userActivity);

	}

	@Transactional
	public ArrayList<ActvityHistoryItem> getActivityForUserDate(String email, String date) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User_Activity.class, "userActivity");
		criteria.add(Restrictions.eq("userActivity.userActivityKey.user.email", email));
		criteria.add(Restrictions.eq("userActivity.userActivityKey.dateTime", date));

		List<User_Activity> userActivityList = criteria.list();

		ArrayList<ActvityHistoryItem> activities = new ArrayList<ActvityHistoryItem>();

		for (int i = 0; i < userActivityList.size(); i++) {
			ActvityHistoryItem activity = new ActvityHistoryItem();
			activity.setActivityName(userActivityList.get(i).getUserActivityKey().getActivity().getActivityName());
			Double hours = userActivityList.get(i).getHours();
			activity.setHours(hours);

			Integer userWeight = userActivityList.get(i).getUserActivityKey().getUser().getWeight();

			if (userWeight == null) {
				userWeight = 70;
			}

			if (userWeight <= 58) {
				activity.setCalorieBurn(
						userActivityList.get(i).getUserActivityKey().getActivity().getCal_hour_58kg() * hours);
			} else if (userWeight <= 70) {
				activity.setCalorieBurn(
						userActivityList.get(i).getUserActivityKey().getActivity().getCal_hour_70kg() * hours);
			} else if (userWeight <= 81) {
				activity.setCalorieBurn(
						userActivityList.get(i).getUserActivityKey().getActivity().getCal_hour_81kg() * hours);
			} else {
				activity.setCalorieBurn(
						userActivityList.get(i).getUserActivityKey().getActivity().getCal_hour_92kg() * hours);
			}

			activities.add(activity);
		}

		return activities;
	}

	@Transactional
	public ArrayList<CalorieHistory> getActivityForUserDate(String email) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User_Activity.class, "userActivity");
		criteria.add(Restrictions.eq("userActivity.userActivityKey.user.email", email));

		List<User_Activity> userActivityList = criteria.list();

		ArrayList<CalorieHistory> calorieBurnHistory = new ArrayList<CalorieHistory>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		for (int i = 0; i < userActivityList.size(); i++) {
			try {
				Date dateTime = formatter.parse(userActivityList.get(i).getUserActivityKey().getDateTime());
				CalorieHistory ch = new CalorieHistory();
				ch.setDateTime(dateTime);

				Double hours = userActivityList.get(i).getHours();

				Integer userWeight = userActivityList.get(i).getUserActivityKey().getUser().getWeight();

				Double calorieBurn;

				if (userWeight == null) {
					userWeight = 70;
				}

				if (userWeight <= 58) {
					calorieBurn = userActivityList.get(i).getUserActivityKey().getActivity().getCal_hour_58kg() * hours;
				} else if (userWeight <= 70) {
					calorieBurn = userActivityList.get(i).getUserActivityKey().getActivity().getCal_hour_70kg() * hours;
				} else if (userWeight <= 81) {
					calorieBurn = userActivityList.get(i).getUserActivityKey().getActivity().getCal_hour_81kg() * hours;
				} else {
					calorieBurn = userActivityList.get(i).getUserActivityKey().getActivity().getCal_hour_92kg() * hours;
				}

				ch.setCalorieValue(calorieBurn);
				calorieBurnHistory.add(ch);

			} catch (ParseException e) {
			}

		}

		return calorieBurnHistory;
	}
	
	@Transactional
	public void updateActicityForUser(String activityId, String email, String date, String hours) {

		
		Activity activity = (Activity) sessionFactory.getCurrentSession().get(Activity.class,
				Integer.valueOf(activityId));

		User user = (User) sessionFactory.getCurrentSession().get(User.class, email);
		
		User_ActivityPK activityKey = new User_ActivityPK();

		activityKey.setUser(user);

		activityKey.setActivity(activity);

		activityKey.setDateTime(date);
		
		User_Activity existingActivity = new User_Activity();
		
		existingActivity.setUserActivityKey(activityKey);
		
		existingActivity.setHours(Double.valueOf(hours.replace(",", "."))*2);
		
		sessionFactory.getCurrentSession().update(existingActivity);
		

	}
}
