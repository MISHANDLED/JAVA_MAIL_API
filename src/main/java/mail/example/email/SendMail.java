package mail.example.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import mail.example.consts.Constants;

public class SendMail {
	
	public void sendMail() {
		
		Properties props = new SetProperties().setProperty();
		
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(new Constants().getFrom(), new Constants().getPass());
			}
			
		});
		
		session.setDebug(true);
		
		MimeMessage obj = new MimeMessage(session);
		try {
			
			obj.setFrom(new Constants().getFrom());
			obj.addRecipient(Message.RecipientType.TO, new InternetAddress("friend-email-address-1"));
			obj.addRecipient(Message.RecipientType.TO, new InternetAddress("friend-email-address-2"));
			obj.addRecipient(Message.RecipientType.TO, new InternetAddress("friend-email-address-3"));
			
			obj.setSubject("Subject");
			obj.setText("Content");
			
			Transport.send(obj);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
