package com.oksbwn.periodic_updates; 
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;

import com.oksbwn.popUp.PopMe;
import com.oksbwn.server_activity.SendData;
import com.oksbwn.voiceEnable.Voice;

public class CheckForNewEMailEveryOneHour extends Thread{  
	Properties properties = null;  
	private Session session = null;    
	private Store store = null;    
	private Folder inbox = null;    
	private String userName = "";// provide user name    
	private String password = "";// provide password   
	public CheckForNewEMailEveryOneHour(){
		start();
	}
	public void run() { 
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
		properties = new Properties();      
		properties.setProperty("mail.host", "imap.gmail.com");      
		properties.setProperty("mail.port", "995");      
		properties.setProperty("mail.transport.protocol", "imaps");     
		session = Session.getInstance(properties,new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(userName, password);}});   
		
		while(true){
			try{
				store = session.getStore("imaps");       
				store.connect();
				inbox = store.getFolder("INBOX");  
				inbox.open(Folder.READ_WRITE);        
				Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
			    if(messages.length !=0)
			    {

					new SendData().sendPost("http://192.168.0.1/smart_home/API/desktopApp/saveNoOfEmails.php",
							new String[]{"NO"}, new String[]{""+messages.length});
			    	new PopMe(messages.length+" New Mail", "ALBERTO", "ok", true);
			    	new Voice("Sir you have got "+messages.length+" new E-Mail.");
			    }
				Thread.sleep(1800*1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}


