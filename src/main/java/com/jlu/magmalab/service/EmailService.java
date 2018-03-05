package com.jlu.magmalab.service;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 
 * ClassName: EmailService <br/>
 * Function: 发送邮件. <br/>
 * date: 2017年9月30日 上午9:17:25 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class EmailService {

	private String account;
	private String password;
	private String smtp;
	private String desAccount;
	private boolean debug;
	private String fromUser;
	private String toUser;
	private String subject;
	private String content;
	private File file;
	private String attchName;
	private Map<String,String> ssl;
	private static final String CONTENT_ENCODE="UTF-8";
	
	public void send() {
		try {
			// 1. 创建参数配置, 用于连接邮件服务器的参数配置
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.host", this.smtp);
			props.setProperty("mail.smtp.auth", "true");

			// 2. 根据配置创建会话对象, 用于和邮件服务器交互
			Session session = Session.getDefaultInstance(props);
			session.setDebug(this.debug); 
			
			// 3.是否SSL连接
			if(ssl!=null) {
				props.setProperty("mail.smtp.port", ssl.get("port"));
				props.setProperty("mail.smtp.socketFactory.class", ssl.get("socketFactory"));
				props.setProperty("mail.smtp.socketFactory.fallback",ssl.get("fallback"));
				props.setProperty("mail.smtp.socketFactory.port", ssl.get("port"));
			}

			// 3. 创建一封邮件
			MimeMessage message = createMimeMessage(session, this.account, this.desAccount);

			// 4. 根据 Session 获取邮件传输对象
			Transport transport = session.getTransport();

			// 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
			transport.connect(this.account, this.password);

			// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人,
			transport.sendMessage(message, message.getAllRecipients());

			// 7. 关闭连接
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * createMimeMessage:(创建邮件主题内容). <br/> 
	 * 
	 * @author liboqiang
	 * @param session
	 * @param sendMail
	 * @param receiveMail
	 * @return
	 * @throws Exception 
	 * @since JDK 1.6
	 */
	private MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
		// 1. 创建一封邮件
		MimeMessage message = new MimeMessage(session);

		// 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
		message.setFrom(new InternetAddress(sendMail, getFromUser(), CONTENT_ENCODE));

		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail,getToUser(),CONTENT_ENCODE));

		// 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
		message.setSubject(getSubject(), CONTENT_ENCODE);

		// 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
		MimeMultipart mp=new MimeMultipart("mixed");
		
		//添加附件
		MimeBodyPart attch=new MimeBodyPart();
		mp.addBodyPart(attch);
		
		//添加数据
		DataSource data=new FileDataSource(file);
		attch.setDataHandler(new DataHandler(data));
		attch.setFileName(MimeUtility.encodeText(attchName));
		
		message.setContent(mp,CONTENT_ENCODE);

		// 6. 设置发件时间
		message.setSentDate(new Date());

		// 7. 保存设置
		message.saveChanges();

		return message;
	}
	
	/** 
	 * account. 
	 * 
	 * @param   account    the account to set 
	 * @since   JDK 1.6 
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/** 
	 * password. 
	 * 
	 * @param   password    the password to set 
	 * @since   JDK 1.6 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** 
	 * smtp. 
	 * 
	 * @param   smtp    the smtp to set 
	 * @since   JDK 1.6 
	 */
	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	/** 
	 * desAccount. 
	 * 
	 * @param   desAccount    the desAccount to set 
	 * @since   JDK 1.6 
	 */
	public void setDesAccount(String desAccount) {
		this.desAccount = desAccount;
	}

	/** 
	 * debug. 
	 * 
	 * @param   debug    the debug to set 
	 * @since   JDK 1.6 
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/** 
	 * ssl. 
	 * 
	 * @param   ssl    the ssl to set 
	 * @since   JDK 1.6 
	 */
	public void setSsl(Map<String, String> ssl) {
		this.ssl = ssl;
	}

	/** 
	* fromUser. 
	* 
	* @return  the fromUser 
	* @since   JDK 1.6 
	*/
	public String getFromUser() {
		return fromUser;
	}

	/** 
	 * fromUser. 
	 * 
	 * @param   fromUser    the fromUser to set 
	 * @since   JDK 1.6 
	 */
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	/** 
	* toUser. 
	* 
	* @return  the toUser 
	* @since   JDK 1.6 
	*/
	public String getToUser() {
		return toUser;
	}

	/** 
	 * toUser. 
	 * 
	 * @param   toUser    the toUser to set 
	 * @since   JDK 1.6 
	 */
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	/** 
	* subject. 
	* 
	* @return  the subject 
	* @since   JDK 1.6 
	*/
	public String getSubject() {
		return subject;
	}

	/** 
	 * subject. 
	 * 
	 * @param   subject    the subject to set 
	 * @since   JDK 1.6 
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/** 
	* content. 
	* 
	* @return  the content 
	* @since   JDK 1.6 
	*/
	public String getContent() {
		return content;
	}

	/** 
	 * content. 
	 * 
	 * @param   content    the content to set 
	 * @since   JDK 1.6 
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/** 
	* file. 
	* 
	* @return  the file 
	* @since   JDK 1.6 
	*/
	public File getFile() {
		return file;
	}

	/** 
	 * file. 
	 * 
	 * @param   file    the file to set 
	 * @since   JDK 1.6 
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/** 
	* attchName. 
	* 
	* @return  the attchName 
	* @since   JDK 1.6 
	*/
	public String getAttchName() {
		return attchName;
	}

	/** 
	 * attchName. 
	 * 
	 * @param   attchName    the attchName to set 
	 * @since   JDK 1.6 
	 */
	public void setAttchName(String attchName) {
		this.attchName = attchName;
	}
}
