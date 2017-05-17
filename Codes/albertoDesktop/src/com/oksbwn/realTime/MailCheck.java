package com.oksbwn.realTime; 
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;

import com.oksbwn.ErrorHandling.handleExceptions;
public class MailCheck {  
	Properties properties = null;  
	private Session session = null;    
	private Store store = null;    
	private Folder inbox = null;    
	private String userName = "";// provide user name    
	private String password = "";// provide password       
	public int readMails() { 
		 Properties prop = new Properties();
			InputStream input = null;
			try{
				input = new FileInputStream("C:\\Alberto\\Config\\gmail.properties");
				prop.load(input);
				userName=prop.getProperty("id");
				password=prop.getProperty("pwd");
				input.close();
			  }
			catch(Exception e){new handleExceptions(e);}
		properties = new Properties();      
		properties.setProperty("mail.host", "imap.gmail.com");      
		properties.setProperty("mail.port", "995");      
		properties.setProperty("mail.transport.protocol", "imaps");     
		session = Session.getInstance(properties,new javax.mail.Authenticator() 
		                  {protected PasswordAuthentication getPasswordAuthentication()
		                                              {return new PasswordAuthentication(userName, password);}});       
		   try {store = session.getStore("imaps");       
	          	store.connect();
	          	inbox = store.getFolder("INBOX");  
		        inbox.open(Folder.READ_WRITE);        
		        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));; 
		        return messages.length ;
		        }catch (NoSuchProviderException e){
		        	//icon.displayMessage("Alberto","Running",TrayIcon.MessageType.INFO);
		        	       }
		         catch (MessagingException e) {}
		return 100;   
		    
	}}


