package com.idil.peoplesHealth.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idil.peoplesHealth.domain.User;
import com.idil.peoplesHealth.domain.UserHistory;
import com.idil.peoplesHealth.domain.User_FoodItem;
import com.idil.peoplesHealth.domain.UserHistory.email_dateTimeId;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@Component
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void createNewUser(final User userDetails){	
		sessionFactory.getCurrentSession().save(userDetails);
	}

	@Transactional
	public User getUserDetails(String email) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, email);
		return user;
	}

	@Transactional
	public boolean updateUser(User userDetail) {
		
		User user = (User) sessionFactory.getCurrentSession().get(User.class, userDetail.getEmail());
		if(user == null){
			return false;
		}
		UserHistory userHistory = new UserHistory();
		Date now = new Date();
		email_dateTimeId id = new email_dateTimeId();
		id.setEmail(userDetail.getEmail());
		id.setDateTime(now);
		userHistory.setId(id);
		
		int check = 0;
		
		if(userDetail.getHeight()!=null){
			user.setHeight(userDetail.getHeight());
			userHistory.setHeight(userDetail.getHeight());
			check ++;
		}
		if(userDetail.getNotes()!=null){
			user.setNotes(userDetail.getNotes());
		}
		if(userDetail.getWeight()!=null){
			user.setWeight(userDetail.getWeight());
			userHistory.setWeight(userDetail.getWeight());
			check ++;
		}
		sessionFactory.getCurrentSession().update(user);
		
		// update user history only if at least one of weight or height is being updated
		if(check>0){
			sessionFactory.getCurrentSession().save(userHistory);
		}
		return true;
		
	}

	@Transactional
	public List<UserHistory> getUserWeightHistory(String email) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserHistory.class,
				"userHistory");
		criteria.add(Restrictions.eq("userHistory.id.email", email));

		List<UserHistory> userHistoryList = criteria.list();
		
		return userHistoryList;
	}
}
