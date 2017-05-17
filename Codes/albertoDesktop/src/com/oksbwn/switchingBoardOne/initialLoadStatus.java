/**
 * This codes gives the initila status of loads
 * IP: 192.168.0.9
 * API Path :192.168.0.100/API/controlModule/JAVA_API
 * Date : 10/Jul/2014
 * */
package com.oksbwn.switchingBoardOne;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class initialLoadStatus {
public String getInitial(){
	String res="error";
	try {
		HttpClient client = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://192.168.0.1/API/controlModule/JAVA_API/initial.php");
	    ResponseHandler<String> responseHandler = new BasicResponseHandler();
	    res =  client.execute(httppost,responseHandler);
	    
		}
		  catch(Exception e){e.printStackTrace();
		  return res;}
	return res;
}
}
