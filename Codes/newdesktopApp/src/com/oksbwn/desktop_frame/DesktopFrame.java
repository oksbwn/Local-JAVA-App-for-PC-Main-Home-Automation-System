/*New  Desktop frame containing new Icons and also shows weather Details
 * 13/Jul/2014
 * 
 * 
 * **/
package com.oksbwn.desktop_frame;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;

import com.oksbwn.osmc.MainGUI;
import com.oksbwn.popUp.PopMe;
import com.oksbwn.system_interactions.DiskSpaceDetail;
import com.oksbwn.system_interactions.IpAdress;
import com.oksbwn.system_interactions.OsLoginTime;
import com.oksbwn_control_loads.ShowLoads;


public class DesktopFrame {
	
    Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	JFrame frame=new JFrame();
    Date dat = new Date();
	String loginTime=""+((float)OsLoginTime.getSystemUptime()/3600000)+" Hours";
	String ipAddress=""+IpAdress.getIP();
	DiskSpaceDetail freeSpace=new DiskSpaceDetail();
	String space=freeSpace.FreeSpaceInDrive();
	
	String no="";
	JLabel lblThread = new JLabel("T :"+no);
    JLabel lblrs = new JLabel("");
    JEditorPane tweet = new JEditorPane();
	JEditorPane schedules = new JEditorPane();
	JFXPanel[] smallButton= new JFXPanel[20];
	int frameCounter;
	public static void main(String[] args) throws Exception{
		new DesktopFrame();
	}
	Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar  
	public DesktopFrame() throws Exception 
	  {
      	frame.setUndecorated(true);
    	frame. setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),0));
        frame.setSize(220,gh.height- toolHeight.bottom);
    	frame.getContentPane().setLayout(null);
    	
        JLabel lblLogin = new JLabel("LogIn :");
		lblLogin.setBounds(10, 11, 46, 14);
		lblLogin.setForeground(Color.white);
		frame.getContentPane().add(lblLogin);
		
		final JLabel lblNewLabel = new JLabel(loginTime);
		lblNewLabel.setBounds(66, 11,130, 14);
		lblNewLabel.setForeground(Color.white);
		frame.getContentPane().add(lblNewLabel);
		
		final JLabel lblNewLabel1 = new JLabel(ipAddress);
		lblNewLabel1.setBounds(66, 36,150, 14);
		lblNewLabel1.setForeground(Color.white);
		frame.getContentPane().add(lblNewLabel1);
		
		final JLabel lblIp = new JLabel("IP :");
		lblIp.setForeground(Color.white);
		lblIp.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblIp);
		
		final JLabel lblIp1 = new JLabel("C:\\");
		lblIp1.setForeground(Color.white);
		lblIp1.setBounds(10, 56, 46, 14);
		frame.getContentPane().add(lblIp1);
		
		final JLabel lblNewLabel11 = new JLabel(space);
		lblNewLabel11.setBounds(66, 56,150, 14);
		lblNewLabel11.setForeground(Color.white);
		frame.getContentPane().add(lblNewLabel11);
		
		lblThread.setBounds(145, 76,30,20);
		lblThread.setForeground(Color.white);
		frame.getContentPane().add(lblThread);
		
		lblrs.setForeground(Color.red);
		lblrs.setToolTipText("Value of Dollar in Rupees.");
		lblrs.setBounds(10,frame.getHeight()-447, 93,20);
		frame.getContentPane().add(lblrs);
		
		tweet.setOpaque(false);
		tweet.setText("");
		tweet.setForeground(Color.white);
		tweet.setBounds(0,frame.getHeight()-430, frame.getWidth(),150);
		frame.getContentPane().add(tweet);
		
		schedules.setOpaque(false);
		schedules.setText("");
		schedules.setForeground(Color.white);
		schedules.setBounds(0,frame.getHeight()-250, frame.getWidth(),250);
		frame.getContentPane().add(schedules);
		
		smallButton[0]=new JFXPanel();
		smallButton[0].setForeground(Color.red);
		smallButton[0].setOpaque(false);
		smallButton[0].setBounds(10,76,23,20);
		frame.getContentPane().add(smallButton[0]);
		
		smallButton[1]=new JFXPanel();
		smallButton[1].setForeground(Color.red);
		smallButton[1].setOpaque(false);
		smallButton[1].setBounds(38,76,23,20);
		frame.getContentPane().add(smallButton[1]);
		
		smallButton[2]=new JFXPanel();
		smallButton[2].setForeground(Color.red);
		smallButton[2].setOpaque(false);
		smallButton[2].setBounds(66,76,23,20);
		frame.getContentPane().add(smallButton[2]);
		
		smallButton[3]=new JFXPanel();
		smallButton[3].setForeground(Color.red);
		smallButton[3].setOpaque(false);
		smallButton[3].setBounds(94,76,23,20);
		frame.getContentPane().add(smallButton[3]);
		
		smallButton[4]=new JFXPanel();
		smallButton[4].setForeground(Color.red);
		smallButton[4].setOpaque(false);
		smallButton[4].setBounds(120,76,23,20);
		frame.getContentPane().add(smallButton[4]);
		
		smallButton[5]=new JFXPanel();
		smallButton[5].setForeground(Color.red);
		smallButton[5].setOpaque(false);
		smallButton[5].setBounds(180,76,23,20);
		frame.getContentPane().add(smallButton[5]);
		
		smallButton[6]=new JFXPanel();
		smallButton[6].setForeground(Color.red);
		smallButton[6].setOpaque(false);
		smallButton[6].setBounds(10,106,23,20);
		frame.getContentPane().add(smallButton[6]);
		
		smallButton[7]=new JFXPanel();
		smallButton[7].setForeground(Color.red);
		smallButton[7].setOpaque(false);
		smallButton[7].setBounds(38,106,23,20);
		frame.getContentPane().add(smallButton[7]);
		
		smallButton[8]=new JFXPanel();
		smallButton[8].setForeground(Color.red);
		smallButton[8].setOpaque(false);
		smallButton[8].setBounds(66,106,23,20);
		frame.getContentPane().add(smallButton[8]);
		
		smallButton[9]=new JFXPanel();
		smallButton[9].setForeground(Color.red);
		smallButton[9].setOpaque(false);
		smallButton[9].setBounds(94,106,23,20);
		frame.getContentPane().add(smallButton[9]);
		
		smallButton[10]=new JFXPanel();
		smallButton[10].setForeground(Color.red);
		smallButton[10].setOpaque(false);
		smallButton[10].setBounds(120,106,23,20);
		frame.getContentPane().add(smallButton[10]);
		
		smallButton[11]=new JFXPanel();
		smallButton[11].setForeground(Color.red);
		smallButton[11].setOpaque(false);
		smallButton[11].setBounds(148,106,23,20);
		frame.getContentPane().add(smallButton[11]);
		
		smallButton[12]=new JFXPanel();
		smallButton[12].setForeground(Color.red);
		smallButton[12].setOpaque(false);
		smallButton[12].setBounds(180,106,23,20);
		frame.getContentPane().add(smallButton[12]);
		
		smallButton[13]=new JFXPanel();
		smallButton[13].setForeground(Color.red);
		smallButton[13].setOpaque(false);
		smallButton[13].setBounds(10,136,23,20);
		frame.getContentPane().add(smallButton[13]);

		smallButton[14]=new JFXPanel();
		smallButton[14].setForeground(Color.red);
		smallButton[14].setOpaque(false);
		smallButton[14].setBounds(38,136,23,20);
		frame.getContentPane().add(smallButton[14]);

		smallButton[15]=new JFXPanel();
		smallButton[15].setForeground(Color.red);
		smallButton[15].setOpaque(false);
		smallButton[15].setBounds(66,136,23,20);
		frame.getContentPane().add(smallButton[15]);

		smallButton[16]=new JFXPanel();
		smallButton[16].setForeground(Color.red);
		smallButton[16].setOpaque(false);
		smallButton[16].setBounds(94,136,23,20);
		frame.getContentPane().add(smallButton[16]);

		smallButton[17]=new JFXPanel();
		smallButton[17].setForeground(Color.red);
		smallButton[17].setOpaque(false);
		smallButton[17].setBounds(120,136,23,20);
		frame.getContentPane().add(smallButton[17]);

		smallButton[18]=new JFXPanel();
		smallButton[18].setForeground(Color.red);
		smallButton[18].setOpaque(false);
		smallButton[18].setBounds(148,136,23,20);
		frame.getContentPane().add(smallButton[18]);

		smallButton[19]=new JFXPanel();
		smallButton[19].setForeground(Color.red);
		smallButton[19].setOpaque(false);
		smallButton[19].setBounds(180,136,23,20);
		frame.getContentPane().add(smallButton[19]);
		
		 Platform.setImplicitExit(false);
		 Platform.runLater(new Runnable(){
		        @Override
		        public void run() {
		            new miniButton().initFxLater(smallButton[0],"cam");
		            new miniButton().initFxLater(smallButton[6],"hdd");
		            new miniButton().initFxLater(smallButton[2],"debug");
		            new miniButton().initFxLater(smallButton[3],"kill");
		            new miniButton().initFxLater(smallButton[7],"movies");
		            new miniButton().initFxLater(smallButton[5],"alert");
		            new miniButton().initFxLater(smallButton[4],"news");
		            new miniButton().initFxLater(smallButton[8],"lan");
		            new miniButton().initFxLater(smallButton[9],"loadController");
		            new miniButton().initFxLater(smallButton[10],"refresh");
		            new miniButton().initFxLater(smallButton[11],"refresh");
		            new miniButton().initFxLater(smallButton[12],"refresh");
		            new miniButton().initFxLater(smallButton[13],"refresh");
		            new miniButton().initFxLater(smallButton[14],"refresh");
		            new miniButton().initFxLater(smallButton[15],"refresh");
		            new miniButton().initFxLater(smallButton[16],"refresh");
		            new miniButton().initFxLater(smallButton[17],"refresh");
		            new miniButton().initFxLater(smallButton[18],"refresh");
		            new miniButton().initFxLater(smallButton[19],"refresh");
		        }
		    });
		 
		frame.setLocation(gh.width-	frame.getWidth(),0);
		frame.setType(javax.swing.JFrame.Type.UTILITY);
		frame.setVisible(true);
		
		initMethods();
		new tweetUpdate ();
