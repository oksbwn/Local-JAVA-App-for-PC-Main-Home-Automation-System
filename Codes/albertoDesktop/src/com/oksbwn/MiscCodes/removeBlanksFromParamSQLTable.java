/*By:Bikash Narayan Panda
 * 04/07/2014
 * This code removes the blamks from the daily parameter table
 * required to display good graph
 * */package com.oksbwn.MiscCodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oksbwn.ErrorHandling.handleExceptions;

public class removeBlanksFromParamSQLTable {

	public static void main(String[] args) {
new removeBlanksFromParamSQLTable().removeNulls();
	}
public void removeNulls(){
	DateFormat dateFormat = new SimpleDateFormat("dd");
	Date dat = new Date();
	final String date=dateFormat.format(dat);
	  try {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
		    if(date.contains("4"))
		    {
		    	 con.prepareStatement("UPDATE `param` SET `SaidGa`='null' WHERE `SaidGa` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `EnteredDinner`='null' WHERE `EnteredDinner` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `EnteredLunch`='null' WHERE `EnteredLunch` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `EnteredBreakfast`='null' WHERE `EnteredBreakfast` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `EneteredSnacks`='null' WHERE `EneteredSnacks` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `BeenToWork`='null' WHERE `BeenToWork` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `EneteredWhereRYou`='null' WHERE `EneteredWhereRYou` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `WhereRYou`='null' WHERE `WhereRYou` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `WhatLunch`='null' WHERE `WhatLunch` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `WhatSnacks`='null' WHERE `WhatSnacks` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `WhatDinner`='null' WHERE `WhatDinner` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `ByWhatCame`='null' WHERE `ByWhatCame` LIKE ''").executeUpdate();
		    	 con.prepareStatement("UPDATE `param` SET `ByWhatBack`='null' WHERE `ByWhatBack` LIKE ''").executeUpdate();
		    }
	  }catch (Exception e) {new handleExceptions(e);}
}
}
