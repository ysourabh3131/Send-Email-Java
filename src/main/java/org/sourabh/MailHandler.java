package org.sourabh;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {
    void sendMail(){
        Properties sysProperties = System.getProperties(); //this gives me a Hash-map/ Hash-Table

        System.out.println(sysProperties);

        sysProperties.put("mail.smtp.host",MailMetaData.HostServer);
        sysProperties.put("mail.smtp.port",MailMetaData.port);
        sysProperties.put(MailMetaData.sslProperty,"true");
        sysProperties.put(MailMetaData.authPerm,"true");

        //create a session using sender-email and password
        Authenticator mailAuthenticator = new CustomizedMailAuthentication();

        Session mailSession = Session.getInstance(sysProperties,mailAuthenticator);


        //mime message build
        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
            mailMessage.setFrom(MailMetaData.myUserMail);
            mailMessage.setSubject("This is My Java Code Testing");
            mailMessage.setText("Hi, This is Sourabh Yadav trying to send message using Java");

            //set the receiver
            Address receiverEmail = new InternetAddress(MailMetaData.receiverMail);

            mailMessage.setRecipient(Message.RecipientType.TO, receiverEmail);

            Transport.send(mailMessage);
        }
        catch (Exception mailException){
            System.out.println(mailException.toString());
        }

    }
}
