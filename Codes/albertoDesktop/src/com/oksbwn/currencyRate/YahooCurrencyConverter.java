package com.oksbwn.currencyRate;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;

import com.oksbwn.popUp.popMe;

public class YahooCurrencyConverter
{ 
public float convert(String currencyFrom, String currencyTo) throws IOException
	{  
    HttpClient httpclient = new DefaultHttpClient();  
	HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?s=" + currencyFrom + currencyTo + "=X&f=l1&e=.csv"); 
	ResponseHandler<String> responseHandler = new BasicResponseHandler();   
	String responseBody = httpclient.execute(httpGet, responseHandler);    
	httpclient.getConnectionManager().shutdown();    
	return Float.parseFloat(responseBody);   
	}    
public void convertToRs()
{String to = null;
	String amnt=JOptionPane.showInputDialog(null, "Any to rupee..","$");
	//if ("$".charAt(0).(();
	if(amnt.substring(0,1).compareTo("$")==0)
	       to="USD";
	
	if(amnt.substring(0,1).compareTo("E")==0)
	       to="EUR";
	double ghh=1;
	try{
       ghh=Double.parseDouble(amnt.substring(1));
	}catch (Exception e){}  
	YahooCurrencyConverter df=	new YahooCurrencyConverter();
	try {
		float x=df.convert(to,"INR");
		new popMe( "Exchange rate is"+x,"From  "+to+" to INR", "exp", 6, 125);
		
		JOptionPane.showMessageDialog(null,x*ghh);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}