//*****************************************Click Handlers*******************************
		for( frameCounter=0;frameCounter<20;frameCounter++){
			smallButton[frameCounter].addMouseListener(new MouseAdapter() {
				int x=frameCounter;
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					smallButton[x].setBorder(BorderFactory.createMatteBorder( 0, 0, 0, 0, Color.black));
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					smallButton[x].setBorder(BorderFactory.createMatteBorder( 1, 1, 1, 1, Color.black));
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					mouseClickedSmallButtons(x);
				}
			});
		}
//*********************************Other Codes*******************************************		/////////////////
		  new Thread(){  
	           @Override 
	            public void run() {  
	        	   while(true){try {
	        		      no="T : "+java.lang.Thread.activeCount();
	        		      lblThread.setText(no);
	                	  Thread.sleep(1000); 
	                	  ipAddress=""+IpAdress.getIP();
	                	  loginTime=""+((float)OsLoginTime.getSystemUptime()/3600000)+" Hours";
	                	  lblNewLabel.setText(loginTime);
	                	  lblNewLabel1.setText(ipAddress);
                          space=freeSpace.FreeSpaceInDrive();
	                	  lblNewLabel11.setText(space);
                          schedules.setText(getSchedule());
	                	  frame.revalidate();
	                	  }
	                  catch (Exception e)
	                  {
	                	 // new handleExceptions(e);
	                 }
	        	   } 
	        	   };}.start();
		
    }
	
