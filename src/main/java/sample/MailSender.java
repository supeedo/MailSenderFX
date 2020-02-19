package sample;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class MailSender {
    final String username;
    final String password;
    final String emailFrom;
    final String emailSubject;
    final String emailText;
    final String mimeType;
    final Properties properties;

    //конструктор
    MailSender( String smtpServer, String username, String password, String emailFrom, String emailSubject, String emailText, String mimeType ) {
        this.username = username;
        this.password = password;
        this.emailFrom = emailFrom;
        this.emailSubject = emailSubject;
        this.emailText = emailText;
        this.mimeType = mimeType;

        properties = new Properties();
        properties.put("mail.smtp.host", smtpServer);
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

    }
    //??? переделать!!!
    ParserFile excelParser = new ParserFile();
    List<String> list = excelParser.readFromExcel();


    public void sendMail() {

        Session session = Session.getInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        Transport transport = null;
        try {
            transport = session.getTransport("smtp");
            transport.connect();
        }catch (MessagingException e){
            e.printStackTrace();
        }
        if(transport != null) {
            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(emailFrom));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse("client_mail"));
                message.setSubject(emailSubject);
                message.setText(emailText);

                Transport.send(message);

                System.out.println("Done");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

}