/**
 * Created so that audio output and input can be changed
 * Started on : 13/Nov/2014
 * */
package com.oksbwn.audioChanger;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

import com.oksbwn.ErrorHandling.handleExceptions;

public class changeConfiguration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new changeConfiguration().changeit(500,500);
	}
private JFrame frame3=new JFrame();
public void changeit(int x,int y)
{
	frame3.setBounds(x,y,150,120);
 	frame3.getContentPane().setLayout(null);
	frame3.setUndecorated(true);
    frame3.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),2));
    //frame3.getContentPane().setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),50));
	
    ((JComponent)frame3.getContentPane()).setBorder(    
		        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );
	frame3.setType(javax.swing.JFrame.Type.UTILITY);
	
	JCheckBox lapiWoofer=new JCheckBox("Lapi-Woo");
	lapiWoofer.setForeground(Color.white);
	lapiWoofer.setBounds(10,10,frame3.getWidth()-10,20);
	lapiWoofer.setOpaque(false);
	
	lapiWoofer.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			 final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				doTheResponse(1);
				frame3.dispose();
		}
	});
	frame3.getContentPane().add(lapiWoofer);
	
	JCheckBox lapiHead=new JCheckBox("Lapi-Head");
	lapiHead.setForeground(Color.white);
	lapiHead.setBounds(10,30,frame3.getWidth()-10,20);
	lapiHead.setOpaque(false);
	
	lapiHead.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			 final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				doTheResponse(2);
				frame3.dispose();
		}
	});
	frame3.getContentPane().add(lapiHead);
	
	JCheckBox deskWoo=new JCheckBox("Desk-Woo");
	deskWoo.setForeground(Color.white);
	deskWoo.setBounds(10,50,frame3.getWidth()-10,20);
	deskWoo.setOpaque(false);
	
	deskWoo.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			 final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				doTheResponse(3);
				frame3.dispose();
		}
	});
	frame3.getContentPane().add(deskWoo);
	
	JCheckBox deskHead=new JCheckBox("Desk-Head");
	deskHead.setForeground(Color.white);
	deskHead.setBounds(10,70,frame3.getWidth()-10,20);
	deskHead.setOpaque(false);
	
	deskHead.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			 final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				doTheResponse(4);
				frame3.dispose();
		}
	});
	frame3.getContentPane().add(deskHead);
	
	JCheckBox allMute=new JCheckBox("Mute");
	allMute.setForeground(Color.white);
	allMute.setBounds(10,90,frame3.getWidth()-10,20);
	allMute.setOpaque(false);
	
	allMute.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			 final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				doTheResponse(5);
				frame3.dispose();
		}
	});
	frame3.getContentPane().add(allMute);
	
    frame3.setVisible(true);
    
    //---------------------------------------
    
    new Thread(){  
        @Override 
         public void run() {  
     	   while(true){try {
             	  Thread.sleep(5000);
             	  frame3.dispose();
             	  
             	  }
               catch (Exception e)
               {
             	  new handleExceptions(e);
              }
     	   } 
     	   };}.start();
	
}
protected void doTheResponse(int val) {
	System.out.println(val);
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
	if(val==1)
		con.prepareStatement("UPDATE `customarduinoreplys` SET  `Command` =  'VOL',`Value` = '2' WHERE `Device` LIKE '%soundModule%'").executeUpdate();
	if(val==2)
		con.prepareStatement("UPDATE `customarduinoreplys` SET  `Command` =  'VOL',`Value` = '0' WHERE `Device` LIKE '%soundModule%'").executeUpdate();
	if(val==3)
		con.prepareStatement("UPDATE `customarduinoreplys` SET  `Command` =  'VOL',`Value` = '3' WHERE `Device` LIKE '%soundModule%'").executeUpdate();
	if(val==4)
		con.prepareStatement("UPDATE `customarduinoreplys` SET  `Command` =  'VOL',`Value` = '1' WHERE `Device` LIKE '%soundModule%'").executeUpdate();
	if(val==5)
		con.prepareStatement("UPDATE `customarduinoreplys` SET  `Command` =  'MUT' WHERE `Device` LIKE '%soundModule%'").executeUpdate();
	
}catch(Exception e){e.printStackTrace();}
}
}
