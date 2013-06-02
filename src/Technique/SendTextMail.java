package Technique;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class SendTextMail
{
    Properties prop = new Properties();
    Session session;
    Message msg;
    
    public void getMailProperties()
    {
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port","587");
    }
    
    public void getMailMessage(final Mail mail)
    {
        Authenticator auth = new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(mail.getMailAdrSender(),mail.getPwd());
            }
        };
        session = Session.getInstance(prop,auth);
        msg = new MimeMessage(session);
        try 
        {
            InternetAddress recipient = new InternetAddress(mail.getMailAdrRecipient());
            msg.setRecipient(Message.RecipientType.TO,recipient);
            msg.setSubject(mail.getMailSubject());
            MimeBodyPart mbp =  new MimeBodyPart();
            mbp.setText(mail.getMailObject());
            MimeMultipart mmp = new MimeMultipart();
            mmp.addBodyPart(mbp);
            if(mail.getAttachment() != null)
            {
                try 
                {
                    MimeBodyPart mattch = new MimeBodyPart();
                    mattch.attachFile(mail.getAttachment());
                    mmp.addBodyPart(mattch);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            msg.setContent(mmp);
       } catch (MessagingException ex) {System.out.println(ex.getMessage());}
        
    }
    
    public boolean sendMessage()
    {
        boolean t = false;
        try
        {
            Transport.send(msg);
            t = true;
        } catch (MessagingException ex) {System.out.println(ex.getMessage());}
        return t;
    }
    
    
}