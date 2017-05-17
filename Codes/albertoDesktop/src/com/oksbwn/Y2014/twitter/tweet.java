package com.oksbwn.Y2014.twitter;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.voiceEnable.Voice;

import twitter4j.Twitter;

public class tweet {
public tweet(String stat){
	try {
    	getAuthorized aut = new getAuthorized();
    	Twitter twitter=aut.auth();
        twitter.updateStatus(stat);
        new Voice("Sir now your twitter status is "+stat);
        } catch (Exception te) {new handleExceptions(te);}
}
}
