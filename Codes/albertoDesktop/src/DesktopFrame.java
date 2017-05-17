/*New  Desktop frame containing new Icons and also shows weather Details
 * 04/Jul/2014
 * 
 * 
 * **/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.News.shownewsFrames;
import com.oksbwn.popUp.popMe;
import com.oksbwn.realTime.TwiiterCheck;
import com.oksbwn.showOnlineDevices.onlineDevices;
import com.oksbwn.switchingBoardOne.graphicInterface;
import com.oksbwn.systeminteraction.CaptureScreen;
import com.oksbwn.systeminteraction.DiskSpaceDetail;
import com.oksbwn.systeminteraction.IpAdress;
import com.oksbwn.systeminteraction.OsLoginTime;
import com.oksbwn.systeminteraction.hardDiskpluggedTo;
import com.smarthome.weather.weatherFrame;

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
	JFXPanel fxPKillFrames= new JFXPanel();
	JFXPanel fxPSound = new JFXPanel();
	JFXPanel fxPShowAlert = new JFXPanel();
	JFXPanel fxPDebugEnable = new JFXPanel();
    
	public static void main(String[] args) throws Exception{
		new DesktopFrame();
	}
	Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar  
	public DesktopFrame() throws Exception 
	  {
		new weatherFrame();
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
		
		final JFXPanel fxPCamera = new JFXPanel();
		fxPCamera.setForeground(Color.red);
		fxPCamera.setOpaque(false);
		fxPCamera.setBounds(10,76,23,20);
		frame.getContentPane().add(fxPCamera);
		
		fxPSound.setForeground(Color.red);
		fxPSound.setOpaque(false);
		fxPSound.setBounds(38,76,23,20);
		frame.getContentPane().add(fxPSound);
		
		fxPDebugEnable.setForeground(Color.red);
		fxPDebugEnable.setOpaque(false);
		fxPDebugEnable.setBounds(66,76,23,20);
		frame.getContentPane().add(fxPDebugEnable);
		
		
		fxPKillFrames.setForeground(Color.red);
		fxPKillFrames.setOpaque(false);
		fxPKillFrames.setBounds(94,76,23,20);
		frame.getContentPane().add(fxPKillFrames);
		
		final JFXPanel fxPShowNews = new JFXPanel();
		fxPShowNews.setForeground(Color.red);
		fxPShowNews.setOpaque(false);
		fxPShowNews.setBounds(120,76,23,20);
		frame.getContentPane().add(fxPShowNews);
		
		fxPShowAlert.setForeground(Color.red);
		fxPShowAlert.setOpaque(false);
		fxPShowAlert.setBounds(180,76,23,20);
		frame.getContentPane().add(fxPShowAlert);
		
		final JFXPanel fxPAddHDDrive = new JFXPanel();
		fxPAddHDDrive.setForeground(Color.red);
		fxPAddHDDrive.setOpaque(false);
		fxPAddHDDrive.setBounds(10,106,23,20);
		frame.getContentPane().add(fxPAddHDDrive);
		
		final JFXPanel fxPMovieHubList = new JFXPanel();
		fxPMovieHubList.setForeground(Color.red);
		fxPMovieHubList.setOpaque(false);
		fxPMovieHubList.setBounds(38,106,23,20);
		frame.getContentPane().add(fxPMovieHubList);
		
		final JFXPanel fxPLanDevices= new JFXPanel();
		fxPLanDevices.setForeground(Color.red);
		fxPLanDevices.setOpaque(false);
		fxPLanDevices.setBounds(66,106,23,20);
		frame.getContentPane().add(fxPLanDevices);
		
		final JFXPanel fxPanelLoadController= new JFXPanel();
		fxPanelLoadController.setForeground(Color.red);
		fxPanelLoadController.setOpaque(false);
		fxPanelLoadController.setBounds(94,106,23,20);
		frame.getContentPane().add(fxPanelLoadController);
		
		final JFXPanel fxPanelRefreshAll= new JFXPanel();
		fxPanelRefreshAll.setForeground(Color.red);
		fxPanelRefreshAll.setOpaque(false);
		fxPanelRefreshAll.setBounds(120,106,23,20);
		frame.getContentPane().add(fxPanelRefreshAll);
		
		final JFXPanel alaramClockModule= new JFXPanel();
		alaramClockModule.setForeground(Color.red);
		alaramClockModule.setOpaque(false);
		alaramClockModule.setBounds(180,106,23,20);
		frame.getContentPane().add(alaramClockModule);
		
		 Platform.setImplicitExit(false);
		 Platform.runLater(new Runnable(){
		        @Override
		        public void run() {
		            new miniButton().initFxLater(fxPCamera,"cam");
		            new miniButton().initFxLater(fxPAddHDDrive,"hdd");
		            new miniButton().initFxLater(fxPDebugEnable,"debug");
		            new miniButton().initFxLater(fxPKillFrames,"kill");
		            new miniButton().initFxLater(fxPMovieHubList,"movies");
		            new miniButton().initFxLater(fxPShowAlert,"alert");
		            new miniButton().initFxLater(fxPShowNews,"news");
		            new miniButton().initFxLater(fxPLanDevices,"lan");
		            new miniButton().initFxLater(fxPanelLoadController,"loadController");
		            new miniButton().initFxLater(fxPanelRefreshAll,"refresh");
		            new miniButton().initFxLater(alaramClockModule,"refresh");
		        }
		    });
		 
		frame.setLocation(gh.width-	frame.getWidth(),0);
		frame.setType(javax.swing.JFrame.Type.UTILITY);
		frame.setVisible(true);
		
		initMethods();
		new tweetUpdate ();
//*****************************************Click Handlers*******************************
		
		alaramClockModule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				
			}
		});
		fxPanelRefreshAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				new popMe("Drive Plugged is :W", "Movie Manager", "ok",15, 125);
			}
		});		
		fxPanelLoadController.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				new graphicInterface().Main();	
			}
		});
		fxPLanDevices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				new onlineDevices().showDevices();
			}
		});
		
		fxPCamera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
    		    CaptureScreen cS=new CaptureScreen();
    		    cS.SnapTaker();}
		});
		
		fxPAddHDDrive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
			     if (runnable != null)
			         runnable.run();
			     hardDiskpluggedTo hd =new hardDiskpluggedTo();
			     hd.setDrivetoDB();
			}
		});
		
		fxPMovieHubList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
			    if (runnable != null)
			         runnable.run();
			}
		});
		
		fxPKillFrames.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
			     if (runnable != null)
			         runnable.run();
	    		 new killTheFrames();
			}
		});
		
		fxPShowAlert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
			     if (runnable != null)
			         runnable.run();
			     try {  
			  	       Class.forName("com.mysql.jdbc.Driver");ResultSet result;
			  		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
			  		   result= con.prepareStatement("SELECT * FROM `remindstat`").executeQuery();
			  	        if(result.next())
			  	        {
			  	          if(result.getString(1).contains("ye"))
			  	          {
			  	     	   con.prepareStatement("UPDATE `remindstat` SET `remind`='no'").executeUpdate();
			  	     	   Platform.runLater(new Runnable(){
						 		 @Override
						 		 public void run() 
						 		 {
						 			 new miniButton().initFxLater(fxPShowAlert,"noAlert");
						 		  }
						 		    });
			  	          }
			  	         if(result.getString(1).contains("no"))
				          {
				     	   con.prepareStatement("UPDATE `remindstat` SET `remind`='yes'").executeUpdate();
				     	  Platform.runLater(new Runnable(){
						 		 @Override
						 		 public void run() 
						 		 {
						 			 new miniButton().initFxLater(fxPShowAlert,"Alert");
						 		  }
						 		    });
				          }
			  	        }
			  	       con.close();
			               } catch (Exception e) {new handleExceptions(e);} 
			}
		});
		
		fxPShowNews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
			     if (runnable != null)
			         runnable.run();
			     new createNewsFrames();
			}
		});
		
		fxPDebugEnable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
			     if (runnable != null)
			         runnable.run();
			        Properties prop = new Properties();
			        Properties propOne = new Properties();
					InputStream input = null;
				    OutputStream output = null;
			        String value=null; 
			    		try{
			    			input = new FileInputStream("C:\\Alberto\\Config\\debug.properties");
			    			prop.load(input);
			    			value=prop.getProperty("stat");
			    			input.close();
                            output = new FileOutputStream("C:\\Alberto\\Config\\debug.properties");
			    			if(value.contains("ye"))
			    			{
			    				propOne.setProperty("stat","no");
								Platform.runLater(new Runnable(){
							        @Override
							        public void run() {
							            new miniButton().initFxLater(fxPDebugEnable,"debug");
							        }
							    });
			    			}
			    			else
			    			{
			    				propOne.setProperty("stat","yes");
                                Platform.runLater(new Runnable(){
                			        @Override
                			        public void run() {
                			            new miniButton().initFxLater(fxPDebugEnable,"debugging");
                			        }
                			    });
			    			}
			    			propOne.store(output, null);
							output.close();  
			    			
						   } catch (Exception e) {e.printStackTrace();}
			     
			}
		});
		
		fxPSound.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
			     if (runnable != null)
			         runnable.run();
			     try{
			     	String db="jdbc:mysql://localhost:3306/alberto";
			     	Class.forName("com.mysql.jdbc.Driver");
			     	Connection con=DriverManager.getConnection(db,"root","");
			     	ResultSet result =con.prepareStatement("SELECT * FROM `sound`").executeQuery();
			     	if(result.next())
			     		{
			     			if(result.getString(1).contains("no"))
			     				{
			     					con.prepareStatement("UPDATE `sound` SET `stat`='ye'").executeUpdate();
			     					 Platform.runLater(new Runnable(){
			 					        @Override
			 					        public void run() {
			 					            new miniButton().initFxLater(fxPSound,"Sound");
			 					        }
			 					    });
			     					
			     				}
			     		if(result.getString(1).contains("ye"))
			     				{
			     					con.prepareStatement("UPDATE `sound` SET `stat`='no'").executeUpdate();
			     					 Platform.runLater(new Runnable(){
			 					        @Override
			 					        public void run() {
			 					            new miniButton().initFxLater(fxPSound,"noSound");
			 					        }
			 					    });
			     				}
			     		}
			     		con.close();
			     	}catch(Exception e){new handleExceptions(e);	}
			}
		});
		
		
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
	                	  new handleExceptions(e);
	                 }
	        	   } 
	        	   };}.start();
		
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
					            new miniButton().initFxLater(fxPSound,"noSound");
					        }
					    });
					 
					  }
				if(result.getString(1).contains("ye"))
					{
					   Platform.runLater(new Runnable(){
					        @Override
					        public void run() {
					            new miniButton().initFxLater(fxPSound,"Sound");
					        }
					    });
					}
				}
				con.close();
			}catch(Exception e){new handleExceptions(e);}
			
			
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
		 		            new miniButton().initFxLater(fxPShowAlert,"Alert");
		 		        }
		 		    });
		  	          }
		  	         if(result.getString(1).contains("no"))
			          {
		  	        	 Platform.runLater(new Runnable(){
				 		 @Override
				 		 public void run() 
				 		 {
				 			 new miniButton().initFxLater(fxPShowAlert,"noAlert");
				 		  }
				 		    });
			          }
		  	        }
		  	       con.close();
		               } catch (Exception e) {new handleExceptions(e);} 
		  
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
			            new miniButton().initFxLater(fxPDebugEnable,"debug");
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
			con.close();}catch(Exception e){new handleExceptions(e);}
		return works;
    }	
class killTheFrames extends Thread {
    	killTheFrames() { start(); }
        public void run() {		
        	 try {   
        		Platform.runLater(new Runnable(){
 		        @Override
 		        public void run() {
 		            new miniButton().initFxLater(fxPKillFrames,"killing");
 		        }});
              
        	   fxPKillFrames.setEnabled(false);
      	       Class.forName("com.mysql.jdbc.Driver");
      		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
        	   con.prepareStatement("UPDATE `closeframe` SET `ya`='yes'").executeUpdate();
        	   Thread.sleep(15000);
        	   con.prepareStatement("UPDATE `closeframe` SET `ya`='no'").executeUpdate();
        	   Platform.runLater(new Runnable(){
    		        @Override
     		        public void run() {
     		            new miniButton().initFxLater(fxPKillFrames,"kill");
     		        }});
                  
        	   fxPKillFrames.setEnabled(true);
      	       con.close();
                   } catch (Exception e) {new handleExceptions(e);} 
        }
    }
class tweetUpdate extends Thread {
	tweetUpdate() { start(); }
    public void run() {
        TwiiterCheck td=new TwiiterCheck();
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
				tweet.setText(td.update());
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
    	          shownewsFrames jif=new shownewsFrames();
	    		  jif.createFrames();	
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
