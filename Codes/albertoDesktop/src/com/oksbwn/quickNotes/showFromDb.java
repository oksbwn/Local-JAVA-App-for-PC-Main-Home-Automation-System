package com.oksbwn.quickNotes;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class showFromDb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         showFromDb sfD=new showFromDb();
       String item=JOptionPane.showInputDialog("Search for.");
         try {
			sfD.DbConnAndExe("SELECT * FROM `notes` WHERE `Note` LIKE '%"+item+"%'ORDER BY `notes`.`Sl_No`  DESC", "bikash");
		} catch (Exception e) {} 
	}
	public void DbConnAndExe(String QueryStatement,String DbaseName ) throws ClassNotFoundException, SQLException
	 { 
		{
			String db="jdbc:mysql://localhost:3306/"+DbaseName;
		   Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection(db,"root","");
		   PreparedStatement statement =con.prepareStatement(QueryStatement);	
		   ResultSet result =statement.executeQuery();
		   int xpos =0,ypos = 0;
			Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			//System.out.println(result.getFetchSize());
			contUserOptn cu=new contUserOptn();
			cu.contUserOptnDisp();
			int y=8;
		while (result.next())
			 {
			   new noteShowFrame(xpos,ypos,"  "+result.getString(3),"  "+result.getString(2)); 
				xpos=xpos+205;
				if(xpos>gh.width-200)
				{   xpos=0;
					ypos=ypos+130;
				}
				if(ypos>gh.height-125)
				{   
					//JOptionPane.showMessageDialog(null, "close These first");
					//con.
					y=cu.getVal();
					while(y>1)
					   {
						y=cu.getVal();
						//System.out.println(y=cu.getVal());
						}
					if(y==0){
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
		statement.close();}}

}
