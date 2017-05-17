/*The Main Thrtead all starts Here
 * 
 * */


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.Properties;

import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;

import com.alberto.main.mainWindowFrame;
//import com.oksbwn.Arduino.SerialTest;
import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.MiscCodes.removeBlanksFromParamSQLTable;
import com.oksbwn.News.addNewsDBase;
import com.oksbwn.Y2014.twitter.TwitterDatabaseAccess;
import com.oksbwn.currencyRate.YahooCurrencyConverter;
import com.oksbwn.popUp.popMe;
import com.oksbwn.popUp.popMeMail;
import com.oksbwn.quickNotes.addQuickies;
import com.oksbwn.realTime.DailyStats;
import com.oksbwn.realTime.MailCheck;
import com.oksbwn.systeminteraction.Hibernate;
import com.oksbwn.systeminteraction.OsLoginTime;
import com.oksbwn.voiceEnable.Voice;

/*class Arduinothread extends Thread {
Arduinothread() { start(); }
public void run() {
	SerialTest main = new SerialTest();
	main.initialize();
	Thread t=new Thread() {
		public void run() {
			//the following line will keep this app alive for 1000 seconds,
//waiting for events to occur and responding to them (printing incoming messages to console).
		try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
	}
};
t.start();			
}
}***///Not using this now
//Thread that updates Movies and images when the application starts
class systemExitingThread extends Thread {
	systemExitingThread() { start(); }
    public void run() {
		 final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
			if (runnable != null)
			runnable.run();
    	int v=JOptionPane.showConfirmDialog(null, "Are you Sure ?", "Exit ALBERTO", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
    	if (v==0){
    	DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
    	Date dat = new Date();
    	final String date=dateFormat.format(dat);
    	  try {
    		  double x = OsLoginTime.getSystemUptime();
    		    Class.forName("com.mysql.jdbc.Driver");
    		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
    		    con.prepareStatement("INSERT INTO `alberto`.`logininform` (`Sl_No`, `Time`, `Date`) VALUES (NULL, '"+x/3600000+"', '"+date+"');").executeUpdate();
    		    System.exit(0);
    	  }catch (Exception e) {new handleExceptions(e);}	}
    	else if(v==1)
    	{
    		new popMe("Nice to get you back.", "Thank  you.", "ok",3,125);
    	}			
    }
}
class ReminderThread extends Thread {
	ReminderThread() { start(); }
    public void run() {
		 ReminderSearchFromDatabase cv=new ReminderSearchFromDatabase();
    	  try {
    	       new DesktopFrame();
		       Thread.sleep(50000);
		         while(true)
		         {
		        	  cv.alertReminders();
   	                  Thread.sleep(1200000);
		         } 
    	  }catch (Exception e) {new handleExceptions(e);}				
    }
}
class DollarValuethread extends Thread {
	DollarValuethread() { start(); }
    public void run() {
    	   YahooCurrencyConverter One=new YahooCurrencyConverter();
    	   float val;
    	   String value="62.5";
    	   Properties prop = new Properties();
    	   OutputStream output = null;
    	   try{
    		   while(true)
		      {
    			   Thread.sleep(200000);
    			   output = new FileOutputStream("C:\\Alberto\\Config\\dollar.properties");
    			   val= One.convert("USD","INR");
		           value=Float.toString(val);
			       prop.setProperty("value",value);
	    		   prop.store(output, null);
                   Thread.sleep(2000);
	    		   output.close();
		     	   Thread.sleep(14400000);
		     	   new removeBlanksFromParamSQLTable().removeNulls();
		      }
		}catch(Exception e){new handleExceptions(e);}
	}
}
class DailyRoutineThread extends Thread {
	DailyRoutineThread() { start(); }
    public void run() {
    	DailyStats One=new DailyStats();
		   while(true){
			   try{
		          Thread.sleep(160000);
		          One.ckeckit();
		          Thread.sleep(1200000);
	               }catch(Exception e){new handleExceptions(e);}
			   }
 }
}
class BTUserTest extends Thread {
	BTUserTest() { start(); }
    public void run() {
    	Hibernate One=new Hibernate();
    	try {
    		Thread.sleep(160000);
		     while(true)
		       {
		        One.doit();
		        Thread.sleep(240000);
	           }
    	    }catch(Exception e){new handleExceptions(e);}
	  }
}
class CheckTodayStatus extends Thread {
	CheckTodayStatus() { start(); }
     public void run() {
    	String db="jdbc:mysql://localhost:3306/alberto";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
            Date dat = new Date();
  			final String date=dateFormat.format(dat);    
  			Connection con=DriverManager.getConnection(db,"root","");
  			ResultSet result;
  			PreparedStatement statement;
  			int x;
             while(true)
    	       {
    		   Thread.sleep(30000);
    		   statement =con.prepareStatement("Select * from param where `date` like '"+date+"'");
  			   result =statement.executeQuery();
  			    if(!result.next())
  			      {
  			    	x=con.prepareStatement("insert into param values(null,'','','','','','','','','','','','','','"+date+"','','')").executeUpdate();
  				    if(x==0){}
  			      }
  			   else 
  			     {
  				   Thread.sleep(600000);
  			     }
    	       }
  		     }catch(Exception e){new handleExceptions(e);}
		}
     }
