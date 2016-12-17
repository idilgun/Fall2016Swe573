package com.idil.peoplesHealth.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.idil.peoplesHealth.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class UserControllerTest {

	@Autowired
	UserController userController;
	
	@Test
	public void testAuthorizeUser() {
		assertEquals(HttpStatus.OK, userController.authorizeUser("idilgun@gmail.com", "123456").getStatusCode());
	}
}
