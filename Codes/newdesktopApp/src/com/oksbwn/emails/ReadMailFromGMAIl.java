package com.oksbwn.emails;
import java.io.FileInputStream;
import java.io.InputStream; 
import java.util.Properties;

import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm; 
import javax.swing.JOptionPane;

import com.oksbwn.popUp.PopMe;
import com.oksbwn.voiceEnable.Voice;
public class ReadMailFromGMAIl {  
Properties properties = null;  
private Session session = null;    
private Store store = null;    
private Folder inbox = null;    
private String userName = "";// provide user name    
private String password = "";// provide password       

public  ReadMailFromGMAIl(int type) {
	Properties prop = new Properties();
	InputStream input = null;
	try{
		input = new FileInputStream("C:\\Alberto\\Config\\gmail.properties");
		prop.load(input);
		userName=prop.getProperty("id");
		password=prop.getProperty("pwd");
		input.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	Object[] options = {"Mark Read","Open body","Delete"};
	properties = new Properties();      
	properties.setProperty("mail.host", "imap.gmail.com");      
	properties.setProperty("mail.port", "995");      
	properties.setProperty("mail.transport.protocol", "imaps");     
	session = Session.getInstance(properties,new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(userName, password);
		}});       
	try {
		store = session.getStore("imaps");       
		store.connect();
		inbox = store.getFolder("INBOX");  
		inbox.open(Folder.READ_WRITE);        
		Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN),false));
		if (messages.length==0 && type==0){
			new  Voice("Sir you have no E-mail..");
			new PopMe("No new mail","Gmail" , "email",false);
			return;
		}
		else if( type==0){
			new Voice("You have got "+messages.length+"E-mails.");
			new PopMe("No of mails : "+messages.length,"Gmail" , "email", false);
		}
		int n = 0;
		if(messages.length>0 && type==0)
			{ 
				n=JOptionPane.showConfirmDialog(null, "Show mails..", "Want to read !!",JOptionPane.YES_NO_OPTION);
			} 
		if (n==0 && messages.length>0){  
			for (int i = 0; i < messages.length; i++){
					Message message = messages[i]; 
					Address[] from = message.getFrom();
					String  mailData="<html><body width=''>Date: "+message.getSentDate()+"From:  "+from[0]+"</br>";
					String mailData1="<br><br>Subject:"+message.getSubject();
					int nO = JOptionPane.showOptionDialog(null,mailData+mailData1,"What Do You Want Me todo",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[1]);
					if(nO==0){ 
						inbox.setFlags(new Message[]{message},new Flags(Flags.Flag.SEEN),true);
					}
					if(nO==1){
						processMessageBody(message);  
					}
					if(nO==2){
						inbox.setFlags(new Message[]{message},new Flags(Flags.Flag.DELETED),true);
						new Voice("Sir i have Sucessfully deleted the mail.");
					}
				}
			}  
		inbox.close(true);            
		store.close();
		}catch (Exception e){
			e.printStackTrace();
			}
}  

public void processMessageBody(Message message) {         
	try {
		Object content = message.getContent();         
		if (content instanceof String) { 
				new mailWebView(""+content);
		} 
		else if (content instanceof Multipart)
		{
			Multipart multiPart = (Multipart) content;
			procesMultiPart(multiPart);   
		} 
		else if (content instanceof InputStream) 
		{
			@SuppressWarnings("resource")
			InputStream inStream = (InputStream) content;
			int ch;                 
			while ((ch = inStream.read()) != -1)
			{
				System.out.write(ch);  
			}}} 
		catch (Exception e) { 
			e.printStackTrace();
			}
	}      
public void procesMultiPart(Multipart content) {           
	try {             
		int multiPartCount = content.getCount();
		for (int i = 0; i < multiPartCount; i++)
			{
				BodyPart bodyPart = content.getBodyPart(i);
				Object o;                  
				o = bodyPart.getContent();              
				if (o instanceof String) {
					new mailWebView(""+o);;                
				} 
				else if (o instanceof Multipart) 
				{                     
					procesMultiPart((Multipart) o);
				}             
			}  
		}catch (Exception e) {
			e.printStackTrace();
		}
}	
}

