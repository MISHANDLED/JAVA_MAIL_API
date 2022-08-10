package mail.example.email;

import java.util.Properties;

import mail.example.consts.Constants;

public class SetProperties {
	
	public Properties setProperty() {
		
		Properties property = System.getProperties();
		
		property.put("mail.smtp.host", new Constants().getSmtpServer());
		property.put("mail.smtp.port", new Constants().getSmtpPort());
		property.put("mail.smtp.ssl.enable", "true");
		property.put("mail.smtp.auth", "true");
		
		return property;
	}

}
