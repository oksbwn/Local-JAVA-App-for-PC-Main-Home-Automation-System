/*
 * Author :Bikash Narayan Panda
 * Date: 09/Jul/2015
 * */
package com.oksbwn.social_networks;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.oksbwn.popUp.PopMe;
import com.oksbwn.voiceEnable.Voice;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

public class PostFacebookStatus {
	FacebookClient facebookClient;
	Properties prop = new Properties();
	InputStream input = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public PostFacebookStatus(String message) {
		try{
			input = new FileInputStream("C:\\Alberto\\Config\\facebook.properties");
			prop.load(input);
			String acessToken=prop.getProperty("accessToken");
			input.close();
			facebookClient = new DefaultFacebookClient(acessToken);
			FacebookType publishMessageResponse=null;
			int p = 0;
			publishMessageResponse =facebookClient.publish("me/feed",FacebookType.class,Parameter.with("message",message));
			p=1;
			if(p==1){
				new Voice("Sir I have Posted The Message sucessfully.");
				new PopMe("Posted Sucessfully.  Id : "+publishMessageResponse,"Facebook","fb",false);
			}
		}catch(Exception e){
			new Voice("Sorry sir,  I was unable to post your facebook status.");
			e.printStackTrace();
		}
	}
}
