package com.oksbwn.ErrorHandling;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.oksbwn.popUp.popMe;

public class handleExceptions {
	public handleExceptions(Exception e) {
		    Properties prop = new Properties();
			InputStream input = null;
			try{
				input = new FileInputStream("C:\\Alberto\\Config\\debug.properties");
				prop.load(input);
			    if(prop.getProperty("stat").contains("ye"))
			       {
		        	new showError(e);
			       }
			    input.close();
		    }catch(Exception e1){new popMe(""+e1,"Error","ok",2,125);}
		}
}
