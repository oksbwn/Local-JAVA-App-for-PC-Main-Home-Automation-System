package com.oksbwn.ErrorHandling;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
public class showError {
    JFrame frame2 = new JFrame();
   // public static void main(String[] args) 
	//   {
    //	showError sl=new showError();
		//sl.errorFrame("gdfhgdgfgdfhgdhgdhgdhkgfhdgfhfdghkdgffghdhfgdhf"
			//	+ "dhfhgdhgfhkdgfhkgdfhkgfkhgf"
				//+ "hdgfhgdhghgfdhgfd");
	   //}
public showError(Exception e)
  {   
	
	Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen  
	final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
	//default 
	if (runnable != null)
	   runnable.run();
	frame2.setBounds((scrSize.width/2)-160, (scrSize.height/2)-100, 320, 200);
  	  frame2.getContentPane().setLayout(null);
  	  frame2.addMouseListener(mouseListener);
  	  frame2.addMouseMotionListener(mouseListener);
  	  frame2.setAlwaysOnTop(true);
  	  frame2.setUndecorated(true);
        frame2.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),50));
        frame2.getContentPane().setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),50));
  	  ((JComponent)frame2.getContentPane()).setBorder(    
  		        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );
  	  frame2.setType(javax.swing.JFrame.Type.UTILITY);
  	  
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
			   }});
	  cloesButton.setSize(15,15);
	  cloesButton.setBounds(309, 2, 15,15);
	  frame2.getContentPane().add(cloesButton);
	
 
		final JEditorPane textArea = new JEditorPane();
		textArea.setBounds(10,30,300,135);
		textArea.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),0));
		textArea.setText(""+e);
		textArea.setEditable(false);
		textArea.setForeground(Color.red);
		frame2.getContentPane().add(textArea);
		
		JLabel err = new JLabel("ERROR");
		err.setBounds(130,5,40, 20);
		err.setForeground(Color.red);
		frame2.getContentPane().add(err);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0,25,320,4);
		frame2.getContentPane().add(separator);
		
			JButton btnAdd = new JButton("ok");
			btnAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					frame2.dispose();
				}});
			btnAdd.setBounds(102,172, 89, 23);
			frame2.getContentPane().add(btnAdd);
	  		frame2.setVisible(true);
	        new Thread(){  
	            @Override 
	             public void run() {  
	                   try {  
	                 	  Thread.sleep(30*1000); // time after which pop up will be disappeared.  
	                       frame2.dispose();  
	                       }
	                   catch (Exception e)
	                   {new handleExceptions(e);} };}.start();
}


final MouseAdapter mouseListener = new MouseAdapter() {
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
