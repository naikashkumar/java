import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class TestSendEmail
{
   public static void main(String [] args)
   {    
      String to = "kiran_sp@google.com";
      String from = "fromsomeone@google.com";

      Properties props = System.getProperties();

      props.put("mail.smtp.host", "relay.google.com");

      props.put("mail.smtp.port", "25");

      Session session = Session.getDefaultInstance(props);

      try{

         
         Message message = new MimeMessage(session);

         message.setFrom(new InternetAddress(from));

         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));

         message.setSubject("Sample Subject");

         BodyPart messageBodyPart = new MimeBodyPart();

         messageBodyPart.setText("Sample body....");

         Multipart multipart = new MimeMultipart();

         multipart.addBodyPart(messageBodyPart);

         //messageBodyPart = new MimeBodyPart();
         //String filename = "/Users/ashok.naik/Documents/softwares/TestSendEmail.txt";
        // DataSource source = new FileDataSource(filename);
        // messageBodyPart.setDataHandler(new DataHandler(source));
         //messageBodyPart.setFileName(filename);
        //multipart.addBodyPart(messageBodyPart);

         message.setContent(multipart);
         
         Transport.send(message);
         
         
         System.out.println("Sent message successfully....");
         
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
