package com.oksbwn.News;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class createFrame {
    final JFrame jf = new JFrame("JIFrameDemo Main Window");
	public JFrame dispose(){
		return jf;
	}
  public void frame(int xPos,int yPos,final String Heading,final String Sl_No)
	{
     jf.setUndecorated(true);
     jf.setAlwaysOnTop(true);
     jf.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),0));
     jf.setSize(100,100);
     jf.setLocation(xPos, yPos);
     JDesktopPane dtp = new JDesktopPane();
     dtp. setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),100));
     jf.setContentPane(dtp);  
     jf.setType(javax.swing.JFrame.Type.UTILITY);
     ((JComponent)jf.getContentPane()).setBorder(    
	        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );
	 
     final JLabel lblX = new JLabel("X");
	 lblX.setLocation(89,5);
	 lblX.setForeground(new Color(255, 255,255));
	 lblX.setToolTipText("Close\r\n");
	 lblX.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jf.dispose();
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
	jf.add(lblX);
	
	final JEditorPane lblX1 = new JEditorPane();
	lblX1.setText(Heading);
	lblX1.setLocation(0,0);
	lblX1.setForeground(Color.white);
	lblX1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) 
		{ 
			//System.out.println("bc");
			try{
				  Class.forName("com.mysql.jdbc.Driver");
			      Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
					ResultSet resultNews=con1.prepareStatement("SELECT * FROM `news` WHERE `Sl_No` like '"+Sl_No+"'").executeQuery();
			         if(resultNews.next())
			         {
			        	String news=resultNews.getString(3);
			        	String Date=resultNews.getString(4);
			        	String Titel=resultNews.getString(2);
			        	new mainNewsViewer(Date, Titel, news);
			         } con1.close(); }catch(Exception e1){System.out.println(e1);}
		}
	});
	lblX1.setSize(110,110);
	lblX1.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),0));
	lblX1.setToolTipText("Click to read.");
	lblX1.setFocusable(false);
	jf.add(lblX1);
    jf.setVisible(true);
    }
}
