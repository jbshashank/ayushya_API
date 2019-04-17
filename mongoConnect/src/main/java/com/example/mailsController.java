package com.example.mongoConnect;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class mailsController {
	
	private String toEmail;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String sendMail(@RequestBody JSONObject mailAttributes) {
		String emailPort = "587";
		Properties emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		if(mailAttributes.get("toEmail") != null) {
			toEmail = mailAttributes.get("toEmail").toString();
		}else {
			toEmail = "shreyas.shivajirao@gmail.com";
		}
		String emailSubject = mailAttributes.get("Subject").toString();
		String emailBody = mailAttributes.get("Body").toString();
		Session mailSession = Session.getDefaultInstance(emailProperties, null);
		MimeMessage message = new MimeMessage(mailSession);
		try {
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(emailSubject);
			message.setText(emailBody);
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		}
		
		String emailHost = "smtp.gmail.com";
		String fromUser = "trupthin.murthy";
		String fromUserPass = "*******";
		try {
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(emailHost, fromUser, fromUserPass);
			System.out.println("connected successfuly");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Email Sent successfully");
		} catch (AddressException e) {
			System.out.println(e.getMessage());
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		}
		
		return "Mail Sent";
	}


}