class NewThread extends Thread {
	   NewThread() { start(); }
       public void run() {
	      try {
	    	   Thread.sleep(10000);
			   MailCheck window = new MailCheck();
			   int x;
			   while(true)
			     {
				  x=window.readMails();
				    if(x!=0 && x!=100)
				    {
					 new popMeMail(x+" New Mail", "ALBERTO", "ok", 7, 100);
					 new Voice("Sir you have got "+x+"new E-Mail.");
				    }
				    Thread.sleep(900000);
				 }
			 } catch (InterruptedException e) {new handleExceptions(e);}
	   }
	}
//
class NewsThread extends Thread {
	   NewsThread() { start(); }
       public void run() {
    	   TwitterDatabaseAccess td=new TwitterDatabaseAccess();
    	   while(true){
	            try {
	    	        Thread.sleep(20000);
	    		    new addNewsDBase();
	    	        Thread.sleep(10000);
	    	    	try {
	    				td.update();
	    			} catch (Exception e) {new handleExceptions(e);
	    			}
			        Thread.sleep(3600000);
			        } catch (Exception e) {new handleExceptions(e);}
	            }
    	   }
       }
//
public class SysTray extends JFrame 
{   
private static final long serialVersionUID = 1L;
static TrayIcon icon = new TrayIcon(getImage(),"OKSBWN My Assistant",createPopupMenu());
public static void main(String[] args) throws InterruptedException, AWTException 
  {  
	
	new DollarValuethread();
	new ReminderThread();
	new NewThread();
	new NewsThread();
	new CheckTodayStatus();
	new DailyRoutineThread();
	new BTUserTest();
	//new Arduinothread();
	icon.addActionListener(new ActionListener() 
	      {        
		    public void actionPerformed(ActionEvent e) 
	           { 
		    	            new mainWindowFrame();
					        new popMe("Welcome", "ALBERTO", "ok", 7, 100);
		    	 }});  
		SystemTray.getSystemTray().add(icon);
		Thread.sleep(3000);
	icon.displayMessage("Alberto","Running",TrayIcon.MessageType.INFO);
	
  } 



private static Image getImage() throws HeadlessException 
  {      
	Icon defaultIcon = MetalIconFactory.getFileChooserHomeFolderIcon(); 
   Image img = new BufferedImage(defaultIcon.getIconWidth(),defaultIcon.getIconHeight(),BufferedImage.TYPE_4BYTE_ABGR);
	
	defaultIcon.paintIcon(new Panel(), img.getGraphics(), 0, 0);     
     return img;
  }  
private static PopupMenu createPopupMenu() throws HeadlessException 
  { 
  PopupMenu menu = new PopupMenu();      
  MenuItem exit = new MenuItem("Exit");  
  MenuItem note = new MenuItem("Note"); 
  MenuItem ImGal = new MenuItem("ImGal");
  exit.addActionListener(new ActionListener() 
  {         
   public void actionPerformed(ActionEvent e) 
     {    
	   new systemExitingThread();
       //System.exit(0);
      }});
  note.addActionListener(new ActionListener() 
      {         
	    public void actionPerformed(ActionEvent e) 
	      { 
	    	addQuickies add=new addQuickies();
	    	add.addNote();
	       }});
  ImGal.addActionListener(new ActionListener() 
  {         
    public void actionPerformed(ActionEvent e) 
      {
    	//mainGalleryMenu sl=new mainGalleryMenu();
    	//sl.LoginFunc();
       }});  

  
  menu.add(ImGal);
  menu.add(note);
 // menu.add(Exp);
  menu.add(exit);
	return menu;
	}
}