/**
 * 上午10:30:51
 */
package com.hsnn.medstgmini.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author hsnn
 *
 */
public class EmailUtil {
	private static String USER_KEY="user";
	private static String PASSWORD_KEY="password";
	private static String MAIL_HOST_KEY="mail.host";
	private static String ADDRESSES_KEY="addresses";
    
    public static void sendTextMail(Properties prop, String subject, String content) throws Exception {
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect(prop.getProperty(MAIL_HOST_KEY).trim(),prop.getProperty(USER_KEY).trim(), prop.getProperty(PASSWORD_KEY).trim());
        //4、创建邮件
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        InternetAddress form = new InternetAddress(prop.getProperty(USER_KEY).trim());
        message.setFrom(form);
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        String[] addresses = prop.getProperty(ADDRESSES_KEY).trim().split(",");
        InternetAddress[] internetAddress = new InternetAddress[addresses.length];
        for(int i=0; i<internetAddress.length; i++){
        	internetAddress[i] = new InternetAddress(addresses[i].trim());
        }
        message.setRecipients(Message.RecipientType.TO, internetAddress);
        //邮件的标题
        message.setSubject(subject);
        //邮件的文本内容
        message.setContent(content, "text/html;charset=UTF-8");
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
    
    
	private static String CHECK_URLS_KEY="checkurls";
	private static String SYSTEM_NAME_KEY="systemname";
	
    /*public static void main(String[] args) throws Exception {
    	Properties prop = new Properties();
        prop.load(EmailUtil.class.getResourceAsStream("/mail.properties"));
        String sysname = new String(prop.getProperty(SYSTEM_NAME_KEY).getBytes(),"UTF-8");
    	for(String url : prop.getProperty(CHECK_URLS_KEY).split(",")){
			try {
				
				EmailUtil.sendTextMail(prop, sysname+"重置密码说明", "验证链接："+url+" ");				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	//System.exit(0);
    }*/
    
}
