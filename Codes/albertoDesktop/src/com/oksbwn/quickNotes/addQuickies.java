package com.oksbwn.quickNotes;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.*;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.Y2014.twitter.tweet;
import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

public class addQuickies extends JFrame
  {
	private static FacebookClient facebookClient;
    final static JFrame frame2 = new JFrame();
	private static final long serialVersionUID = -6524124929738740020L;
public void addNote()
	//public static void main(String[] args)
    {   
	 Properties prop = new Properties();
	 InputStream input = null;
	  try{
		input = new FileInputStream("C:\\Alberto\\Config\\facebook.properties");
		prop.load(input);
		final String acessToken=prop.getProperty("accessToken");
		input.close();
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy hh:mm");
	Date dat = new Date();
	final String date=dateFormat.format(dat);    
	   
	  		     frame2.setUndecorated(true);
	  		     frame2.setResizable(false);
	  		     frame2.setBounds(100, 100, 301, 264);
	  		     frame2.getContentPane().setLayout(null);
	  		     frame2.getContentPane().setBackground(Color.WHITE);
	  			 frame2.addMouseListener(mouseListener);
	  			 frame2.addMouseMotionListener(mouseListener);
	  			 frame2.setUndecorated(true);
	  		     frame2.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),1));
	  		     frame2.getContentPane().setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),50));
	  			 frame2.setType(javax.swing.JFrame.Type.UTILITY);
			    ((JComponent)frame2.getContentPane()).setBorder(    
			        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );
			    final JLabel cloesButton = new JLabel("X");
				cloesButton.setForeground(Color.white);
				cloesButton.setToolTipText("Close");
				cloesButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						frame2.dispose();
						}
					@Override
					public void mouseEntered(MouseEvent arg0) {
						cloesButton.setForeground(Color.red);
						}
					@Override
					public void mouseExited(MouseEvent arg0) {
						cloesButton.setForeground(Color.white);
						}
					
				});
				cloesButton.setSize(15,15);
				cloesButton.setBounds(frame2.getWidth()-20, 2, 15,15);
				frame2.getContentPane().add(cloesButton);
	 
			 
			final JEditorPane textArea = new JEditorPane();
			textArea.setOpaque(false);
			textArea.setForeground(Color.white);
			textArea.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {	
				  frame2.repaint();
				}
			});
			textArea.setBounds(4, 11, 295, 184);
			frame2.getContentPane().add(textArea);	
			
				JButton closeButton = new JButton("Tweet");
				closeButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
					     new tweet(textArea.getText());
						}
					}
			);
				closeButton.setBounds(0, 238, 89, 23);
		  frame2.getContentPane().add(closeButton);
				
		  JButton FbPost = new JButton("Fbook");
		  FbPost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		    String noteTxt=textArea.getText();
		    if (!noteTxt.isEmpty())
				{ 
				  publishMessage(acessToken, noteTxt);
				  }
		     else {new Voice("Sir there is nothing to post.");
						}
					}
				});
			FbPost.setBounds(100, 238, 89, 23);
			frame2.getContentPane().add(FbPost);
				
			JButton addToDB = new JButton("Add");
			addToDB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			 {
		       String noteTxt=textArea.getText();
		       storeNotesToDatabase event=new storeNotesToDatabase();
			   if (!noteTxt.isEmpty())
				{ 
				  try {
						event.DbConnAndExe( "insert into notes values(null,'"+noteTxt+"','"+date+"','Note')","bikash");
						} catch (Exception e) {new handleExceptions(e);} 
					       frame2.dispose();
						}
				 else {
					new Voice("Sir there is nothing to save");
				     }
			}});
			addToDB.setBounds(208, 238, 89, 23);
		    frame2.getContentPane().add(addToDB);
		    frame2.setVisible(true);}catch(Exception e){new handleExceptions(e);}
    }
	final static MouseAdapter mouseListener = new MouseAdapter() {
	    int x, y;
	    @Override
	    public void mousePressed(MouseEvent e) {
	        if (e.getButton() == MouseEvent.BUTTON1) {
	            x = e.getX();
	            y = e.getY();
	        }
	    }

	    @Override
	    public void mouseDragged(MouseEvent e) {
	        if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
	        	frame2. setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
	        }
	    }
	};

static void  publishMessage(String accessToken,String message) {
		
	  facebookClient = new DefaultFacebookClient(accessToken);
	  FacebookType publishMessageResponse=null;
	  int p = 0;
	  try{
	     publishMessageResponse =facebookClient.publish("me/feed",FacebookType.class,Parameter.with("message",message));
	     p=1;
	     }catch(Exception e){new handleExceptions(e); }
	     if(p==1){
	     new Voice("Sir I have Posted The Message sucessfully.");
	     new popMe("Posted Sucessfully.  Id : "+publishMessageResponse,"Facebook","fb",5,125);
	  }}
  }
