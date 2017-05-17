package com.oksbwn.dailyRoutines;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;
public class showSchedulesFromDb {

	public static void main(String[] args) {
         try {
             new showSchedulesFromDb();
		} catch (Exception e) {} 
	}
public showSchedulesFromDb()
	 { 
	try{
		int s=0;
	 String day=JOptionPane.showInputDialog("Enter the Day.");
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikash","root","");
	   ResultSet result =con.prepareStatement("SELECT * FROM `schedule` WHERE  `Day` LIKE '%"+day+"%' ORDER BY `Sl_No`  DESC").executeQuery();
	   int xpos =0,ypos = 0;
	   Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		while (result.next())
			 {
			s=1;
			   new scheduleShowFrame(xpos,ypos,result.getString(2)+""+result.getString(3),""+result.getString(4),result.getString(1)); 
				xpos=xpos+205;
				if(xpos>gh.width-200)
				{   xpos=0;
					ypos=ypos+130;
				}
				if(ypos>gh.height-125)
				{ 
				break;
				}
			 } 
		con.close();
		if(s==0){
			new Voice("Sorry sir i did not find any Schedule of this day.");
			new popMe("No schedule for "+day+"day found","Scheduler","note",5,125);}
	}catch(Exception e){new handleExceptions(e);}
	
		}
	}