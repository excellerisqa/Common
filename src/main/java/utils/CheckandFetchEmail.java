package utils;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.commons.lang3.StringUtils;

public class CheckandFetchEmail {
	static String mailtype, host, port, mailStoreType, username, password, finaldataresult;

	public static void main(String[] args) {

		mailtype = "gmail";

		if (mailtype.contains("gmail")) {
			host = "pop.gmail.com";// change accordingly
			port = "995"; // change accordingly
			mailStoreType = "pop3"; // change accordingly
			username = "veeruj001@gmail.com";// change accordingly
			password = "Veerubharu75$";// change accordingly
		} else if (mailtype.contains("jetty")) {
			host = "e23.ehosts.com";// change accordingly
			port = "995"; // change accordingly
			mailStoreType = "pop3"; // change accordingly
			username = "info@jettysoft.com";// change accordingly
			password = "Test@123";// change accordingly
		}

		check(host, port, mailStoreType, username, password, "myresults@lifelabs.com", "<a href=", "</a><BR /><BR />"); // For_UPP_Registration_Link
		// check(host, port, mailStoreType, username, password,
		// "registrar@myehealth.ca", "below:*", "*Please"); // For_UPP_Registration_Link
		// check(host, port, mailStoreType, username, password,
		// "veerendra.jetty@gmail.com", "href=", "class="); //
		// For_UPP_ForgotPassword_Link
		//System.out.println(check(host, port, mailStoreType, username, password, "noreply_appointmentbooking@lifelabs.com", "<td>", "</td><td>")); // For LifeLabs Appointment
		// check("outlook.office365.com", "587", "pop3", "szhang@excelleris.com",
		// "4uSuccess11", "noreply-support@excelleris.com", "Validation code: <b>",
		// "</b>");
	}

	public static String check(String host, String port, String storeType, String user, String password, String fromaddress, String starttext, String endtext) {
		String result = null;
		try {

			// create properties field
			Properties properties = new Properties();

			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", port);
			properties.put("mail.store.protocol", storeType);
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("imaps");

			store.connect(host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("inbox");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			// System.out.println("messages.length---" + messages.length);

			// for (int i = 0; i < messages.length; i++) {
			// Message message = messages[i];
			// System.out.println("---------------------------------");
			// System.out.println("Email Number " + (i + 1));
			// System.out.println("Subject: " + message.getSubject());
			// System.out.println("From: " + message.getFrom()[0]);
			// System.out.println("Text: " + message.getContent().toString());
			// writePart(message, starttext, endtext);
			// }
			// only top one
			loop: for (int i = messages.length - 1; i >= messages.length - 5; i--) {
				Message message = messages[i];
				// System.out.println("---------------------------------");
				// System.out.println("Email Number " + (i + 1));
				// System.out.println("Subject: " + message.getSubject());
				// System.out.println("From: " + message.getFrom()[0]);
				// System.out.println("Text: " + message.getContent().toString());
				Address[] from = message.getFrom();

				if (from[0].toString().contains(fromaddress)) {
					result = writePart(message, starttext, endtext);
					System.out.println("Result : " + result);
					if (result != null) {
						break loop;
					}
				}

			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings({ "resource", "unused" })
	public static String writePart(Part p, String starttext, String endtext) throws Exception {

		if (p instanceof Message)
			// Call methods writeEnvelope
			writeEnvelope((Message) p);

		// System.out.println("----------------------------");
		// System.out.println("CONTENT-TYPE: " + p.getContentType());

		// check if the content is plain text
		if (p.isMimeType("text/plain")) {
			// System.out.println("This is plain text");
			// System.out.println("---------------------------");
			// System.out.println((String) p.getContent());

			String filtered = StringUtils.substringBetween(p.getContent().toString(), starttext, endtext);
			String finaldata = filtered.replaceAll("(?m)^[ \\t]*\\r?\\n", ""); // Remove EMpty Lines
			finaldataresult = finaldata;
		} else if (p.isMimeType("text/*")) {
			// System.out.println("This is plain text");
			// System.out.println("---------------------------");
			// System.out.println((String) p.getContent());

			String filtered = StringUtils.substringBetween(p.getContent().toString(), starttext, endtext);
			String finaldata = filtered.replaceAll("(?m)^[ \\t]*\\r?\\n", ""); // Remove EMpty Lines
			finaldataresult = finaldata;
		}
		// check if the content has attachment
		else if (p.isMimeType("multipart/*")) {
			// System.out.println("This is a Multipart");
			// System.out.println("---------------------------");
			Multipart mp = (Multipart) p.getContent();
			int count = mp.getCount();
			for (int i = 0; i < count; i++) {
				if (mp.getBodyPart(i) != null) {
					writePart(mp.getBodyPart(i), starttext, endtext);
					break;
				}

			}
		}
		// check if the content is a nested message
		else if (p.isMimeType("message/rfc822")) {
			// System.out.println("This is a Nested Message");
			// System.out.println("---------------------------");
			writePart((Part) p.getContent(), starttext, endtext);
		}
		// check if the content is an inline image
		else if (p.isMimeType("image/jpeg")) {
			// System.out.println("--------> image/jpeg");
			// Object o = p.getContent();
			//
			// InputStream x = (InputStream) o;
			// // Construct the required byte array
			// System.out.println("x.length = " + x.available());
			// while ((i = x.available()) > 0) {
			// int result = (int) (x.read(bArray));
			// if (result == -1)
			// int i = 0;
			// byte[] bArray = new byte[x.available()];
			//
			// break;
			// }
			// FileOutputStream f2 = new FileOutputStream("/tmp/image.jpg");
			// f2.write(bArray);
		} else if (p.getContentType().contains("image/")) {
			// System.out.println("content type" + p.getContentType());
			File f = new File("image" + new Date().getTime() + ".jpg");
			DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			com.sun.mail.util.BASE64DecoderStream test = (com.sun.mail.util.BASE64DecoderStream) p.getContent();
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = test.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
			output.close();
		} else {
			Object o = p.getContent();
			if (o instanceof String) {
				// System.out.println("This is a string");
				// System.out.println("---------------------------");
				// System.out.println((String) o);
			} else if (o instanceof InputStream) {
				// System.out.println("This is just an input stream");
				// System.out.println("---------------------------");
				InputStream is = (InputStream) o;
				is = (InputStream) o;

				int c;
				while ((c = is.read()) != -1)
					System.out.write(c);

			} else {
				// System.out.println("This is an unknown type");
				// System.out.println("---------------------------");
				// System.out.println(o.toString());
			}
		}
		return finaldataresult;
	}

	/*
	 * This method would print FROM,TO and SUBJECT of the message
	 */
	public static void writeEnvelope(Message m) throws Exception {
		// System.out.println("This is the message envelope");
		// System.out.println("---------------------------");
		Address[] a;

		// FROM
		if ((a = m.getFrom()) != null) {
			for (int j = 0; j < a.length; j++) {
				// System.out.println("FROM: " + a[j].toString());
			}
		}

		// TO
		if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
			for (int j = 0; j < a.length; j++) {
				// System.out.println("TO: " + a[j].toString());
			}
		}

		// SUBJECT
		if (m.getSubject() != null) {
			// System.out.println("SUBJECT: " + m.getSubject());
		}
	}

}
