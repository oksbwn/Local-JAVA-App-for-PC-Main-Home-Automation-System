/*
 * Author :Bikash Narayan Panda
 * Date: 09/Jul/2015
 * http://192.168.0.1/smart_home/API/desktopApp/addTweetsToDatabase.php
 *  http://192.168.0.1/smart_home/API/desktopApp/getIfTweetIsPresent.php
 * */
package com.oksbwn.social_networks;
import java.net.URLEncoder;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;

import com.oksbwn.popUp.PopMe;
import com.oksbwn.server_activity.SendData;
import com.oksbwn.voiceEnable.Voice;

public class AddTweetsToDatabase {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddTweetsToDatabase();
	}
public AddTweetsToDatabase()
   {
	try{
		GetTwittetAuthorized aut = new GetTwittetAuthorized();
		Twitter twitter=aut.auth();
		twitter.verifyCredentials();

		String text;
		int result=0;
		float id=0;
		List<Status> statuses = twitter.getHomeTimeline();
		int i=0;
		SendData sd=new SendData();
		for (Status status : statuses) 
			{
				text= status.getText();
				text=status.getUser().getScreenName()+":"+text;
				id=status.getId();
				result=Integer.parseInt(sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getIfTweetIsPresent.php",
						new String[]{"NOTE","ID"}, new String[]{text,""+id}));
		
				if(result==0)
				{
					text= URLEncoder.encode(text,"UTF-8");
					text= URLEncoder.encode(text,"UTF-8");
					sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/addTweetsToDatabase.php",
							new String[]{"NOTE","ID"}, new String[]{text,""+id});
					i++;
				}
		}
		new PopMe(i+"  New Tweets","Twitter","ok",false);
		new Voice("Sir you have "+i+" new Tweets");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
