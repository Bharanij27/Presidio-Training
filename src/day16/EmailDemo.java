package day16;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class EmailDemo {
	public static boolean generateAndSendEmail(String host,
			String port,
			String user,
			String password,
            String subject,
            String mailContents,
            String to) throws MessagingException {
	Properties mailServerProperties;
	// Setup Server Properties
	mailServerProperties = System.getProperties();
	mailServerProperties.put("mail.smtp.port", "587");
	mailServerProperties.put("mail.smtp.auth", "true");
	mailServerProperties.put("mail.smtp.starttls.enable", "true");
	
	// Setup mail session
	//getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	
	Session getMailSession = Session.getInstance(mailServerProperties,
	new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(user, password);
	}
	});
	
	MimeMessage generateMailMessage = new MimeMessage(getMailSession);
	generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	generateMailMessage.setSubject(subject);
	generateMailMessage.setContent(mailContents, "text/html");
	
	// Send Email
	Transport transport = getMailSession.getTransport("smtp");
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	System.out.println("Email sent at :"+dateFormat.format(date));
	
	boolean isSuccess=true;
	try {
		// email and password goes here
		transport.connect("smtp.gmail.com", user, password);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
	} catch(Exception e) {
		e.printStackTrace();
		isSuccess=false;
		} finally {
		transport.close();
	}
	
	System.out.println("Email sent status :"+isSuccess);
	
	return isSuccess;
	
	}
}