package rw.ugv;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendMail {

	/**
	 * @param args
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws MessagingException, IOException {
		// Sending email
		String host = "10.200.2.5";
		String emailFrom = "emergency@minzdrav.by";
		String email = "ircm_kasperovich@mnsk.rw";
		
		Properties sysProps = System.getProperties();
		sysProps.put("mail.smtp.host", host);
		System.out.println(sysProps.getProperty("mail.smtp.port"));
		Session session = Session.getInstance(sysProps,null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(emailFrom));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email,false));
		msg.setSentDate(new Date());
		
			msg.setSubject("Привет засранец");
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText("Или постой... смотри вложение");
//			String[] languages = {"russian","english"};
//			mbp1.setContent("<html><head>" +
//					"<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/></head>" +
//					"<body><h2>Или постой...</h2>" +
//		              "<img src=\"cid:the-img-1\"/></html>", "text/html; charset=utf-8");
//			mbp1.setContentLanguage(languages);
			
			MimeBodyPart mbp2 = new MimeBodyPart();
//			DataSource source = new FileDataSource(new File("zasranec.jpg"));
//		    mbp2.setDataHandler(new DataHandler(source));
//		    mbp2.setDisposition(MimeBodyPart.INLINE);
//		    mbp2.setHeader("Content-ID","the-img-1");
			mbp2.attachFile(new File("zasranec.jpg"));
			MimeMultipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);
			mp.addBodyPart(mbp2);
			msg.setContent(mp);
			
			
		Transport.send(msg);
//		zipFile.delete();

	}

}
