package com.oksbwn.cricket;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.oksbwn.ErrorHandling.handleExceptions;
public class cricScore {
	private String score="";
	fromEspn crc=	new fromEspn();
	public static void main(String[] args)
	{cricScore cscr=new cricScore();
	cscr.goCricket();
    } 
	private boolean stat=true;
JFrame frame2=new JFrame();
	public void goCricket()
	{    
	  Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	  frame2.setBounds(gh.width-225, 100,220,200);
	  frame2.getContentPane().setLayout(null);
	  frame2.addMouseListener(mouseListener);
	  frame2.addMouseMotionListener(mouseListener);
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
		     	stat=false;
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
	  cloesButton.setBounds(205,5, 15,15);
	  frame2.getContentPane().add(cloesButton);
	

		final JEditorPane textArea = new JEditorPane();
		textArea.setBounds(5,5, 210, 170);
		textArea.setEditable(false);
        textArea.setText(score);
		textArea.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),0));
		textArea.setForeground(Color.white);
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {	
			  frame2.repaint();
			}
		});
		frame2.getContentPane().add(textArea);
	  	frame2.setVisible(true);
	    new Thread(){  
	           @Override 
	            public void run() {  
	        	   while(stat){try 
	        	      {
	        		   Thread.sleep(10000);
	        		   score=crc.getScores();
	        		   System.out.println(score);
                       textArea.setText(score);
	                   frame2.revalidate();  
	                  }
	                  catch (Exception e) {new handleExceptions(e);}
	        	   } 
	        	   };}.start();
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