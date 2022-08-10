package mail.example;

import mail.example.email.SendMail;
import mail.example.email.SendMailWithBody;

public class Main {
	
	public static void main(String[] args) {
		sendMail();
		sendMailWithContent();
	}
	
	public static void sendMail() {
		SendMail obj = new SendMail();
		obj.sendMail();
	}
	
	public static void sendMailWithContent() {
		SendMailWithBody obj = new SendMailWithBody();
		obj.sendMail();
	}
	
}
