package com.gis.MapAdapter.mail;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
public class MailTest {
    @Autowired
    JavaMailSender javaMailSender;
   // @Test
    public void sendMail(){
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage .setFrom("jvy@qq.com");
            simpleMailMessage .setTo("10060832@qq.com");
            simpleMailMessage.setSubject("主题");
            simpleMailMessage.setText("内容");
            javaMailSender.send(simpleMailMessage);//发送
        }catch(Exception e){
            //logger.error("发送失败",e.getMessage());
        }
    }
    //自定义发件人名称/发送html
    @Test
    public void sendHTMLMail() {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            //
            String nick = javax.mail.internet.MimeUtility.encodeText("张三");
            mimeMessageHelper.setFrom(new InternetAddress("jvy@qq.com", nick));
            mimeMessageHelper.setTo("10060832@qq.com");
            mimeMessageHelper.setSubject("主题");
            mimeMessageHelper.setText("<h1>email</h1>", true);

            //带附件格式的邮件
            //文件路径  spring的FileSystemResource,使用绝对路径访问文件资源
            FileSystemResource file = new FileSystemResource(new File("D:\\logging\\spring.log"));
            mimeMessageHelper.addAttachment("spring.log", file);
            //发送带静态资源的邮件
            mimeMessageHelper.setText("<html><body>带静态资源的邮件内容，这个一张IDEA配置的照片:<img src='cid:picture' /></body></html>", true);
            FileSystemResource imageFile = new FileSystemResource(new File("D:\\logging\\mote.jpg"));
            mimeMessageHelper.addInline("picture", imageFile);
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
          //  logger.error("邮件发送失败", e.getMessage());
            System.out.println("邮件发送失败"+e.getMessage());
        }
    }

}