protected void mouseClickedSmallButtons(int x) {
		switch(x){
		case 0:
			new Thread(new Runnable() {
				@Override
				public void run() {try {
					new ShowLoads().show();
				} catch (Exception e) {
					e.printStackTrace();
				}	}
			}).start();
			break;
		case 1:
			new Thread(new Runnable() {
				@Override
				public void run() {try {
					new MainGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}	}
			}).start();
			break;
		default:
			new PopMe("Desktop Frame", "No function assigned.", "ok", false);
			break;
		}
	}

private void initMethods() 
	{
			String db="jdbc:mysql://localhost:3306/alberto";
			try{
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection(db,"root","");
			   ResultSet result =con.prepareStatement("SELECT * FROM `sound`").executeQuery();
			   if(result.next()){
			   if(result.getString(1).contains("no"))
					  { 
				   Platform.runLater(new Runnable(){
					        @Override
					        public void run() {
					            new miniButton().initFxLater(smallButton[1],"noSound");
					        }
					    });
					 
					  }
				if(result.getString(1).contains("ye"))
					{
					   Platform.runLater(new Runnable(){
					        @Override
					        public void run() {
					            new miniButton().initFxLater(smallButton[1],"Sound");
					        }
					    });
					}
				}
				con.close();
			}catch(Exception e){
				//new handleExceptions(e1);
				}
			
			
		  try {  
		  	       Class.forName("com.mysql.jdbc.Driver");ResultSet result;
		  		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
		  		   result= con.prepareStatement("SELECT * FROM `remindstat`").executeQuery();
		  	        if(result.next())
		  	        {
		  	          if(result.getString(1).contains("ye"))
		  	          {
		  	   		 Platform.runLater(new Runnable(){
		 		        @Override
		 		        public void run() {
		 		            new miniButton().initFxLater(smallButton[5],"Alert");
		 		        }
		 		    });
		  	          }
		  	         if(result.getString(1).contains("no"))
			          {
		  	        	 Platform.runLater(new Runnable(){
				 		 @Override
				 		 public void run() 
				 		 {
				 			 new miniButton().initFxLater(smallButton[5],"noAlert");
				 		  }
				 		    });
			          }
		  	        }
		  	       con.close();
		               } catch (Exception e) {
		            	  // new handleExceptions(e1);
		            	   } 
		  
		    Properties prop = new Properties();
		    OutputStream output = null;
			try {
				output = new FileOutputStream("C:\\Alberto\\Config\\debug.properties"); 
				prop.setProperty("stat","no");
				prop.store(output, null);
				output.close();  
					Platform.runLater(new Runnable(){
			        @Override
			        public void run() {
			            new miniButton().initFxLater(smallButton[2],"debug");
			        }
			    });
			} catch (Exception e) {}
	}	
 private String getSchedule(){
		String works="";
		try{
		   Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikash","root","");
		   ResultSet result ;DateFormat dateFormat ;String date;
		   dateFormat = new SimpleDateFormat("EEE");
		   date=dateFormat.format(dat);
           result=con.prepareStatement("SELECT * FROM `schedule` WHERE `Day` LIKE '"+date+"'").executeQuery();
		    while(result.next())
		     {
		    	works=works+" . "+result.getString(3)+" : "+result.getString(4)+"";
		     }
			con.close();}catch(Exception e){
				//new handleExceptions(e);
				}
		return works;
    }	
class tweetUpdate extends Thread {
	tweetUpdate() { start(); }
    public void run() {
       // TwiiterCheck td=new TwiiterCheck();
        Properties prop = new Properties();
		InputStream input = null;
        String value=null;
    	while(true)
    	{ 
    		try{
    			input = new FileInputStream("C:\\Alberto\\Config\\dollar.properties");
    			prop.load(input);
    			value=prop.getProperty("value");
    			input.close(); 
    			lblrs.setText("$:Rs "+value+"/-");
				//tweet.setText(td.update());
                frame.repaint();
                frame.revalidate();
                Thread.sleep(600000);
			   } catch (Exception e) {}
    	}
    }
}
class createNewsFrames extends Thread {
	createNewsFrames() { start(); }
    public void run() {
    	        //  shownewsFrames jif=new shownewsFrames();
	    		 // jif.createFrames();	
	   }
	}
public static double FreeSpaceInDrive(String drive)
{	
double space=0;
File file = new File(drive+":");
long totalSpace = file.getTotalSpace(); //total disk space in bytes.
 space=totalSpace /1024 /1024/1024;
    	return space;
    	}
}
