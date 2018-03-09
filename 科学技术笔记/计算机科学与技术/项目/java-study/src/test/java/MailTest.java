import org.junit.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 *
 */
public class MailTest {
    private static final String SENDCLOUD_SMTP_HOST = "smtp.anjuke.com";
    private static final int SENDCLOUD_SMTP_PORT = 25;

    @Test
    public void testMail() throws Exception {
        // 配置javamail
        Properties props = System.getProperties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", SENDCLOUD_SMTP_HOST);
        props.put("mail.smtp.port", SENDCLOUD_SMTP_PORT);
        props.setProperty("mail.smtp.auth", "true");
        // 控制连接和socket timeout 时间
        props.put("mail.smtp.connectiontimeout", 180);
        props.put("mail.smtp.timeout", 600);

        props.setProperty("mail.mime.encodefilename", "true");

        // 认证的用户和密码， 不同于登录站点的用户名和密码，需要登录SendCloud进行发信域名获取
        final String userName = "leqinzhou@anjuke.com";
        final String password = "anjuke4873";

        Session mailSession = Session.getInstance(props, new Authenticator() {
            // 用户验证
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        // 设置调试，打印smtp信息
        // session.setDebug(true);

        Transport transport = mailSession.getTransport();
        MimeMessage message = new MimeMessage(mailSession);
        //Multipart multipart = new MimeMultipart("alternative");
        Multipart multipart = new MimeMultipart("mixed");

        // 纯文本形式的邮件正文
//      BodyPart part1 = new MimeBodyPart();
//      part1.setText("欢迎使用SendCloud", "text/plain;charset=UTF-8");
//		part1.setHeader("Content-Type", "text/plain;charset=UTF-8");
//		part1.setHeader("Content-Transfer-Encoding", "base64");

        // html形式的邮件正文
        BodyPart part2 = new MimeBodyPart();
        part2.setHeader("Content-Type", "text/html;charset=UTF-8");
        part2.setHeader("Content-Transfer-Encoding", "quoted-printable"); // 或者使用base64
        part2.setContent("<html> <head> <style type=\"text/css\"> #customers   {   font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif;   width:100%;   border-collapse:collapse;   }  #customers td, #customers th    {   font-size:1em;   border:1px solid #98bf21;   padding:3px 7px 2px 7px;   }  #customers th    {   font-size:1.1em;   text-align:left;   padding-top:5px;   padding-bottom:4px;   background-color:#A7C942;   color:#ffffff;   }  #customers tr.alt td    {   color:#000000;   background-color:#EAF2D3;   } </style> </head>  <body> <table id=\"customers\"> <tr> <th>Company</th> <th>Contact</th> <th>Country</th> </tr>  <tr> <td>Apple</td> <td>Steven Jobs</td> <td>USA</td> </tr>  <tr class=\"alt\"> <td>Baidu</td> <td>Li YanHong</td> <td>China</td> </tr>  <tr> <td>Google</td> <td>Larry Page</td> <td>USA</td> </tr>  <tr class=\"alt\"> <td>Lenovo</td> <td>Liu Chuanzhi</td> <td>China</td> </tr>  <tr> <td>Microsoft</td> <td>Bill Gates</td> <td>USA</td> </tr>  <tr class=\"alt\"> <td>Nokia</td> <td>Stephen Elop</td> <td>Finland</td> </tr>   </table> </body> </html>", "text/html;charset=UTF-8");


//        multipart.addBodyPart(part1);
        multipart.addBodyPart(part2);

        MimeBodyPart mbp = new MimeBodyPart();

        FileDataSource fds = new FileDataSource("/Users/zlq/Projects/zlq/java-study/pom.xml"); //得到数据源
        mbp.setDataHandler(new DataHandler(fds)); //得到附件本身并至入BodyPart
        mbp.setFileName(fds.getName());  //得到文件名同样至入BodyPart

        multipart.addBodyPart(mbp);

        message.setContent(multipart);
        //message.setFrom(new InternetAddress("from@sendcloud.org"));
        message.setFrom(new InternetAddress("leqinzhou@anjuke.com", "周乐钦", "UTF-8"));
        message.setSubject("欢迎使用java发送邮件", "UTF-8");
        message.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress("leqinzhou@anjuke.com"));
        message.addRecipient(RecipientType.CC, new InternetAddress("leqinzhou@anjuke.com"));

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(javax.mail.Message.RecipientType.TO));
        transport.close();
    }

    @Test
    public void testMail2() throws Exception {
        System.out.println("Sending mail...");
        Properties props = System.getProperties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", SENDCLOUD_SMTP_HOST);
        props.put("mail.smtp.port", SENDCLOUD_SMTP_PORT);
        props.setProperty("mail.smtp.auth", "true");
        // 控制连接和socket timeout 时间
        props.put("mail.smtp.connectiontimeout", 1800);
        props.put("mail.smtp.timeout", 6000);

        final String userName = "leqinzhou@anjuke.com";
        final String password = "anjuke4873";

        Session mailSession = Session.getInstance(props, new Authenticator() {
            // 用户验证
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("HTML  mail with images");
        message.setFrom(new InternetAddress("leqinzhou@anjuke.com"));
        message.addRecipient(RecipientType.TO,
                new InternetAddress("leqinzhou@anjuke.com"));

        //
        // This HTML mail have to 2 part, the BODY and the embedded image
        //
        MimeMultipart multipart = new MimeMultipart("related");

        // first part  (the html)
        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
        messageBodyPart.setContent(htmlText, "text/html");

        // add it
        multipart.addBodyPart(messageBodyPart);

        // second part (the image)
        messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource
                ("/Users/zlq/DSC01332.JPG");
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<image>");

        // add it
        multipart.addBodyPart(messageBodyPart);

        // put everything together
        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(RecipientType.TO));
        transport.close();
    }
}
