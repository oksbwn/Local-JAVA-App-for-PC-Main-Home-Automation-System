package com.oksbwn.quickNotes;
import java.sql.*;

import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;
public class storeNotesToDatabase {
	public void DbConnAndExe(String QueryStatement,String DbaseName ) throws ClassNotFoundException, SQLException
	 { 
		{
			String db="jdbc:mysql://localhost:3306/"+DbaseName;
		   Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection(db,"root","");
		   Statement state=con.createStatement();
		  int x=state.executeUpdate(QueryStatement);  
		   if (x==1)
		   {
			new popMe("Note addded...","Sticky notes","note",10,125); 
			new Voice("Sir i have added the note.");
		   }
	 }
}
	}
