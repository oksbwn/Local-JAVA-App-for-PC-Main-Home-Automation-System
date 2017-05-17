package com.oksbwn.setReminder;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class showReminderFromDb {

	public static void main(String[] args) {
         try {
             new showReminderFromDb();
		} catch (Exception e) {} 
	}
public showReminderFromDb() throws ClassNotFoundException, SQLException
	 { 
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikash","root","");
	   ResultSet result =con.prepareStatement("SELECT * FROM `reminder` ORDER BY `Sl_No`  DESC").executeQuery();
	   int xpos =0,ypos = 0;
	   Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	   contUserOptn cu=new contUserOptn();
	   cu.contUserOptnDisp();
	   int y=8;
		while (result.next())
			 {
			   new reminderShowFrame(xpos,ypos,"  "+result.getString(3),"  "+result.getString(2)); 
				xpos=xpos+205;
				if(xpos>gh.width-200)
				{   xpos=0;
					ypos=ypos+130;
				}
				if(ypos>gh.height-125)
				{ 
					y=cu.getVal();
					while(y>1)
					   {y=cu.getVal();}
					if(y==0)
					  {
						y=8;
						contUserOptn.x=8;
						break;
					  }
					if(y==1){
						y=8;
						contUserOptn.x=8;
					   xpos=0;
					   ypos=0;}
				}
			 } 
		con.close();
		}
	}