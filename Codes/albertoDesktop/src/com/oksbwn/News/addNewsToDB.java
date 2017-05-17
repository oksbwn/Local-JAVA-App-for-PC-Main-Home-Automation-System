package com.oksbwn.News;

import java.net.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import com.oksbwn.ErrorHandling.handleExceptions;
public class addNewsToDB {
  //public static void main(String[] args){
public void readNews(String url) throws Exception{	
		DateFormat dateFormat = new SimpleDateFormat("EEE");
	   DateFormat dateFormat2 = new SimpleDateFormat("dd/MMM/yyyy");
	   Date dat = new Date();
	     Class.forName("com.mysql.jdbc.Driver");
		 Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
		 DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
		 URL u = new URL(url); // your feed url 
		 Document doc = builder.parse(u.openStream()); 
		 NodeList nodes = doc.getElementsByTagName("item"); 
	       final String date=dateFormat.format(dat);
	       final String date2=dateFormat2.format(dat);
		   for(int i=0;i<nodes.getLength();i++) 
		    { 
		     Element element = (Element)nodes.item(i); 
              if(getElementValue(element,"pubDate").contains(date))
               {
        	    String Desct=getElementValue(element,"description");
		        String Titel=getElementValue(element,"title");
		        String Desc=Desct.substring(0,Desct.indexOf("<img"));
		        try{
		           con1.prepareStatement("INSERT INTO `news` (`Sl_No`, `Heading`, `Body`, `Date`) VALUES (NULL, '"+Titel+"', '"+Desc+"', '"+date2+"')").execute();
		           }catch(Exception e){	new handleExceptions(e);} 
		        }
            }
		    con1.close();
    } 
	
 private static String getCharacterDataFromElement(Element e) { 
		try { 
		Node child = e.getFirstChild(); 
		if(child instanceof CharacterData) { 
		CharacterData cd = (CharacterData) child; 
		return cd.getData(); 
		} 
		}catch(Exception ex) { 	new handleExceptions(ex);} 
		return ""; 
		} //private String getCharacterDataFromElement 
		protected float getFloat(String value) { 
		if(value != null && !value.equals("")) 
		return Float.parseFloat(value); 
		else 
		return 0; 
		} 
  protected static String getElementValue(Element parent,String label) { 
		return getCharacterDataFromElement((Element)parent.getElementsByTagName(label).item(0)); 
		}

}
