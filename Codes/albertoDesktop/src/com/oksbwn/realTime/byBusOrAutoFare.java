package com.oksbwn.realTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import com.oksbwn.addExpense.AddExpensesToDatabase;
public class byBusOrAutoFare {
public void expense(){
	
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		Date dat = new Date();
		String date=dateFormat.format(dat);
		AddExpensesToDatabase trans=new AddExpensesToDatabase();
		//String input=JOptionPane.showInputDialog("purchased :");
	String input1=JOptionPane.showInputDialog("Amount :","Bus Fare..");
	String query = "insert into expense values(null,'"+"bus"+"','"+input1+"','"+date+"')";
	
	try {
		trans.DbConnAndExe(query,"bikash");
	} catch (Exception e) {}
		
}
}
