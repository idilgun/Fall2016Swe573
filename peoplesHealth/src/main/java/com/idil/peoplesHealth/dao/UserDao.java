package com.idil.peoplesHealth.dao;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idil.peoplesHealth.domain.User;
import com.idil.peoplesHealth.domain.UserHistory;
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
		
		if(userDetail.getHeight()!=null){
			user.setHeight(userDetail.getHeight());
			userHistory.setHeight(userDetail.getHeight());
		}
		if(userDetail.getNotes()!=null){
			user.setNotes(userDetail.getNotes());
			userHistory.setNotes(userDetail.getNotes());
		}
		if(userDetail.getWeight()!=null){
			user.setWeight(userDetail.getWeight());
			userHistory.setWeight(userDetail.getWeight());
		}
		sessionFactory.getCurrentSession().update(user);
		sessionFactory.getCurrentSession().save(userHistory);
		return true;
		
	}
}
