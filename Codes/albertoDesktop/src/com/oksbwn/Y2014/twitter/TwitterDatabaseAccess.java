package com.oksbwn.Y2014.twitter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;

public class TwitterDatabaseAccess {
public void update() throws Exception
   {
	 Class.forName("com.mysql.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
     getAuthorized aut = new getAuthorized();
     Twitter twitter=aut.auth();
     twitter.verifyCredentials();
     
	 String text;
	 ResultSet result=null;
	 float id;
     List<Status> statuses = twitter.getHomeTimeline();
     int i=0;
     for (Status status : statuses) 
        {
  	     text= status.getText();
  	     text=status.getUser().getScreenName()+":"+text;
  	     id=status.getId();
  	   try{
  	   result=con.prepareStatement("SELECT * FROM `twitter` WHERE `Sl_No` LIKE '%"+id+"%'").executeQuery();
  	   }catch(Exception e1){new handleExceptions(e1);}
		   if(!result.next())
		     {
		    	text= URLEncoder.encode(text,"UTF-8");
		    	text= URLEncoder.encode(text,"UTF-8");
			    con.prepareStatement("INSERT INTO `twitter` (`No`,`Sl_No`, `Content`) VALUES (null,'"+id+"','"+text+"')").execute();
                 //  wait(4);
                i++;
		     }}
     new popMe(i+"New Tweets","Twitter","ok",3,125);
     new Voice("Sir you have "+i+"new Tweets");
     con.close();
     
   }
}
