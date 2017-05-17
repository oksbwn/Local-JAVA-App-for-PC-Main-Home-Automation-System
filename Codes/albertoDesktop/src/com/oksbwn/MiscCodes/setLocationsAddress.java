package com.oksbwn.MiscCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class setLocationsAddress extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new setLocationsAddress();
	}
	setLocationsAddress(){
		start();
	}
	public void run(){

		
		URL url;
		try {
			url = new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng=19.2555396,84.7709171&key=AIzaSyAvutXJvzxLLHr5xoYtzSuKSNPpIAyaDz4");

	    HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

	    if(con!=null){
	    	try {		
					BufferedReader br = 
					new BufferedReader(new InputStreamReader(con.getInputStream()));

					String input="";
					String response="";
					
					while ((input = br.readLine()) != null){
						response=response+input;
					}
					//System.out.println(response);
				       JSONObject jsonObject = new JSONObject(response);
				        //JSONArray newJSON = jsonObject.getJSONArray("results");
				       // System.out.println(newJSON.getJSONArray(""));
				       System.out.println(jsonObject.getJSONArray("argv"));
					br.close();
	    		} catch (Exception e) {e.printStackTrace();}   		
	    		}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	    }
	}
}
