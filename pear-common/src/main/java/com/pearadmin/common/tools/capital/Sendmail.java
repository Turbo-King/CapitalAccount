package com.pearadmin.common.tools.capital;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * \* Created with IntelliJ IDEA.
 * \* Author: wzh
 * \* Date: 2021/8/13
 * \* TODO
 * \* Description:
 * \
 */


public class Sendmail {

    /**
     * 发送邮件提醒
     *
     * @param emailAddress 接受邮件地址
     * @param type         业务类型
     * @param content      邮件内容
     * @throws MessagingException
     * @throws GeneralSecurityException
     */
    public static void sendQQMail(String emailAddress, Integer type, String content) throws MessagingException, GeneralSecurityException {
        //创建一个配置文件并保存
        Properties properties = new Properties();

        properties.setProperty("mail.host", "smtp.qq.com");

        properties.setProperty("mail.transport.protocol", "smtp");

        properties.setProperty("mail.smtp.auth", "true");


        //QQ存在一个特性设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        //创建一个session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1362371739@qq.com", "dfciphgxczmlheed");
            }
        });

        //开启debug模式
        session.setDebug(true);

        //获取连接对象
        Transport transport = session.getTransport();

        //连接服务器
        transport.connect("smtp.qq.com", "1362371739@qq.com", "dfciphgxczmlheed");

        //创建邮件对象
        MimeMessage mimeMessage = new MimeMessage(session);

        //邮件发送人
        mimeMessage.setFrom(new InternetAddress("1362371739@qq.com"));

        //邮件接收人
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));

        //邮件标题
        mimeMessage.setSubject("南通职业大学个人金融系统提醒您");

        if (type == 0) {
            //存款
            //邮件内容
            mimeMessage.setContent("账户存入：" + content + "元", "text/html;charset=UTF-8");
        } else if (type == 1) {
            //取款
            //邮件内容
            mimeMessage.setContent("账户取出：" + content + "元", "text/html;charset=UTF-8");
        } else if (type == 3) {
            //转账
            //邮件内容
            mimeMessage.setContent("账户转账：" + content + "元", "text/html;charset=UTF-8");
        } else if (type == 4) {
            //接受转账
            //邮件内容
            mimeMessage.setContent("账户接受转账：" + content + "元", "text/html;charset=UTF-8");
        }


        //发送邮件
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        //关闭连接
        transport.close();
    }

    public static void main(String[] args) {

    }
}

