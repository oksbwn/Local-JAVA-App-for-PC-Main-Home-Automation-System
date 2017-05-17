//Provides the GUI to add expenses to the Database.
package com.oksbwn.financial_transactions;

import javax.swing.JOptionPane;

import com.oksbwn.server_activity.SendData;
public class AddExpenses {
	SendData sd=new SendData();
	public void expense(){
		AddExpenses addNewAgain=new AddExpenses();
		Object[] options = { "Save & Exit", "Save & Continue" };
		int x;
		String what=JOptionPane.showInputDialog("purchased:");
		if (!what.isEmpty())
		{
			String cost=JOptionPane.showInputDialog("Amount :");
			try {
				sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/saveMyExpenses.php",
						new String[]{"WHAT","COST"}, new String[]{what,cost});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Purchased item can't be blank.", "Error",JOptionPane.ERROR_MESSAGE);
		}
		x=JOptionPane.showOptionDialog(null, "Want to continue?", "Adding Expenses",0,0, null, options, options[0]);
		if(x==1)
		{
			addNewAgain.expense();
		}   
	}
}
