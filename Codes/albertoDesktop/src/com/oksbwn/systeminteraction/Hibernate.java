
/**
 * 
 * 
 * This is for desktop version of my alberto which locks down the system when my android phone is not found in Wifi.
 * 
 * **/
package com.oksbwn.systeminteraction;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;

public class Hibernate
{
   JFrame frame2=new JFrame();
public static void main(String args[]) throws Exception
   {
	Hibernate hn=new Hibernate();
	hn.doit();
   }
 public void doit() throws IOException
	   {
	 int i=0;
	 InetAddress address = null;
	try {
		 byte[] ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)35};
	      address = InetAddress.getByAddress(ip);
       } 
	   catch (Exception e) {}
	while(!address.isReachable(3000))
	{
		i++;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		if(i==10)
			break;
	}
	if(i==10){i=0;
     //r.exec("shutdown -h");//s for shutdown r restart
	// Runtime rt = Runtime.getRuntime();
    // rt.exec("C:\\Windows\\System32\\rundll32.exe user32.dll,LockWorkStation");
		   
		   Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
			frame2.setBounds(0,0,scrSize.width, scrSize.height);
		  	frame2.getContentPane().setLayout(null);
		  	frame2.setAlwaysOnTop(true);
		  	frame2.setUndecorated(true);
		    frame2.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),1));
		    frame2.getContentPane().setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),50));
		  	((JComponent)frame2.getContentPane()).setBorder(    
		  		        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );
		  	frame2.setType(javax.swing.JFrame.Type.UTILITY);
		  	frame2.setAlwaysOnTop(true);
		  	
			  final JTextField textField = new JTextField();
			  textField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {	
					  frame2.repaint();
					}
				});
			  textField.setBounds(100, scrSize.height-100, 140, 30);
			  textField.setOpaque(false);
			  frame2.getContentPane().add(textField);
			  textField.setColumns(10);
			
			  final JPasswordField passwordField = new JPasswordField();
			  passwordField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {	
					  frame2.repaint();
					}
				});
			  frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			  passwordField.setBounds(100, scrSize.height-65,140,30);
			  passwordField.setOpaque(false);
			  frame2.getContentPane().add(passwordField);
		  	
				JButton btnLogIn = new JButton("login");
				btnLogIn.setBounds(123,scrSize.height-30,77,24);
			    frame2.getContentPane().add(btnLogIn);
			    	btnLogIn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) 
					{
						@SuppressWarnings("deprecation")
						String pass=passwordField.getText();
						logClicked(pass,textField.getText());
						passwordField.setText(null);
						textField.setText(null);
						//frame2.dispose();
					}
				});
			  
		      final JLabel Snap = new JLabel();
	          Snap.setForeground(Color.RED);
	          Snap.setBounds(scrSize.width/2-100, scrSize.height/2-100,200,200);
			  frame2.getContentPane().add(Snap);
			  
		  	frame2.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent arg0) {
					final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
					//default 
					 if (runnable != null)
					   runnable.run();
					 Snap.setText("OOOOps   You are Not Bikash");
				     }
		  	});
		  	frame2.setVisible(true);
     }
	   }
protected  void logClicked(String pass, String user) 
{
	String aPass="om";
	String aUser="oksbwn";
	if (aPass.compareTo(pass) == aUser.compareTo(user)==true)
	   {
				new Voice("Good to see you Sir.."); 
			    new popMe("Bikash Narayan Panda", "oksbwn", "me",4,125);
			    frame2.dispose();
		}
	else {
		   new popMe("Bad Guy....", "Not Authorized", "err",4,125);
	       new Voice("You are not authorized...");
	     }
 }
}
