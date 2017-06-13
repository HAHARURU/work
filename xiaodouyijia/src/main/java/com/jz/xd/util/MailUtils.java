package com.jz.xd.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by HARU on 2017/4/21.
 */
public class MailUtils {
    public static String[] sendTxtMail(String mail) {
        String[] s = new String[2];
        String sixString = RandomNumber.randomString(100000, 999999);
        s[0] = sixString;
        Properties props = new Properties();
        Session session = Session.getInstance(props, null);
        session.setDebug(true);//打开debug模式，会打印发送细节到console
        Message message = new MimeMessage(session); //实例化一个MimeMessage集成自abstract Message 。参数为session
        try {
            message.setFrom(new InternetAddress("xdyj@xiaodouwangluo.com")); //设置发出方,使用setXXX设置单用户，使用addXXX添加InternetAddress[]
            message.setText("验证码是【" + sixString + "】，请在4分钟内进行验证！\n——来自安徽小豆网络科技有限公司"); //设置文本内容 单一文本使用setText,Multipart复杂对象使用setContent
            message.setSubject("小豆一家邮箱验证码"); //设置标题
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail)); //设置接收方
            /**
             *使用静态方法每次发送需要建立一个到smtp服务器的链接，你可以手动控制连接状态 ，
             * 通过session获得tansport，连接到mailserver，而session就可以使用Session.getDefaultInstance(props,null)获得*/
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.xiaodouwangluo.com", "xdyj@xiaodouwangluo.com", "Xd123456yj");
            transport.sendMessage(message, message.getAllRecipients());
            s[1] = Long.toString(System.currentTimeMillis());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            //此处处理MessagingException异常 [The base class for all exceptions thrown by the Messaging classes ]
        }
        return s;
    }
}
