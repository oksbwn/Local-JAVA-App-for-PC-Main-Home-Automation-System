
/**
 * This application simply return Frames with different food icons when Name Provided
 * 
 * 
 * */
package com.oksbwn.foodTakenInDay;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.oksbwn.popUp.popMe;


public class createFrame {
    final JFrame jf = new JFrame("JIFrameDemo Main Window");
	public JFrame dispose(){
		return jf;
	}
	public void frame(int xPos,int yPos,final String img){
    jf.setUndecorated(true);
    jf.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),1));
    jf.setSize(100,100);
    jf.setLayout(null);
    jf.setLocation(xPos, yPos);
    jf.setType(javax.swing.JFrame.Type.UTILITY);
    jf.setAlwaysOnTop(true);
	((JComponent)jf.getContentPane()).setBorder(    
	        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );
	
	final JLabel lblX1 = new JLabel();
	java.net.URL url = null;
	try {
		url = new File("C:/Alberto/Interface/foodIcons/"+img+".png").toURI().toURL();
	} catch (Exception e1) {}
	if(!new File("C:/Alberto/Interface/foodIcons/"+img+".png").exists())
		try {
		url = new File("C:/Alberto/Interface/foodIcons/"+img+".jpg").toURI().toURL();
	} catch (MalformedURLException e2) {}
		
	lblX1.setText("<html><img src="+url+" width=\"100\" height=\"110\"></img></html>");
	 
	lblX1.setLocation(0,0);
	lblX1.setForeground(new Color(255, 255,255));
	final addFood fd=new addFood();
	lblX1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			 new popMe("Selected ",img, "ok",3,125);
			String list;
			String bef=fd.returnlast();
			if (bef=="")
				list=bef+""+img;
			else 
			  {
				list=bef+","+img;
			  }
			fd.addnew(list);
		}
	});
	lblX1.setSize(110,110);
	lblX1.setToolTipText(img);
	lblX1.setFocusable(false);
	jf.add(lblX1);
    jf.setVisible(true);
    }
}
