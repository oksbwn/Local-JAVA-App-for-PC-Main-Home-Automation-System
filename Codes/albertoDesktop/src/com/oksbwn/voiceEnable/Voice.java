package com.oksbwn.voiceEnable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.sun.speech.freetts.VoiceManager;
public class Voice {
	public Voice(String thingToSay)
	{
		Runnable r = new MyThread(thingToSay);
		new Thread(r).start();
	}

	}
class MyThread implements Runnable {

	   private String thingToSay;

	public MyThread(String parameter) {
	       // store parameter for later user
		   this.thingToSay=parameter;
	   }

	   public void run() {
		   try{
				try{
				  String db="jdbc:mysql://localhost:3306/alberto";
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con=DriverManager.getConnection(db,"root","");
				  ResultSet result =con.prepareStatement("SELECT * FROM `sound`").executeQuery();
				   if(result.next()){
					if(result.getString(1).contains("ye"))
						{
					com.sun.speech.freetts.Voice voiceManager;
					voiceManager = VoiceManager.getInstance().getVoice("kevin16");
					voiceManager.allocate();
					voiceManager.speak(thingToSay);
						}}
						con.close();
					}catch(Exception e){}
					
				      }
			    catch(Exception e)
			        {
			    	JOptionPane.showMessageDialog(null,"JSAPI Error ?"+e);
			        }
				 finally
				 {
				 }
	   }
   }