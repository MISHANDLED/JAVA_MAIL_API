package mail.example.email;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import mail.example.consts.Constants;

public class SendMailWithBody {
	
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
		MimeMultipart content = new MimeMultipart();
		MimeBodyPart text = new MimeBodyPart();
		MimeBodyPart img = new MimeBodyPart();
		
		try {
			
			File file = new File("C:\\Users\\Hp\\Downloads\\Devansh_Mohata.pdf");
			img.attachFile(file);
			
			// For Normal Text
			text.setText("Hasta La Vista","utf-8"); 
			
			// For HTML Text
			text.setContent("<b>Hasta La Vista<b>", "text/html; charset=utf-8"); 
			
			content.addBodyPart(img);
			content.addBodyPart(text);
			
			obj.setFrom(new Constants().getFrom());
			obj.addRecipient(Message.RecipientType.TO, new InternetAddress("friend-email-address-1"));
			obj.addRecipient(Message.RecipientType.TO, new InternetAddress("friend-email-address-2"));
			obj.addRecipient(Message.RecipientType.TO, new InternetAddress("friend-email-address-3"));
			obj.setSubject("Subject");
			obj.setContent(content);
			
			Transport.send(obj);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
