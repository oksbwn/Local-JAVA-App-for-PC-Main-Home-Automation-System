/**
 * Last frame that does all the processing
 * */
package com.oksbwn.foodTakenInDay;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.popUp.popMe;


public class lastframe {

    final JFrame jf = new JFrame("JIFrameDemo Main Window");
	public JFrame dispose(){
	return jf;
}
	public void frame(int xPos,int yPos){
    jf.setUndecorated(true);
    jf.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),1));
    jf.setSize(100,100);
    jf.setLocation(xPos, yPos);
    jf.setAlwaysOnTop(true);
    jf.setType(javax.swing.JFrame.Type.UTILITY);
    
	((JComponent)jf.getContentPane()).setBorder(    
	        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );

	final JLabel lblX1 = new JLabel();
	java.net.URL url = null;
	try {
		url = new File("C:/Alberto/Interface/foodIcons/finish.png").toURI().toURL();
	} catch (MalformedURLException e1) {
		try {
			url = new File("C:/Alberto/Interface/foodIcons/finish.jpg").toURI().toURL();
		} catch (MalformedURLException e2) {}
	}
	lblX1.setText("<html><img src="+url+" width=\"100\" height=\"110\"></img></html>");
	 
	lblX1.setLocation(0,0);
	lblX1.setForeground(new Color(255, 255,255));
	lblX1.setForeground(new Color(255, 255,255));
	final addFood fd=new addFood();
	lblX1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			String bef=fd.returnlast();
			//JOptionPane.showMessageDialog(null, bef+"selected");
  	      
			   try {
				   Class.forName("com.mysql.jdbc.Driver");
				   String what="";
				   String no="";
				   Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
				   ResultSet resFd= con1.prepareStatement("SELECT * FROM `foodtemp`").executeQuery();
           	       if (resFd.next())
           	         {
           	    	 what=resFd.getString(1);
           	    	 no=resFd.getString(2);
           	         }  	 	 	 
           	          String upd = "EneteredSnacks";
           	          if(what.contains("Sna")){upd="EneteredSnacks";}
           	          if(what.contains("Bre")){upd="EnteredBreakfast";}
           	          if(what.contains("Lun")){upd="EnteredLunch";}
           	          if(what.contains("Din")){upd="EnteredDinner";}
     	       
				   con1.prepareStatement("UPDATE `param` SET `"+upd+"` = 'yes',`"+what+"` = '"+bef+"' WHERE `param`.`Sl_No` ="+no).executeUpdate();
				   con1.prepareStatement("UPDATE `foodtemp` SET `tmp1` = ''").executeUpdate();
				   addFood.before="";
				   con1.prepareStatement("UPDATE `foodtemp` SET `tmp2` = ''").executeUpdate();
                  new popMe(what+" Added.", "Daily Stats", "ok",5,125); 
				   } catch (Exception e1) {new handleExceptions(e1);}
			   showDiffFoodsIcons xy=new showDiffFoodsIcons();
			xy.allDispose();
		}
	});
	lblX1.setSize(110,110);
	lblX1.setToolTipText("Completed");
	lblX1.setFocusable(false);
	jf.add(lblX1);
    jf.setVisible(true);
    }
}
