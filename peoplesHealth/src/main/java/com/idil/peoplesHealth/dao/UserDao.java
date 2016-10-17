package com.idil.peoplesHealth.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idil.peoplesHealth.domain.User;

@Component
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public User createNewUser(final User userDetails){
		sessionFactory.getCurrentSession().save(userDetails);
		return userDetails;
	}
}
