package reporting;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.http.entity.mime.content.FileBody;

import utils.ObjectHelper;

public class SendMailUsingAuthentication {

	private static final String encodingOptions = "text/html; charset=UTF-8";
	private static String SMTP_PORT = "587";

	private static String SMTP_HOST_NAME = "outlook.office365.com"; //
	public static String SMTP_AUTH_USER = "vjetty@excelleris.com";//
	private static String SMTP_AUTH_PWD = "Welcome2"; // Password

	static Properties props1 = null;

	// Add List of Email address to who email needs to be sent to
	public String postMail(String subject, String message, String attachName, boolean sendreport) throws MessagingException {

		String returnValue = "failure";

		String[] recipients = new String[30];

		try {

			recipients = EmailList.email.split(",");

			boolean debug = false;
			// Set the host smtp address
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			SMTPAuthenticator auth = new SMTPAuthenticator();
			Session session = Session.getDefaultInstance(props, auth); // using

			session.setDebug(debug);

			// create a message
			Message msg = new MimeMessage(session);

			// set the from and to address
			InternetAddress addressFrom = new InternetAddress(SMTP_AUTH_USER);
			msg.setFrom(addressFrom);

			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i]);
			}
			msg.setRecipients(Message.RecipientType.TO, addressTo);

			msg.setSubject(subject + " - " + EmailSubject.buildNum + " - " + ObjectHelper.startdate);

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart("related");

			// Converting xlsx to htm
			// String sourcePath = new File(".",
			// "//TestData//emailablereport.xlsx").getAbsolutePath();
			// String destPath = new File(".",
			// "//TestData//emailablereport.htm").getAbsolutePath();
			// ExcelToHtml toHtml = ExcelToHtml.create(sourcePath, new PrintWriter(new
			// FileWriter(destPath)));
			// toHtml.setCompleteHTML(true);
			// toHtml.skipSheet(1);
			// toHtml.printPage();
			//
			// // Print only Cell 1 - 6 of sheet 1
			// ExcelToHtml.SheetCellSpan sheetOneCellSpan =
			// ExcelToHtml.createSheetCellSpan(0, 4);
			// toHtml.addSheetCellSpan(0, sheetOneCellSpan);
			//
			// StringBuffer reportdata = new StringBuffer();
			// BufferedReader in = new BufferedReader(new FileReader(new
			// File(destPath).getAbsolutePath()));
			// String data = null;
			// while ((data = in.readLine()) != null) {
			// reportdata.append(data);
			// }
			// in.close();
			//
			// // messageBodyPart.addHeader("content-type", "html/text; UFT-8");
			// // messageBodyPart.setText(reportdata.toString());
			// messageBodyPart.setContent(reportdata.toString(), "text/html");
			messageBodyPart.setContent(message, "text/html");
			multipart.addBodyPart(messageBodyPart);

			// Adding Image
			// messageBodyPart = new MimeBodyPart();
			// DataSource image = new FileDataSource(new File(".",
			// "//TestData//emailablereport.PNG").getAbsolutePath());
			// messageBodyPart.setDataHandler(new DataHandler(image));
			// messageBodyPart.setHeader("Content-ID", "<image>");
			//
			// // add image to the multipart
			// multipart.addBodyPart(messageBodyPart);

			// Part three is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(new File(".", "\\TestData\\emailablereport.pdf").getAbsolutePath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(attachName);
			multipart.addBodyPart(messageBodyPart);

			if (sendreport) {
				// Part four is attach html report
				messageBodyPart = new MimeBodyPart();
				DataSource source1 = new FileDataSource(new File(".", ObjectHelper.reportsFolder + "\\" + subject + ".html").getAbsolutePath());
				messageBodyPart.setDataHandler(new DataHandler(source1));
				messageBodyPart.setFileName(subject + ".html");
				multipart.addBodyPart(messageBodyPart);
			}

			// addAttachment(multipart);

			msg.setContent(multipart);

			XTrustProvider.install();
			Transport.send(msg);

			returnValue = "success";
			// reportdata = null;

		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "error";
		}
		return returnValue;
	}

	public String postMailforQA(String subject, String message, String attachName, boolean sendreport) throws MessagingException {

		String returnValue = "failure";

		String[] recipients = new String[2];

		try {

			recipients[0] = "vjetty@excelleris.com";

			recipients = EmailList.email.split(",");

			boolean debug = false;
			// Set the host smtp address
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			SMTPAuthenticator auth = new SMTPAuthenticator();
			Session session = Session.getDefaultInstance(props, auth); // using

			session.setDebug(debug);

			// create a message
			Message msg = new MimeMessage(session);

			// set the from and to address
			InternetAddress addressFrom = new InternetAddress(SMTP_AUTH_USER);
			msg.setFrom(addressFrom);

			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i]);
			}
			msg.setRecipients(Message.RecipientType.TO, addressTo);

			msg.setSubject(subject + " - " + EmailSubject.buildNum + " - " + ObjectHelper.startdate);

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart("related");

			// Converting xlsx to htm
			// String sourcePath = new File(".",
			// "//TestData//emailablereport.xlsx").getAbsolutePath();
			// String destPath = new File(".",
			// "//TestData//emailablereport.htm").getAbsolutePath();
			// ExcelToHtml toHtml = ExcelToHtml.create(sourcePath, new PrintWriter(new
			// FileWriter(destPath)));
			// toHtml.setCompleteHTML(true);
			// toHtml.skipSheet(1);
			// toHtml.printPage();
			//
			// // Print only Cell 1 - 6 of sheet 1
			// ExcelToHtml.SheetCellSpan sheetOneCellSpan =
			// ExcelToHtml.createSheetCellSpan(0, 4);
			// toHtml.addSheetCellSpan(0, sheetOneCellSpan);
			//
			// StringBuffer reportdata = new StringBuffer();
			// BufferedReader in = new BufferedReader(new FileReader(new
			// File(destPath).getAbsolutePath()));
			// String data = null;
			// while ((data = in.readLine()) != null) {
			// reportdata.append(data);
			// }
			// in.close();
			//
			// // messageBodyPart.addHeader("content-type", "html/text; UFT-8");
			// // messageBodyPart.setText(reportdata.toString());
			// messageBodyPart.setContent(reportdata.toString(), "text/html");
			messageBodyPart.setContent(message, "text/html");
			multipart.addBodyPart(messageBodyPart);

			// Adding Image
			// messageBodyPart = new MimeBodyPart();
			// DataSource image = new FileDataSource(new File(".",
			// "//TestData//emailablereport.PNG").getAbsolutePath());
			// messageBodyPart.setDataHandler(new DataHandler(image));
			// messageBodyPart.setHeader("Content-ID", "<image>");
			//
			// // add image to the multipart
			// multipart.addBodyPart(messageBodyPart);

			// Part three is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(new File(".", "\\TestData\\emailablereport.pdf").getAbsolutePath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(attachName);
			multipart.addBodyPart(messageBodyPart);

			if (sendreport) {
				// Part four is attach html report
				messageBodyPart = new MimeBodyPart();
				DataSource source1 = new FileDataSource(new File(".", ObjectHelper.reportsFolder + "\\" + subject + ".html").getAbsolutePath());
				messageBodyPart.setDataHandler(new DataHandler(source1));
				messageBodyPart.setFileName(subject + ".html");
				multipart.addBodyPart(messageBodyPart);
			}

			// addAttachment(multipart);

			msg.setContent(multipart);

			XTrustProvider.install();
			Transport.send(msg);

			returnValue = "success";
			// reportdata = null;

		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "error";
		}
		return returnValue;
	}

	@SuppressWarnings("unused")
	private static void addAttachment(Multipart multipart) {
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(new File(".", "/conf").getAbsolutePath() + File.separator + "filename.html");
		try {
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("TERMS-AND-CONDITIONS.docx");
			multipart.addBodyPart(messageBodyPart);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public String postMailWithOutAttachment(String recipients[], String subject, String message, String from) throws MessagingException {

		String returnValue = "failure";

		try {

			boolean debug = false;
			// Set the host smtp address
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "e23.ehosts.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			// props.put("mail.smtp.socketFactory.fallback", "true");

			SMTPAuthenticator auth = new SMTPAuthenticator();
			Session session = Session.getDefaultInstance(props, auth);

			session.setDebug(debug);

			// create a message
			Message msg = new MimeMessage(session);

			// set the from and to address
			InternetAddress addressFrom = new InternetAddress("support@jettysoft.com");
			msg.setFrom(addressFrom);

			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i]);
			}
			msg.setRecipients(Message.RecipientType.TO, addressTo);
			// Setting the Subject and Content Type
			msg.setSubject(subject);
			/*
			 * if (props1 !=null && props1.getProperty("subject") != null &&
			 * props1.getProperty("subject") != ""){
			 * msg.setSubject(props1.getProperty("subject")); } else {
			 * msg.setSubject(subject); }
			 */

			msg.setContent(message, "text/html");
			/*
			 * if (props1 !=null && props1.getProperty("body") != null &&
			 * props1.getProperty("body") != ""){
			 * msg.setContent(props1.getProperty("body"),"text/html"); } else {
			 * msg.setContent(message, "text/html"); }
			 */
			msg.setHeader("Content-Type", encodingOptions);
			XTrustProvider.install();
			Transport.send(msg);
			returnValue = "success";

		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "error";
		}
		return returnValue;
	}

	@SuppressWarnings("unused")
	public String postwithImage(String subject) throws MessagingException {

		String returnValue = "failure";
		String[] recipients = new String[30];

		try {

			boolean debug = false;
			// Set the host smtp address
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			// props.put("mail.smtp.socketFactory.fallback", "true");

			recipients = EmailList.email.split(",");

			SMTPAuthenticator auth = new SMTPAuthenticator();
			Session session = Session.getDefaultInstance(props, auth);

			session.setDebug(debug);

			// create a message
			Message msg = new MimeMessage(session);

			// set the from and to address
			InternetAddress addressFrom = new InternetAddress("donotreply");
			msg.setFrom(addressFrom);

			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i]);
			}
			msg.setRecipients(Message.RecipientType.TO, addressTo);
			// Setting the Subject and Content Type
			msg.setSubject(subject);

			// This mail has 2 part, the BODY and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");

			// First part
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("", "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);

			Map<String, String> mapInlineImages = new HashMap<String, String>();
			mapInlineImages.put("Report", new File(".", "//TestData//emailablereport.png").getAbsolutePath());

			// adds inline image attachments
			if (mapInlineImages != null && mapInlineImages.size() > 0) {
				Set<String> setImageID = mapInlineImages.keySet();

				for (String contentId : setImageID) {
					MimeBodyPart imagePart = new MimeBodyPart();
					imagePart.setHeader("Content-ID", "<" + contentId + ">");
					imagePart.setDisposition(MimeBodyPart.INLINE);

					FileBody fb = new FileBody(new File(new File(".", "//TestData//emailablereport.png").getAbsolutePath()));
					String imageFilePath = mapInlineImages.get(contentId);
					try {
						imagePart.attachFile(imageFilePath);
					} catch (IOException ex) {
						ex.printStackTrace();
					}

					multipart.addBodyPart(imagePart);
				}
			}

			// DataSource image = new FileDataSource(new File(".",
			// "//TestData//emailablereport.png").getAbsolutePath());
			// if (image != null) {
			// // second part (the image)
			// messageBodyPart = new MimeBodyPart();
			//
			// messageBodyPart.setDataHandler(new DataHandler(image));
			// // messageBodyPart.setHeader("Content-Type", "image/jpg; name=image.jpg");
			// messageBodyPart.setHeader("Content-ID", "<image>");
			//
			// // add image to the multipart
			// multipart.addBodyPart(messageBodyPart);
			// }

			// put everything together
			msg.setContent(multipart);

			XTrustProvider.install();
			Transport.send(msg);
			returnValue = "success";

		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "error";
		}
		return returnValue;
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		@Override
		public javax.mail.PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new javax.mail.PasswordAuthentication(username, password);
		}
	}

}
