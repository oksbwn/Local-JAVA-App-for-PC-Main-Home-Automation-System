/*
 * Author :Bikash Narayan Panda
 * Date: 09/Jul/2015
 * API to add note to database :	http://192.168.0.1/smart_home/API/desktopApp/addNoteToDatabase.php 
 * */
package com.oksbwn.add_quickies;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.oksbwn.server_activity.SendData;
import com.oksbwn.social_networks.PostFacebookStatus;
import com.oksbwn.social_networks.PostTwitterTweet;
import com.oksbwn.voiceEnable.Voice;

public class AddNote {
    static JFrame frame2 = new JFrame();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddNote();
	}
	public AddNote(){
		try{
			frame2.setUndecorated(true);
			frame2.setResizable(false);
			frame2.setBounds(100, 100, 310, 264);
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
			cloesButton.setForeground(Color.green);
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
					cloesButton.setForeground(Color.green);
				}});
			cloesButton.setSize(15,15);
			cloesButton.setBounds(frame2.getWidth()-15, 2, 15,15);
			frame2.getContentPane().add(cloesButton);


			final JEditorPane textArea = new JEditorPane();
			textArea.setOpaque(false);
			textArea.setForeground(Color.white);
			textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {	
				frame2.repaint();
			}});
			textArea.setBounds(4, 11, 295, 184);
			frame2.getContentPane().add(textArea);	

			JButton closeButton = new JButton("Tweet");
			closeButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					new PostTwitterTweet(textArea.getText());
			}});
			closeButton.setBounds(10, 238, 90, 23);
			frame2.getContentPane().add(closeButton);

			JButton FbPost = new JButton("Fbook");
			FbPost.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String noteTxt=textArea.getText();
					if (!noteTxt.isEmpty())
					{ 
						new PostFacebookStatus(noteTxt);
					}
					else {
						new Voice("Sir there is nothing to post.");
					}
				}
			});
			FbPost.setBounds(110, 238, 90, 23);
			frame2.getContentPane().add(FbPost);

			JButton addToDB = new JButton("Add");
			addToDB.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0)
				{
					String noteTxt=textArea.getText();
					if (!noteTxt.isEmpty())
					{ 
						try {
							new SendData().sendPost("http://192.168.0.1/smart_home/API/desktopApp/addNoteToDatabase.php",
									new String[]{"NOTE"}, new String[]{textArea.getText()});
							new Voice("Sir I have added the note.");
						} catch (Exception e) {
								e.printStackTrace();
							} 
					frame2.dispose();
					}
					else {
						new Voice("Sir there is nothing to save");
					}
				}
			});
			addToDB.setBounds(210, 238, 90, 23);
			frame2.getContentPane().add(addToDB);
			frame2.setVisible(true);
			}catch(Exception e){
					e.printStackTrace();
				}
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
	
}
