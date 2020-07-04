package msg.user.control.computation;

/**
 * Document me.
 *
 * @author Gianina Gaita
 */

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Document me.
 *
 * @author Gianina Gaita
 */
@Stateless
public class ComputationProcessor {
    @Asynchronous
    public void sendEmail(String emailAddress, String firstName, String userName, String userPassword) {
        final String username = "gianinagaita97@gmail.com";
        final String password = "24041997181824Tmgbg";
        System.out.println("PREPARING TO SEND MESSAGE!!!!!!!!!");
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(emailAddress));
            message.setSubject("Welcome to Software Issues Tracking System");
            message.setText("Dear " + firstName + ","
                    + "\n\n You're new account has been created. You can start using our application with the credentials" +
                    " that you'll find in this email"
                    + "\n\n" + "We're strongly suggesting you to change you're password when you log in for the first time in our application"
                    + "\n\n" + "Username: " + userName
                    + "\n\n" + "Password: " + userPassword
                    + "\n\n"
                    + "\n\n"
                    + "\n\n" + "Thank you,"
                    + "\n\n" + "Software Issues Tracking System Administrator");


            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}