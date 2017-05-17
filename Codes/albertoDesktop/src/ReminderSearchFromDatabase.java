//Searches the database and shows the reminders
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;
public class ReminderSearchFromDatabase {
	public static void main(String[] args)
	{
		ReminderSearchFromDatabase rt=new ReminderSearchFromDatabase();
		try{rt.alertReminders();}catch(Exception e){System.out.println();}
	}
	public void alertReminders() throws Exception
	 {  Date dat = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		String date=dateFormat.format(dat);
		String Say="Sir ";int t=0;
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikash","root","");
	   Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
	   ResultSet result = null;
	   result= con1.prepareStatement("SELECT * FROM `remindstat`").executeQuery();
	   if(result.next())
	   if(result.getString(1).contains("ye"))
	   {
	   result=con.prepareStatement("SELECT `Name` FROM `birthday` WHERE `Date` LIKE '"+date+"'").executeQuery();
	   while(result.next())
		 {
		   Say=Say+"Today is "+result.getString(1)+"'s Birthday......";
		   t=1;
		 }
	   if(t==1)
	      Say=Say+"and Sir ";
	   else 
		   Say=Say+"";
	   result=con.prepareStatement("SELECT `Work` FROM `reminder` WHERE `Date` LIKE '"+date+"'").executeQuery();
	   while(result.next())
		{
		   Say=Say+"you have a Reminder about "+result.getString(1)+".";
		   t=2;
		}
	     if(t!=0){
			new Voice(Say);
			new popMe(Say, "Reminder Alert", "ok", 7, 200);
			}
	 }
			
	   con.close();con1.close();
	 }
}
