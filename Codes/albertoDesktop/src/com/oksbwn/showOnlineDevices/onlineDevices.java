/**
 * Shows LAN Devices Status
 * Dt:05/Jul/2014
 * 
 * */
package com.oksbwn.showOnlineDevices;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class onlineDevices {
JFrame frame=new JFrame();
InetAddress address = null;
	public static void main(String[] args) {
		new onlineDevices().showDevices();
	}
public void showDevices() {
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
	
	final JFXPanel fx13 = new JFXPanel();
	fx13.setForeground(Color.red);
	fx13.setToolTipText("All Bank Transactions");
	fx13.setOpaque(false);
	fx13.setBounds(140,140,55,50);
	frame.getContentPane().add(fx13);
	
	final JFXPanel fx14 = new JFXPanel();
	fx14.setForeground(Color.red);
	fx14.setToolTipText("All Bank Transactions");
	fx14.setOpaque(false);
	fx14.setBounds(205,140,55,50);
	frame.getContentPane().add(fx14);
	
	final JFXPanel fx15 = new JFXPanel();
	fx15.setForeground(Color.red);
	fx15.setToolTipText("All Bank Transactions");
	fx15.setOpaque(false);
	fx15.setBounds(270,140,55,50);
	frame.getContentPane().add(fx15);
	
	final JFXPanel fx16 = new JFXPanel();
	fx16.setForeground(Color.red);
	fx16.setToolTipText("All Bank Transactions");
	fx16.setOpaque(false);
	fx16.setBounds(10,200,55,50);
	frame.getContentPane().add(fx16);
	
	final JFXPanel fx17 = new JFXPanel();
	fx17.setForeground(Color.red);
	fx17.setToolTipText("All Bank Transactions");
	fx17.setOpaque(false);
	fx17.setBounds(75,200,55,50);
	frame.getContentPane().add(fx17);
	
	final JFXPanel fx18 = new JFXPanel();
	fx18.setForeground(Color.red);
	fx18.setToolTipText("All Bank Transactions");
	fx18.setOpaque(false);
	fx18.setBounds(140,200,55,50);
	frame.getContentPane().add(fx18);
	
	final JFXPanel fx19 = new JFXPanel();
	fx19.setForeground(Color.red);
	fx19.setToolTipText("All Bank Transactions");
	fx19.setOpaque(false);
	fx19.setBounds(205,200,55,50);
	frame.getContentPane().add(fx19);
	
	final JFXPanel fx20 = new JFXPanel();
	fx20.setForeground(Color.red);
	fx20.setToolTipText("All Bank Transactions");
	fx20.setOpaque(false);
	fx20.setBounds(270,200,55,50);
	frame.getContentPane().add(fx20);
	
	
	 Platform.setImplicitExit(false);
	   Platform.runLater(new Runnable(){
	        @Override
	        public void run() {
	        	try {
	        		 byte[] ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)35};
	        	      address = InetAddress.getByAddress(ip);
	        	    if(address.isReachable(3000))
	  	        	{
	        	    	new fxPanelImage().initFxLater(fx1,"phone");
	  	        	}
	        	    else{
	        	    	new fxPanelImage().initFxLater(fx1,"noPhone");
	        	    } 
	        	    ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)100};
	        	      address = InetAddress.getByAddress(ip);
	        	    if(address.isReachable(3000))
	  	        	{
	        	    	new fxPanelImage().initFxLater(fx2,"pi");
	  	        	}
	        	    else{
	        	    	new fxPanelImage().initFxLater(fx2,"noPi");
	        	    }
	        	    ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)10};
	        	      address = InetAddress.getByAddress(ip);
	        	    if(address.isReachable(3000))
	  	        	{
	        	    	new fxPanelImage().initFxLater(fx3,"desk");
	  	        	}
	        	    else{
	        	    	new fxPanelImage().initFxLater(fx3,"noDesk");
	        	    }
	        	    ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)20};
	        	      address = InetAddress.getByAddress(ip);
	        	    if(address.isReachable(3000))
	  	        	{
	        	    	new fxPanelImage().initFxLater(fx4,"hdd");
	  	        	}
	        	    else{
	        	    	new fxPanelImage().initFxLater(fx4,"noHdd");
	        	    }
	        	    ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)1};
	        	      address = InetAddress.getByAddress(ip);
	        	    if(address.isReachable(3000))
	  	        	{
	        	    	new fxPanelImage().initFxLater(fx5,"lappi");
	  	        	}
	        	    else{
	        	    	new fxPanelImage().initFxLater(fx5,"noLapi");
	        	    }
	        	    ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)125};
	        	      address = InetAddress.getByAddress(ip);
	        	    if(address.isReachable(3000))
	  	        	{
	        	    	new fxPanelImage().initFxLater(fx6,"wifi");
	  	        	}
	        	    else{
	        	    	new fxPanelImage().initFxLater(fx6,"noWifi");
	        	    }
	        	    ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)7};
	        	      address = InetAddress.getByAddress(ip);
	        	    if(address.isReachable(3000))
	  	        	{
	        	    	new fxPanelImage().initFxLater(fx7,"arduino");
	  	        	}
	        	    else{
	        	    	new fxPanelImage().initFxLater(fx7,"noArduino");
	        	    } 
	        	    ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)254};
	        	    address = InetAddress.getByAddress(ip);
	        	    if(address.isReachable(3000))
	  	        	{
	        	    	new fxPanelImage().initFxLater(fx8,"wifiTp");
	  	        	}
	        	    else{
	        	    	new fxPanelImage().initFxLater(fx8,"noWifiTp");
	        	    }
	        	    ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)8};
	        	    address = InetAddress.getByAddress(ip);
	        	    if(address.isReachable(3000))
	  	        	{
	        	    	new fxPanelImage().initFxLater(fx9,"arduinoKit");
	  	        	}
	        	    else{
	        	    	new fxPanelImage().initFxLater(fx9,"noArduinoKit");
	        	    }
	        	    ip = new byte[] {(byte)192,(byte)168,(byte)0,(byte)50};
	        	    address = InetAddress.getByAddress(ip);
	        	    if(address.isReachable(3000))
	  	        	{
	        	    	new fxPanelImage().initFxLater(fx10,"lappiSuv");
	  	        	}
	        	    else{
	        	    	new fxPanelImage().initFxLater(fx10,"noLapiSuv");
	        	    }
	               }catch (Exception e) {e.printStackTrace();}
	            new fxPanelImage().initFxLater(fx11,"bank");
	            new fxPanelImage().initFxLater(fx12,"bank");
	            new fxPanelImage().initFxLater(fx13,"bank");
	            new fxPanelImage().initFxLater(fx14,"bank");
	            new fxPanelImage().initFxLater(fx15,"bank");
	            new fxPanelImage().initFxLater(fx16,"bank");
	            new fxPanelImage().initFxLater(fx17,"bank");
	            new fxPanelImage().initFxLater(fx18,"bank");
	            new fxPanelImage().initFxLater(fx19,"bank");
	            new fxPanelImage().initFxLater(fx20,"bank");
	 	        }
	    });
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
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
