package com.oksbwn.Y2014.twitter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.oksbwn.ErrorHandling.handleExceptions;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class getAuthorized {

	public  Twitter auth() {
		 String consumerKey = "";
	     String consumerSecret ="";
	     String accessToken = "";
	     String accessSecret = "";
 
	    Properties prop = new Properties();
		InputStream input = null;
		try{
			input = new FileInputStream("C:\\Alberto\\Config\\twitter.properties");
			prop.load(input);
			consumerKey=prop.getProperty("consumerKey");
			consumerSecret=prop.getProperty("consumerSecret");
			accessToken=prop.getProperty("accessToken");
			accessSecret=prop.getProperty("accessSecret");
			input.close();
		  }
		catch(Exception e){new handleExceptions(e);}
		
		  ConfigurationBuilder cb = new ConfigurationBuilder();
	       cb.setDebugEnabled(true)
	           .setOAuthConsumerKey(consumerKey)
	           .setOAuthConsumerSecret(consumerSecret)
	           .setOAuthAccessToken(accessToken)
	           .setOAuthAccessTokenSecret(accessSecret);
	       Twitter twitter = new TwitterFactory(cb.build()).getInstance(); 
return twitter;
	}

}
