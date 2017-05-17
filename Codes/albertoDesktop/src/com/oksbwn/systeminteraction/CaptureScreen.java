package com.oksbwn.systeminteraction;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import resources.RscLoader;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.popUp.popMe;
public class CaptureScreen {
	static JFrame frame2=new JFrame();
	static Point p;
	static Point R;
	static Point D;
	static int Finaly;
	static int Startx;
	static int Starty;
	static int Finalx;
	static JTextField jt=new JTextField();
  public static void main(String[] args) 
  {
	  CaptureScreen cS=new CaptureScreen();
	  cS.SnapTaker();
  }
	public void SnapTaker()
	  {
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
	  	
	  	jt.setBounds(0,0,0,0);
	  	jt.addMouseListener(mouseListener);
	  	jt.setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ));
	  	jt.addMouseMotionListener(mouseListener);
	  	jt.setEditable(false);
	    jt.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),0));
	  	frame2.getContentPane().add(jt);
	  	
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
		  cloesButton.setBounds(scrSize.width-15, scrSize.height-20,15,20);
		  
          final JLabel Snap = new JLabel();
          Snap.setIcon(new ImageIcon(RscLoader.getImage("cam")));
          Snap.setForeground(Color.white);
          Snap.setToolTipText("Take Snap");
          Snap.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent arg0) {
			     	takeSnap();
				     }
			   @Override
			   public void mouseEntered(MouseEvent arg0) {
				   Snap.setForeground(Color.GREEN);
				   }
			  @Override
			   public void mouseExited(MouseEvent arg0) {
				  Snap.setForeground(Color.white);
				   }});
          Snap.setBounds(scrSize.width-100, scrSize.height-20,60,20);
		  frame2.getContentPane().add(Snap);
		  
		  frame2.addMouseListener(new MouseAdapter() {
			  
			   @Override
			   public void mousePressed(MouseEvent arg0) {
			    	p= MouseInfo.getPointerInfo().getLocation();
			    	 //jt.setBounds(0,0,p.x,p.y);
				   }
			   @Override
			   public void mouseReleased(MouseEvent arg0) {
			    	R= MouseInfo.getPointerInfo().getLocation();
			        jt.setBounds(p.x,p.y,R.x-p.x,R.y-p.y);
				   }});
		  frame2.getContentPane().add(cloesButton);
	  	frame2.setVisible(true);

  }
  private final static void takeSnap()
  {
	   try {
		     Robot robot = new Robot();		     
		     Rectangle area = new Rectangle(jt.getBounds());
		     BufferedImage bufferedImage = robot.createScreenCapture(area);
		     File file = new File("C:\\users\\oksbwn\\desktop\\screenshot_small.png");
		     boolean i=ImageIO.write(bufferedImage, "jpg", file);
		     if (i)
		     {
		    	 new popMe("Snap taken Sucessfully.","Screen Capture","ok",2,125);
		     }
		  } catch (Exception e) {new handleExceptions(e);}
  }
  private final static MouseAdapter mouseListener = new MouseAdapter() {
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
          	jt. setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
          }
      }
  };
  
}