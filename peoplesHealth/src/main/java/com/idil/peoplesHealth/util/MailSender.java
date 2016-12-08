package com.idil.peoplesHealth.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.idil.peoplesHealth.domain.User;

@Component
public class MailSender {
	
	
	public void sendForgottenPasswordMailTo(User user, JavaMailSender javaMailSender)  throws MessagingException{
		MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        
        String body = "Your password is: " + user.getPassword();
        
        helper = new MimeMessageHelper(message, true);
        helper.setSubject("Password for People's Health");
        helper.setTo(user.getEmail());
        try{
        	helper.setFrom("peoples.health1@gmail.com", "Team People's Health");
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        helper.setText(body);
        javaMailSender.send(message);
	}
	
	public void sendHelloMailTo(User user, JavaMailSender javaMailSender) {
		try{
			MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper;
	        
	        String body = "Hello "+ user.getName() + "!"
	        				+ "\n\nWe are very happy to see you on people's health!"
	        				+ "\n\nThe first step to begin a healthy and fit life is the most important, and the hardest step. "
	        				+ "\nCongratulations on that!"
	        				+ "\nWe are here to help you accomplish your goals."
	        				+ "\n\nWe would like you to note that people's health is a new and developing idea and we are always open to user feedback so that we can bring you the best possible service. We would deeply appreciate if you take the time to share your ideas with us.";
	        
	        helper = new MimeMessageHelper(message, true);
	        helper.setSubject("Welcome to People's Health");
	        helper.setTo(user.getEmail());
	        helper.setFrom("peoples.health1@gmail.com", "Team People's Health");
	        helper.setText(body);
	        
	        javaMailSender.send(message);
	        
		}catch(Exception e){
        	e.printStackTrace();
        }
		
	}
	
}
