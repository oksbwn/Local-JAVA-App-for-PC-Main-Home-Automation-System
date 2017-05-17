/*this is the main graphics window showing different ICONS to switch the loads
 * 
 * completed on Dt:27/7/2014
 * Board Ip :192.168.0.9
 * */
package com.oksbwn.switchingBoardOne;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class graphicInterface {

	public static void main(String[] args) {
	new graphicInterface().Main();	
	}
	mouseClickedOnLoad clicked=new mouseClickedOnLoad();	
JFrame frame=new JFrame();
public void Main(){		
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),1));
	    ((JComponent)frame.getContentPane()).setBorder(BorderFactory.createMatteBorder( 3, 2, 2, 2, Color.black ) ); 
		frame.setType(Type.UTILITY);
		frame.setBounds(200,200,335,200);
		  frame.addMouseListener(mouseListener);
		  frame.addMouseMotionListener(mouseListener);
		
	    final  JLabel cloesButton = new JLabel("X");
	  	cloesButton.setForeground(Color.red);
	  	cloesButton.addMouseListener(new MouseAdapter() {
	  	    @Override
	  	    public void mouseClicked(MouseEvent arg0) {
	  	    	frame.dispose();
	  	    }});
	  	cloesButton.setBounds(frame.getWidth()-15,5, 15,15);
	  	frame.getContentPane().add(cloesButton);
	   
		final JFXPanel fx1 = new JFXPanel();
		fx1.setForeground(Color.red);
		fx1.setToolTipText("192.168.0.35");
		fx1.setOpaque(false);
		fx1.setBounds(10,20,55,50);
		frame.getContentPane().add(fx1);
		
		final JFXPanel fx2 = new JFXPanel();
		fx2.setForeground(Color.red);
		fx2.setToolTipText("192.168.0.100");
		fx2.setOpaque(false);
		fx2.setBounds(75,20,55,50);
		frame.getContentPane().add(fx2);
		
		final JFXPanel fx3 = new JFXPanel();
		fx3.setForeground(Color.red);
		fx3.setToolTipText("192.168.0.10");
		fx3.setOpaque(false);
		fx3.setBounds(140,20,55,50);
		frame.getContentPane().add(fx3);
		
		final JFXPanel fx4 = new JFXPanel();
		fx4.setForeground(Color.red);
		fx4.setToolTipText("192.168.0.20");
		fx4.setOpaque(false);
		fx4.setBounds(205,20,55,50);
		frame.getContentPane().add(fx4);
		
		final JFXPanel fx5 = new JFXPanel();
		fx5.setForeground(Color.red);
		fx5.setToolTipText("192.168.0.1");
		fx5.setOpaque(false);
		fx5.setBounds(270,20,55,50);
		frame.getContentPane().add(fx5);
		
		final JFXPanel fx6 = new JFXPanel();
		fx6.setForeground(Color.red);
		fx6.setToolTipText("192.168.0.125");
		fx6.setOpaque(false);
		fx6.setBounds(10,80,55,50);
		frame.getContentPane().add(fx6);
		
		final JFXPanel fx7 = new JFXPanel();
		fx7.setForeground(Color.red);
		fx7.setToolTipText("192.168.0.7");
		fx7.setOpaque(false);
		fx7.setBounds(75,80,55,50);
		frame.getContentPane().add(fx7);
		
		final JFXPanel fx8 = new JFXPanel();
		fx8.setForeground(Color.red);
		fx8.setToolTipText("192.168.0.254");
		fx8.setOpaque(false);
		fx8.setBounds(140,80,55,50);
		frame.getContentPane().add(fx8);
		
		final JFXPanel fx9 = new JFXPanel();
		fx9.setForeground(Color.red);
		fx9.setToolTipText("192.168.0.8");
		fx9.setOpaque(false);
		fx9.setBounds(205,80,55,50);
		frame.getContentPane().add(fx9);
		
		final JFXPanel fx10 = new JFXPanel();
		fx10.setForeground(Color.red);
		fx10.setToolTipText("192.168.0.50");
		fx10.setOpaque(false);
		fx10.setBounds(270,80,55,50);
		frame.getContentPane().add(fx10);
		
		final JFXPanel fx11 = new JFXPanel();
		fx11.setForeground(Color.red);
		fx11.setToolTipText("All Bank Transactions");
		fx11.setOpaque(false);
		fx11.setBounds(10,140,55,50);
		frame.getContentPane().add(fx11);
		
		final JFXPanel fx12 = new JFXPanel();
		fx12.setForeground(Color.red);
		fx12.setToolTipText("All Bank Transactions");
		fx12.setOpaque(false);
		fx12.setBounds(75,140,55,50);
		frame.getContentPane().add(fx12);
				
		 Platform.setImplicitExit(false);
		   Platform.runLater(new Runnable(){
		        @Override
		        public void run() {
		        	try {
		        		initialLoadStatus iLs=new initialLoadStatus();
		        		String initialStatus=iLs.getInitial();
		        	    if(initialStatus.charAt(0)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx1,"fivePinOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx1,"fivePinOn");
		        	    } 
		        	    if(initialStatus.charAt(1)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx2,"fivePinOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx2,"fivePinOn");
		        	    }
		        	    if(initialStatus.charAt(2)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx3,"fivePinOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx3,"fivePinOn");
		        	    }
		        	    if(initialStatus.charAt(3)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx4,"twoPinOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx4,"twoPinOn");
		        	    }
		        	    if(initialStatus.charAt(4)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx5,"loadOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx5,"loadOff");
		        	    }
		        	    if(initialStatus.charAt(5)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx6,"loadOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx6,"loadOff");
		        	    }
		        	    if(initialStatus.charAt(6)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx7,"loadOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx7,"loadOff");
		        	    } 
		        	    if(initialStatus.charAt(7)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx8,"loadOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx8,"loadOff");
		        	    }
		        	    if(initialStatus.charAt(8)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx9,"loadOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx9,"loadOff");
		        	    }
		        	    if(initialStatus.charAt(9)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx10,"loadOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx10,"loadOff");
		        	    }
		        	    if(initialStatus.charAt(10)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx11,"loadOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx11,"loadOff");
		        	    }
		        	    if(initialStatus.charAt(11)=='F')
		  	        	{
		        	    	new fxPanelImage().initFxLater(fx12,"loadOff");
		  	        	}
		        	    else{
		        	    	new fxPanelImage().initFxLater(fx12,"loadOff");
		        	    }
		               }catch (Exception e) {e.printStackTrace();}
		 	        }
		    });
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		////-----------------------------------------Click handlers------------------------------------------------------------------
		fx1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(0,fx1,"fivePin","outOne");
			}
		});
		fx2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(1,fx2,"fivePin","outTwo");
			}
		});
		fx3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(2,fx3,"fivePin","outThree");
			}
		});
		fx4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(3,fx4,"twoPin","outFour");
			}
		});
		fx5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(4,fx5,"load","outTwo");
			}
		});
		fx6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(5,fx6,"load","outTwo");
			}
		});
		fx7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(6,fx7,"load","outTwo");
			}
		});
		fx8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(7,fx8,"load","outTwo");
			}
		});
		fx9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(8,fx9,"load","outTwo");
			}
		});
		fx10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(9,fx10,"load","outTwo");
			}
		});
		fx11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(10,fx11,"load","outTwo");
			}
		});
		fx12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			clicked.clickedOn(11,fx12,"load","outTwo");
			}
		});
		}

	//Other Codes
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
	        	frame. setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
	        }
	    }
	};
	
	
	
}
