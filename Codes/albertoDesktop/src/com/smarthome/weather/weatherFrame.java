package com.smarthome.weather;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;
import javafx.embed.swing.JFXPanel;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.audioChanger.changeConfiguration;

public class weatherFrame {
	
    Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	JFrame frame=new JFrame();
    Date dat = new Date();
	String loginTime="fgfg";
	String ipAddress="fgfg";
	
	String no="";
	JLabel lblThread = new JLabel();
    JLabel lblrs = new JLabel();
    JEditorPane tweet = new JEditorPane();
	JEditorPane schedules = new JEditorPane();
	JFXPanel fxPKillFrames= new JFXPanel();
	JFXPanel fxPSound = new JFXPanel();
	JFXPanel fxPShowAlert = new JFXPanel();
	JFXPanel fxPDebugEnable = new JFXPanel();
    
	public static void main(String[] args) throws Exception{
		new weatherFrame();
	}
	Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar  
	public weatherFrame() throws Exception 
	  {
      	frame.setUndecorated(true);
    	frame. setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),0));
        frame.setSize(220,gh.height- toolHeight.bottom);
    	frame.getContentPane().setLayout(null);
    	
        JLabel roomTempLabel = new JLabel("RT:");
        roomTempLabel.setBounds(10,140,20, 14);
        roomTempLabel.setForeground(Color.white);
		frame.getContentPane().add(roomTempLabel);
		
		final JLabel roomTempVal = new JLabel();
		roomTempVal.setBounds(40,140,50, 14);
		roomTempVal.setForeground(Color.white);
		frame.getContentPane().add(roomTempVal);

		
		JLabel roomHumidityLable = new JLabel("RH:");
		roomHumidityLable.setForeground(Color.white);
		roomHumidityLable.setBounds(110,140, 20, 14);
		frame.getContentPane().add(roomHumidityLable);
		
		final JLabel rhVal = new JLabel();
		rhVal.setBounds(150, 140,80, 14);
		rhVal.setForeground(Color.white);
		frame.getContentPane().add(rhVal);
		
		final JLabel kitTempLabel = new JLabel("KT:");
		kitTempLabel.setForeground(Color.white);
		kitTempLabel.setBounds(10,160, 20, 14);
		frame.getContentPane().add(kitTempLabel);
		
		final JLabel kitTempVal = new JLabel("");
		kitTempVal.setBounds(40, 160,50, 14);
		kitTempVal.setForeground(Color.white);
		frame.getContentPane().add(kitTempVal);
		
		final JLabel bathTempLabel = new JLabel("BT:");
		bathTempLabel.setForeground(Color.white);
		bathTempLabel.setBounds(110, 160, 40, 14);
		frame.getContentPane().add(bathTempLabel);
		
		final JLabel bathTempVal = new JLabel();
		bathTempVal.setBounds(160, 160,150, 14);
		bathTempVal.setForeground(Color.white);
		frame.getContentPane().add(bathTempVal);

		
		final JLabel audioLabel = new JLabel("Audio Status :");
		audioLabel.setForeground(Color.white);
		audioLabel.setBounds(10, 180,80, 14);
		frame.getContentPane().add(audioLabel);
		
		final JLabel audioVal = new JLabel();
		audioVal.setBounds(100, 180,150, 14);
		audioVal.setForeground(Color.white);
		frame.getContentPane().add(audioVal);
		
		
		frame.setLocation(gh.width-	frame.getWidth(),0);
		frame.setType(javax.swing.JFrame.Type.UTILITY);
		
		
		audioLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
					if (runnable != null)
					runnable.run();
					new changeConfiguration().changeit(frame.getLocation().x-150,frame.getLocation().y+200);
			}
		});
		
		
		frame.setVisible(true);	
		
//*********************************Other Codes*******************************************		/////////////////
		  new Thread(){  
	           @Override 
	            public void run() {  
		  	       ResultSet result;
		  	       ResultSet resultNew;
    			   Connection con=null;
		  	       try {  
			  	       Class.forName("com.mysql.jdbc.Driver");
			  		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
			  		   }catch(Exception e){}
	        	   while(true){
	        		   try {
							result= con.prepareStatement("SELECT * FROM `room_data`").executeQuery();
		        		       if(result.next())
					  	        {
		        		    	   roomTempVal.setText(result.getString("room_temperature")+" C");
		        		    	   rhVal.setText(result.getString("room_humidity")+"  %RH");
		        		    	   audioVal.setText(result.getString("audio_changer"));
					  	        }

		        		       resultNew= con.prepareStatement("SELECT * FROM `room_temperature` ORDER BY `room_temperature`.`Sl_No`  DESC").executeQuery();
			        		    if(resultNew.next())
						  	      {
			        		    	 kitTempVal.setText(resultNew.getString("Kit_Temp")+" C");
			        		    	 bathTempVal.setText(resultNew.getString("Bath_Temp")+" C");
						  	      }
	                	  Thread.sleep(1000);
	                	  }
	                  catch (Exception e)
	                  {
	                	  new handleExceptions(e);
	                 }
	        	   } 
	        	   };}.start();
		
    }
}
