package com.oksbwn.cricket;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.oksbwn.ErrorHandling.handleExceptions;

public class fromEspn {
public String getScores()
  {
	String ting="";
	  try 
	    { 
	    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
	    URL u = new URL("http://static.espncricinfo.com/rss/livescores.xml"); // your feed url 
	    Document doc = builder.parse(u.openStream()); 
	    NodeList nodes = doc.getElementsByTagName("item");
	    for(int i=0;i<nodes.getLength();i++) 
	     { 
	      Element element = (Element)nodes.item(i); 
	      String nwTitel=getElementValue(element,"title");
	      boolean res=nwTitel.contains("India");
	      if(res)
	        {
	    	  ting=ting+ getElementValue(element,"description");
	    	  }}
	     }//for 
	     catch(Exception ex){new handleExceptions(ex); } 
	   return ting;
  }


private static String getCharacterDataFromElement(Element e) 
 { 
  try { 
       Node child = e.getFirstChild(); 
       if(child instanceof CharacterData) 
        { 
         CharacterData cd = (CharacterData) child; 
         return cd.getData(); 
        } 
       }
  catch(Exception ex)
      {new handleExceptions(ex);  } 
  return ""; 
  } //private String getCharacterDataFromElement 
protected float getFloat(String value)
 { 
   if(value != null && !value.equals("")) 
      return Float.parseFloat(value); 
   else 
      return 0; 
 }  
protected static String getElementValue(Element parent,String label) 
 { 
  return getCharacterDataFromElement((Element)parent.getElementsByTagName(label).item(0));  
} 
}
