package com.oksbwn.periodic_updates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.oksbwn.financial_transactions.AddExpenses;
import com.oksbwn.food_items.ShowFoods;
import com.oksbwn.popUp.PopMe;
import com.oksbwn.server_activity.SendData;

public class CheckForDailyStatusEveryOneHour extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new CheckForDailyStatusEveryOneHour();
	}
	public CheckForDailyStatusEveryOneHour(){
		start();
	}
	public void run(){
		SendData sd=new SendData();
		DateFormat dateFormatInHour = new SimpleDateFormat("HH");
		int time;
		while(true){
			try{
				Thread.sleep(60000);
				time=Integer.parseInt(dateFormatInHour.format(new Date()));
				sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
						new String[]{"TYPE","PARA"}, new String[]{"Check","Date"});
				if(time>8){//Breakfast
					if(Integer.parseInt(sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
							new String[]{"TYPE","PARA"}, new String[]{"Check","breakfast"}))==0)
						{
							if(askForUserInput("Breakfast"))
							{
								new ShowFoods().getFoodTaken("breakfast");
							}
						}
				}
				if(time>12){//Lunch
					if(Integer.parseInt(sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
							new String[]{"TYPE","PARA"}, new String[]{"Check","lunch"}))==0)
						{
							if(askForUserInput("Lunch"))
							{
								new ShowFoods().getFoodTaken("lunch");
							}
						}			
				}
				if(time>17){//Knacks
					if(Integer.parseInt(sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
							new String[]{"TYPE","PARA"}, new String[]{"Check","snacks"}))==0)
						{
							if(askForUserInput("Snacks"))
							{
								new ShowFoods().getFoodTaken("snacks");
							}
						}			
				}
				if(time>21){//Dinner
					if(Integer.parseInt(sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
							new String[]{"TYPE","PARA"}, new String[]{"Check","dinner"}))==0)
						{
							if(askForUserInput("Dinner"))
							{
								new ShowFoods().getFoodTaken("dinner");
							}
						}		
				}
				
				
				//****************************************************************************************************//
				if(time>11){//Location
					if(Integer.parseInt(sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
							new String[]{"TYPE","PARA"}, new String[]{"Check","today_location"}))==0)
					{
						String what= JOptionPane.showInputDialog("Where are you now ?",sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getLastLocation.php",
								new String[]{}, new String[]{}));
			        	if(!what.isEmpty())
			        	  {
			        		sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
			        					new String[]{"TYPE","PARA","VAL"}, new String[]{"Update","today_location",what});
			        	  }	
					}
				}
				if(time>20){//Expense
					if(Integer.parseInt(sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
							new String[]{"TYPE","PARA"}, new String[]{"Check","today_expenses_added"}))==0)
					{
						//Add Expenses to Db
						if(askForUserInput("Expenses")){
							new AddExpenses().expense();
							System.out.println(sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
									new String[]{"TYPE","PARA","VAL"}, new String[]{"Update","today_expenses_added","Yes"}));
						}
					}
				}
				if(time>20){//WorkPlace
					if(Integer.parseInt(sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
							new String[]{"TYPE","PARA"}, new String[]{"Check","been_to_work"}))==0)
					{
						
						String what= JOptionPane.showInputDialog("You are at workplace .","yes");
			        	String by=null;
			        	if(what.contains("yes"))
			        	{
			        		by= JOptionPane.showInputDialog("By what you came to workplace ?","bus");
			        		if(by.contains("Bus") || by.contains("Auto"))
			        			{
			        				//Add to Expense
			        				String cost= JOptionPane.showInputDialog(by +" fare ?","");
			        				sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/saveMyExpenses.php",
			        						new String[]{"WHAT","COST"}, new String[]{by,cost});
			        			}
			        		sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
		        					new String[]{"TYPE","PARA","VAL"}, new String[]{"Update","how_went_to_work",by});
			        		by= JOptionPane.showInputDialog("By what you came from workplace ?","bus");
			        		if(by.contains("Bus") || by.contains("Auto"))
			        			{
			        				//Add to Expense
		        					String cost= JOptionPane.showInputDialog(by +" fare ?","");
			        				sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/saveMyExpenses.php",
			        						new String[]{"WHAT","COST"}, new String[]{by,cost});
		        				
			        			}
			        		sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
		        					new String[]{"TYPE","PARA","VAL"}, new String[]{"Update","how_back_from_work",by});
			        	}

			        	if(!what.isEmpty())
			        	{	
			        		sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
		        					new String[]{"TYPE","PARA","VAL"}, new String[]{"Update","been_to_work",what});
			        		new PopMe("You have been to work :"+what, "Daily Stats", "ok",false);
			        	}
					}
				}
				Thread.sleep(1000*60*30);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	private boolean askForUserInput(String string) {
		int response=JOptionPane.showConfirmDialog(null,"Do you want to add "+string,"", JOptionPane.YES_NO_OPTION);
		if(response==0)
	     {
			return true;
	     }
		return false;
	}
}
