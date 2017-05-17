package com.oksbwn.Y2014.newProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;

public class addDataToDatabase {
public void add(String name, String from, String price, String warranty, String date,String path)
{
	try{
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikash","root","");
	  int i= con.prepareStatement("INSERT INTO `bikash`.`product` (`Sl_No`, `Name`, `From`, `Price`, `Date`, `Warranty`,`Path`) VALUES (NULL, '"+name+"', '"+from+"', '"+price+"', '"+date+"', '"+warranty+"','"+path+"');").executeUpdate();
	   con.close();
	   if(i!=0)
	   {
		   new popMe("product added to the database","Product Manager","note",5,125);
		   new Voice("Sir i have added the product...");
	   }
	   }catch(Exception e){new handleExceptions(e);
		   e.printStackTrace();	
	   }
}
}
