/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udt.email;

/**
 *
 * @author RTL
 */
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    private static Session session;
    static {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtpcom.263xmail.com");
            props.put("mail.debug", "true");
            props.put("mail.smtp.auth", "true");
            session = Session.getInstance(props, new MyAuth());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendMail("lyang@uptops-dt.com", "no-reply@ding1ding.com", "my test", "How are you?");
    }
    public static void sendMail(String to_addr, String from_addr, String sub, String body) {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from_addr));
            InternetAddress[] address = {new InternetAddress(to_addr)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(sub);
            msg.setSentDate(new Date());
            msg.setText(body);
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

class MyAuth extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("ding1ding@uptops-dt.com", "uptopsding1ding");
    }
}
