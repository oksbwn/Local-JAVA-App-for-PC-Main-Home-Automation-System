package com.oksbwn.quickNotes;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
public class noteShowFrame {
public static void main(String[] args)
  {
	new noteShowFrame(0, 0, "bikash narayan anda", "745734653656354564");
	}
final JFrame frame=new JFrame();
public noteShowFrame(int xpos,int ypos,String name,String no){
	frame.setUndecorated(true);
	frame.setType(javax.swing.JFrame.Type.UTILITY);
	frame.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),100));
    ((JComponent)frame.getContentPane()).setBorder(    
 	        BorderFactory.createMatteBorder( 3, 2, 2, 2, Color.black ) );
    frame.setBounds(xpos, ypos, 200,125);
	frame.getContentPane().setLayout(null);
	
	 final JLabel lblX = new JLabel("X");
	 lblX.setLocation(frame.getWidth()-12,5);
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
	
	JLabel lblNewLabel = new JLabel(name);
	lblNewLabel.setBounds(0, 0,150, 24);
	lblNewLabel.setForeground(Color.blue);
	lblNewLabel.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),0));
	frame.getContentPane().add(lblNewLabel);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(45, 21, 110, 2);
	frame.getContentPane().add(separator);
	
	JEditorPane lblNewLabel_1 = new JEditorPane();
	lblNewLabel_1.setText(no);
	lblNewLabel_1.setEditable(false);
	lblNewLabel_1.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),0));
	lblNewLabel_1.setForeground(Color.green);
	lblNewLabel_1.setBounds(0, 21, 150, 100);
	frame.getContentPane().add(lblNewLabel_1);
	frame.setVisible(true);
	  new Thread(){  
          @Override 
           public void run() { 
        	    	 while(true) {
        	    		  try {
								Thread.sleep(10000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        	    		     if(contUserOptn.lblKill.isSelected())
        	    			  { 
        	                      frame.dispose();
        	                    
        	                      break;
        	    			  }
        	    		    } 
            	     };
        	  }.start(); 
}
}