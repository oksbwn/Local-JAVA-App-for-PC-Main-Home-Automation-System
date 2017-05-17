package com.oksbwn.Fbook;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;

import com.oksbwn.voiceEnable.Voice;
public class mainNewsViewer {
	public mainNewsViewer(int xpos,int ypos,String Date,String Head,String Detal)
	{ 
		Runnable r = new MyThread(xpos,ypos,Date,Head,Detal);
		new Thread(r).start(); 
	}

 }
class MyThread implements Runnable {
	private String Date;
	private String Header;
	private String Details;
private int xpos,ypos;
public MyThread(int xpos1,int ypos1,String Date1,String Head1,String Detal1) {
	this.Date=Date1;
	this.Header=Head1;
	this.Details=Detal1;
	this.xpos=xpos1;
	this.ypos=ypos1;
	   
   }
	public void run() {
		final JFrame frame;//new Voice(Details);
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),100));
	     JDesktopPane dtp = new JDesktopPane();
	     dtp. setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),100));
	     ((JComponent)frame.getContentPane()).setBorder(    
	 	        BorderFactory.createMatteBorder( 3, 2, 2, 2, Color.green ) );
	     frame.setContentPane(dtp); 
		frame.setBounds(xpos,ypos, 200, 200);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setType(javax.swing.JFrame.Type.UTILITY);
		  
		frame.getContentPane().setLayout(null);
			
		 final JLabel lblX = new JLabel("X");
		 lblX.setLocation(frame.getWidth()-15,5);
		 lblX.setForeground(new Color(255, 255,255));
		 lblX.setToolTipText("Close\r\n");
		 lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(new Color(255, 0, 0));
			}
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(new Color(255, 255,255));
			}
		});
		lblX.setSize(10,10);
		lblX.setFocusable(false);	
		frame.add(lblX);
		
		JLabel lblNewLabel = new JLabel(Header);
		lblNewLabel.setBounds(0, 0, 500, 23);
		lblNewLabel.setForeground(Color.red);
		lblNewLabel.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),0));
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 21, 500, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel(Date);
		lblNewLabel_1.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),0));
		lblNewLabel_1.setForeground(Color.green);
		lblNewLabel_1.setBounds(0, 21, 500, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 46, 500, 2);
		frame.getContentPane().add(separator_1);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			    final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				new Voice(Details);
			}
		});
		editorPane.setForeground(Color.blue);
		editorPane.setText(Details);
		editorPane.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),0));
		editorPane.setBounds(15, 49, frame.getWidth()-30, frame.getHeight()-50);
		frame.getContentPane().add(editorPane);
		frame.setVisible(true);
	}
}
