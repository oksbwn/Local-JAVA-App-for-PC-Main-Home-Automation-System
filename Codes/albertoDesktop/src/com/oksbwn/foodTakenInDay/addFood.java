package com.oksbwn.foodTakenInDay;
public class addFood { 
	public static String before="" ;
	public String returnlast(){
		return before;
	}
public void addnew(String food)
    {
	  before=food;
	  //System.out.println(before);
	}
}