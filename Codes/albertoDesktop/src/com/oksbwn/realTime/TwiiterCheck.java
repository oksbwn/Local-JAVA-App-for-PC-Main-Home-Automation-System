package com.oksbwn.realTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;

import com.oksbwn.Y2014.twitter.getAuthorized;

public class TwiiterCheck {
	public static void main(String[] arg){
		TwiiterCheck td=new TwiiterCheck();
		try {
			System.out.println(td.update());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public String update() throws Exception
   {
	DateFormat dateFormat = new SimpleDateFormat("HH:mm");
      getAuthorized aut = new getAuthorized();
     Twitter twitter=aut.auth();
     twitter.verifyCredentials();
     
	 String text = null;
     List<Status> statuses = twitter.getHomeTimeline();
     for (Status status : statuses) 
        {
  	     text= status.getText();
  	     //System.out.println(status.getUser().getScreenName()+":"+dateFormat.format(status.getCreatedAt())+"  "+text);
  	   text=status.getUser().getScreenName()+"/"+dateFormat.format(status.getCreatedAt())+" @ "+text;
  	     break;
  	 }  
     return text;
   }
}
