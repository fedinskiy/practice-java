package ru.innopolis.log4j;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.spi.LoggingEvent;

import java.io.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by fedinskiy on 14.02.17.
 */
public class MailAppender extends AppenderSkeleton {
    private String text="";
    private String topic="";

    @Override
    protected void append(LoggingEvent  event) {
        MailLayout layout= (MailLayout) this.getLayout();

         topic = layout.formatTopic(event);
         text = text+layout.formatText(event);

    }

    @Override
    public void close() {
        try {
            sendMail(topic, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public static void sendMail(String topic,String text) throws IOException {
        File passfile= new File("/home/fedinskiy/myfolder/pass");
        String password=(new BufferedReader(  new FileReader(passfile)))
                .readLine();
        final String username = "f.dudinskiy.stc@innopolis.ru";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.innopolis.ru");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.timeout", 3000);
        System.out.println(password);
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("f.dudinskiy.stc@innopolis.ru"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("matroscin1@yandex.ru"));
            message.setSubject(topic);
            message.setText(text);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
