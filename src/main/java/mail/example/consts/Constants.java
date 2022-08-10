package mail.example.consts;

import lombok.Data;

@Data
public class Constants {
	
	final String smtpServer = "smtp.gmail.com";
	final String smtpPort = "465";
	final String from = "email-address";
	final String pass = "password";

}
