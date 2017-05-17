package com.oksbwn.Fbook;
import java.net.*; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.xml.parsers.*;

import org.w3c.dom.*;

import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;

public class FacebookNotifications { 
private static FacebookNotifications instance = null; 
private FacebookNotifications() { 
} 
public static FacebookNotifications getInstance() { 
if(instance == null) 
instance = new FacebookNotifications(); 
return instance; 
} 
public void writeNews() { 
try { 
	int p=0;
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
URL u = new URL("https://www.facebook.com/feeds/notifications.php?id=100001386745987&viewer=100001386745987&key=AWg4S8IGhO2jo2gA&format=rss20"); // your feed url 
Document doc = builder.parse(u.openStream()); 
NodeList nodes = doc.getElementsByTagName("item"); 
new Voice("Sir you have "+nodes.getLength()+"Updates");
int W=0,H=0;
for(int i=0;i<nodes.getLength();i++) { 
Element element = (Element)nodes.item(i); 

String show="" + getElementValue(element,"title")+"";
//String show1="Ath: " +getElementValue(element,"dc:creator")+"</br>";
String show2="Date: " +getElementValue(element,"pubDate");
DateFormat dateFormat = new SimpleDateFormat("EEE");
Date dat = new Date();
final String date=dateFormat.format(dat);

   if (getElementValue(element,"pubDate").contains(date))
   {
	   p=p+1;
  // new popMe(show2,"Facebook", "fb",4,100);
   new mainNewsViewer( W,H,date,show2,show);
   W=W+210;
   if(W>800){W=0;H=H+210;}
		   // JOptionPane.showMessageDialog(null,show,"Facebook",JOptionPane.INFORMATION_MESSAGE); 
    W=W+1;
   }
  }//for 
    if (p==0)
      {
    	//JOptionPane.showMessageDialog(null,"Error","date", JOptionPane.ERROR_MESSAGE)
    	new Voice("Sir you have got no updates today..");
    	new popMe("No Updates Today", "Facebook", "fb",10,125);
	  }
}//try 
catch(Exception ex) { 
	JOptionPane.showMessageDialog(null,"Error","Network Error", JOptionPane.ERROR_MESSAGE); 
} 
} 
private String getCharacterDataFromElement(Element e) { 
try { 
Node child = e.getFirstChild(); 
if(child instanceof CharacterData) { 
CharacterData cd = (CharacterData) child; 
return cd.getData(); 
} 
}catch(Exception ex) { 

} 
return ""; 
} //private String getCharacterDataFromElement 
protected float getFloat(String value) { 
if(value != null && !value.equals("")) 
return Float.parseFloat(value); 
else 
return 0; 
} 
protected String getElementValue(Element parent,String label) { 
return getCharacterDataFromElement((Element)parent.getElementsByTagName(label).item(0)); 
} 
}