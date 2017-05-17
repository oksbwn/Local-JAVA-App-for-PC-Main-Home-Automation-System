/*
 * Author :Bikash Narayan Panda
 * Date: 09/Jul/2015
 * */
package com.oksbwn.social_networks;

import com.oksbwn.voiceEnable.Voice;

import twitter4j.Twitter;

public class PostTwitterTweet {
	public PostTwitterTweet(String stat){
		try {
	    		GetTwittetAuthorized aut = new GetTwittetAuthorized();
		    	Twitter twitter=aut.auth();
		        twitter.updateStatus(stat);
		        new Voice("Sir now your twitter status is "+stat);
	        } catch (Exception e) {
				new Voice("Sorry sir,  I was unable to post your twitter status.");
				e.printStackTrace();
	        }
	}
}
