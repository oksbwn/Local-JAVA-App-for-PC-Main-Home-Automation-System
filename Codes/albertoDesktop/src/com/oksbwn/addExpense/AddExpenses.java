//Provides the GUI to add expenses to the Database.
package com.oksbwn.addExpense;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
public class AddExpenses {
public void expense(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		Date dat = new Date();
		String date=dateFormat.format(dat);
		AddExpensesToDatabase trans=new AddExpensesToDatabase();
		Object[] options = { "Save & Exit", "Save & Continue" };
		int x;
		String input=JOptionPane.showInputDialog("purchased:");
		if (!input.isEmpty())
		  {
	        String input1=JOptionPane.showInputDialog("Amount :");
	        String query = "insert into expense values(null,'"+input+"','"+input1+"','"+date+"')";
	        try {
		        trans.DbConnAndExe(query,"bikash");
	            } catch (Exception e) {}
	   	   }
		else
		  {
			JOptionPane.showMessageDialog(null, "Purchased item can't be blank.", "Error",JOptionPane.ERROR_MESSAGE);
		  }
		    x=JOptionPane.showOptionDialog(null, "Want to continue?", "Adding Expenses",0,0, null, options, options[0]);
		    if(x==1)
		      {
		    	AddExpenses addNewAgain=new AddExpenses();
		    	addNewAgain.expense();
		      }
		    if(x==0){}    
		}
}
