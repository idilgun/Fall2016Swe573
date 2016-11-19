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
	
}
