package com.oksbwn.Y2014.newProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;

public class showProduct {
	public static void main(String[] args) {
		new showProduct().showBaby();
		}
	public void showBaby()
	{int i=10;
		String item=(String) JOptionPane.showInputDialog(null, "Name of Product","ALBERTO Product Manager",JOptionPane.QUESTION_MESSAGE, null, null, "");
		try{
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikash","root","");
			   ResultSet res=con.prepareStatement("SELECT *  FROM `product` WHERE `Name` LIKE '%"+item+"%'").executeQuery();
			   while(res.next())
			   {
				    MainClassNewProduct p=new MainClassNewProduct();
					p.setContents(res.getString("Path"), res.getString("Name"), res.getString("From"), res.getString("Warranty"),res.getString("Date"),res.getString("Price"));
					p.addNewProducts(i);
					i=i+20;
			   }
			   con.close();
			   if(i==10)
			   {
				   new Voice("Sorry sir..i donot    have    information    about    this.");
				   new popMe("sorry..","Product Manager","note",5,125);
			   }
			   }catch(Exception e){new handleExceptions(e);
			   e.printStackTrace();	
			   }
	}
}
