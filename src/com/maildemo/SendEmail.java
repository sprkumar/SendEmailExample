package com.maildemo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public static void main(String[] args) {
		String to = "ravindra.kumar@accionlabs.com";
		String from = "ravindrakumarjrd@gmail.com";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port", 587);
		
		Session session =Session.getDefaultInstance(properties, new Authenticator() {
			 protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				 return new javax.mail.PasswordAuthentication("ravindrakumarjrd@gmail.com", "Ravi_333");
			 }
		});
		try {
			
			MimeMessage message= new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("SMTP Testing");
			message.setText("This is SMTP auto generated mail!");
			Transport.send(message);
			System.out.println("Message sent successfully.....!!");
			
		} catch (MessagingException me) {
			me.printStackTrace();
		}
		
		
		
	}
}
