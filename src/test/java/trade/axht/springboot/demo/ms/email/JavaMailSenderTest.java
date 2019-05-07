package trade.axht.springboot.demo.ms.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 描述:
 * JavaMailSender
 *
 * @outhor Administrator
 * @create 2018-01-04 21:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaMailSenderTest {
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() throws Exception{
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo("798121446@qq.com");
        message.setFrom("Lixuanshengchao@163.com");
        message.setSubject("主题：简单邮件");
        message.setText("<html><body><img src='https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2898129024,2973248828&fm=173&s=34866CB642C578F96E229DEF0300D029&w=640&h=1067&img.JPG' ></body></html>");
        mailSender.send(message);
    }

    @Test
    public void sendAttachmentsMail() throws MessagingException {
        MimeMessage mimeMailMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMailMessage,true);
        helper.setFrom("Lixuanshengchao@163.com");
        helper.setTo("798121446@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");
        String filePath=System.getProperty("user.dir")+File.separator+"target"+File.separator+"classes"+File.separator+"webapp"+File.separator+"aa.png";
        FileSystemResource fileSystemResource=new FileSystemResource(new File(filePath));
        helper.addAttachment("附件-1.jpg",fileSystemResource);
        helper.addAttachment("附件-2.jpg",fileSystemResource);
        mailSender.send(mimeMailMessage);

    }

    @Test
    public void sendInlineMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("Lixuanshengchao@163.com");
        helper.setTo("798121446@qq.com");
        helper.setSubject("主题：有图片");
        String filePath=System.getProperty("user.dir")+File.separator+"target"+File.separator+"classes"+File.separator+"webapp"+File.separator+"aa.png";
        helper.setText("<html><body><img src=\"cid:tea\" ></body></html>", true);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        helper.addInline("tea", file);

        mailSender.send(mimeMessage);
    }





    @Test
    public void testPath(){
        System.out.println(System.getProperty("user.dir"));
    }

}
