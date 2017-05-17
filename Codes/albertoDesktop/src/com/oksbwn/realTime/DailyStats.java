package com.oksbwn.realTime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.oksbwn.addExpense.AddExpenses;
import com.oksbwn.foodTakenInDay.showDiffFoodsIcons;
import com.oksbwn.popUp.popMe;
class FoodFrameThread extends Thread {
	FoodFrameThread() { start(); }
    public void run() {
    	showDiffFoodsIcons jiFr=new showDiffFoodsIcons();
    	jiFr.createFrames();
    	//stop();
    	}
}
public class DailyStats {
public void ckeckit() throws SQLException
 {
 //public static void main(String[] args) throws SQLException{
	String db="jdbc:mysql://localhost:3306/alberto";
	   try {
		   Class.forName("com.mysql.jdbc.Driver");
		   } catch (ClassNotFoundException e1) {}
	   DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
	   Date dat = new Date();
       final String date=dateFormat.format(dat); 
       DateFormat dateFormat1 = new SimpleDateFormat("HH");
		Date dat1 = new Date();
	   final String date1=dateFormat1.format(dat1); 
	   double time=Double.parseDouble(date1);
       Connection con1=DriverManager.getConnection(db,"root","");
       PreparedStatement statement1 =con1.prepareStatement("Select * from param where `date` like '"+date+"'");
       ResultSet result1 =statement1.executeQuery();
       if(result1.next())
        {
    	  String no=result1.getString(1);
    	  String exp=result1.getString(3);
    	  String lunch=result1.getString(4);
          String dinner=result1.getString(5);
          String bfast=result1.getString(6);
          String snacks=result1.getString(7);
          String work=result1.getString(8);
          String where=result1.getString(9);
          String byBack=result1.getString(17);
          int sNo=5;

//Breakfast
          if(time>8 && (!bfast.contains("yes")))
          {
           sNo=JOptionPane.showConfirmDialog(null,"Breakfast Completed ?","", JOptionPane.YES_NO_OPTION);
    		  if(sNo==0)
        	     {
    			  con1.prepareStatement("UPDATE `foodtemp` SET `tmp1` = 'WhatBreakfast',`tmp2` = '"+no+"'").executeUpdate();
    			 new FoodFrameThread();
    			  sNo=5;
        	     }
    	  }
          //lunch
          if(time>12 && (!lunch.contains("yes")))
             {
            sNo=JOptionPane.showConfirmDialog(null,"Lunch Completed ?","", JOptionPane.YES_NO_OPTION);
    		  if(sNo==0)
        	     {
    			  con1.prepareStatement("UPDATE `foodtemp` SET `tmp1` = 'WhatLunch',`tmp2` = '"+no+"'").executeUpdate();
    			  new FoodFrameThread();
    			  sNo=5;
        	     }
        	  }
          
          
     //Snacks
          if(time>17 && (!snacks.contains("yes")))
          { 
        sNo=JOptionPane.showConfirmDialog(null,"Snacks Completed ?","", JOptionPane.YES_NO_OPTION);
		  if(sNo==0)
 	     {
			  con1.prepareStatement("UPDATE `foodtemp` SET `tmp1` = 'WhatSnacks',`tmp2` = '"+no+"'").executeUpdate();
			  new FoodFrameThread();
			  sNo=5;
 	     }
          }          
          //Dinner
          if(time>21 && (!dinner.contains("yes")))
          { 
        sNo=JOptionPane.showConfirmDialog(null,"Dinner Completed ?","", JOptionPane.YES_NO_OPTION);
		  if(sNo==0)
 	     {
			  con1.prepareStatement("UPDATE `foodtemp` SET `tmp1` = 'WhatDinner',`tmp2` = '"+no+"'").executeUpdate();
			  new FoodFrameThread();
			  sNo=5;
 	     }
          }
          
          
          //Current location
          if(time>11 && (!where.contains("yes")))
          {
        	  String what= JOptionPane.showInputDialog("Where are you now ?","Berhampur");
        	  if(!what.isEmpty())
        	  {
        	     con1.prepareStatement("UPDATE `param` SET `EneteredWhereRYou` = 'yes',`WhereRYou` = '"+what+"' WHERE `param`.`Sl_No` ="+no).executeUpdate();
        	     new popMe("you are in."+what, "Daily Stats", "ok",5,125); }
          }
          //Add Expenses
          if(time>21 && (!exp.contains("yes")))
          {
           sNo=JOptionPane.showConfirmDialog(null,"Add Expenses ?","", JOptionPane.YES_NO_OPTION);
    		  if(sNo==0)
        	     {
    			  con1.prepareStatement("UPDATE `param` SET `SaidGa` = 'yes' WHERE `param`.`Sl_No` ="+no).executeUpdate();
    			 //new FoodFrameThread();
  				  AddExpenses recent=new AddExpenses();
  				  recent.expense();
    			  sNo=5;
        	     }
    	  }
          //To workplace
          if(time>12 &&(work.length()<2))
          {    
        	  String what= JOptionPane.showInputDialog("You are at workplace .","yes");
        	  String by=null;
        	  if(what.contains("yes"))
        	      {
        		   by= JOptionPane.showInputDialog("By what you came to workplace ?","bus");
        		   if(by.contains("bus") || by.contains("auto"))
        		   {
        			   byBusOrAutoFare bus=new byBusOrAutoFare();
        			   bus.expense();
        		   }
        	      }
        	  if(!what.isEmpty())
        	  {
        	     con1.prepareStatement("UPDATE `param` SET `BeenToWork` = '"+what+"',`ByWhatCame`='"+by+"' WHERE `param`.`Sl_No` ="+no).executeUpdate();
        	     new popMe("Now you are at workplace :"+what, "Daily Stats", "ok",5,125);
        	     }
        	  //System.out.println(work);
          }
          if(time>18 && (work.contains("yes")) && (byBack.length()<3))
          {  
        	  String by=null;
       	  //System.out.println("");
          by= JOptionPane.showInputDialog("By what you came ?","bus");
          if(by.contains("bus") || by.contains("auto"))
		   {
			   byBusOrAutoFare bus=new byBusOrAutoFare();
			   bus.expense();
		   }
           	  if(!by.isEmpty())
           	  {
           	     con1.prepareStatement("UPDATE `param` SET `ByWhatBack`='"+by+"' WHERE `param`.`Sl_No` ="+no).executeUpdate();
           	     new popMe("You came to room by "+by, "Daily Stats", "ok",5,125);
           	     }
             }
          
          //End
     }
con1.close();
  }
}
