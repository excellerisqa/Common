package reporting;

import javax.mail.MessagingException;

public class TestEmail {

	public static void main(String[] args) throws MessagingException {

		SendMailUsingAuthentication send = new SendMailUsingAuthentication();
		System.out.println(send.postMail("UPP Report", "Test it", "Automation Report.html", false));
		// System.out.println(send.postwithImage("UPP Report"));
	}
}
