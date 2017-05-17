//Connect to database to Insert Expenses.
package com.oksbwn.addExpense;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oksbwn.popUp.popMe;
public class AddExpensesToDatabase {
	public void DbConnAndExe(String QueryStatement,String DbaseName ) throws Exception
	 { 
		{
		   String db="jdbc:mysql://localhost:3306/"+DbaseName;
		   Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection(db,"root","");
		   Statement state=con.createStatement();
		    int x=state.executeUpdate(QueryStatement); 
		    if (x==1)
		       {
		        DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
				Date dat = new Date();
				String date=dateFormat.format(dat);
				String todaySpend = null;
				String monthSpend = null;
				ResultSet result =con.prepareStatement("SELECT sum( Cost )FROM `expense`WHERE `Date` LIKE '%"+date+"%'").executeQuery();
				if (result.next())
				   {
					 todaySpend= result.getString(1);
		           }
		        DateFormat dateFormat1 = new SimpleDateFormat("MMM/yyyy");
		        String date1=dateFormat1.format(dat);
		        ResultSet result1 =con.prepareStatement("SELECT sum( Cost )FROM `expense`WHERE `Date` LIKE '%"+date1+"%'").executeQuery();
			    if (result1.next())
				   {
				    monthSpend= result1.getString(1);
			       }
			   new popMe("Today expense : "+todaySpend+"<br>This month : "+monthSpend, "Account Updated ", "exp",4,140);
		       }
		      con.close();
		      }
		}
	}
