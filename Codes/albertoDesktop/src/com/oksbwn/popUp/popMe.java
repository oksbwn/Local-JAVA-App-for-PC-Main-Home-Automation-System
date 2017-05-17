package com.oksbwn.popUp;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;

import com.oksbwn.ErrorHandling.handleExceptions;

import resources.RscLoader;

public class popMe extends JFrame {
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) throws Exception{
			new popMe("hi hghags gdfgk kakjdkj adg kjus", "from Bikash kdghkfhjg djfkjdhgfkj jhjkdfk jkhdfhjdh kjdfjkhdkf h kjhdfjhfd", "ok",15, 125);
		}
public popMe(String message,String header,String image, final int time,int height) 
       {

	Runnable r = new newThreadPop(message,header,image,time,height);
	new Thread(r).start();
       }
 }
	
class newThreadPop implements Runnable {
	private String message;
	private String header;
	private String image;
	private  int time;
	private  int height;

		public newThreadPop(String message1,String header1,String image1, final int time1,int height1) {
		       // store parameter for later user
			this.message=message1;
			this.header=header1;
			this.image=image1;
			this.time=time1;
			this.height=65;
		   }

		   public void run() {
				final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
				//default 
				 if (runnable != null)
				   runnable.run();
				 
				try 
				 {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
					con.prepareStatement("UPDATE `lcd_data` SET  `Data` =  '"+message+"' WHERE `Sl_No` =1;").executeUpdate();
					con.close();
				 } catch (Exception e) {}
				 
				 
				 
				 
		final JFrame frame = new JFrame();
		frame.setUndecorated(true);
		frame.setType(javax.swing.JFrame.Type.UTILITY);
    	frame.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),0));
		((JComponent)frame.getContentPane()).setBorder(    
		        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );
		frame.setSize(600,height);
		frame.setLayout(null);

		final JLabel lblX = new JLabel("X");
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
				lblX.setForeground(new Color(0, 0, 0));
			}
		});
		lblX.setBounds(frame.getSize().width-10, 0, 10, 10);
		lblX.setFocusable(false);
		frame.getContentPane().add(lblX);
		
		JLabel head = new JLabel(header);
		head.setOpaque(false);
		head.setForeground(Color.red);
		head.setBounds(90,2,380,20);
		frame.getContentPane().add(head);
		
		JLabel headingLabel = new JLabel();
		ImageIcon headingIcon = new ImageIcon(RscLoader.getImage(image)); 
		headingLabel .setIcon(headingIcon); // --- use image icon you want to be as heading image.
		headingLabel.setOpaque(false);
		headingLabel.setBounds(5,5,80,55);
		frame.getContentPane().add(headingLabel);
		
		JLabel messageLabel = new JLabel("<HtMl>"+message);
		messageLabel.setForeground(Color.blue);
		messageLabel.setBounds(90, 20, 380,30);
		frame.getContentPane().add(messageLabel);
		
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen  
        frame.setLocation((int) ((scrSize.getWidth()/2)-frame.getWidth()/2),0); 
                new Thread(){  
           @Override 
            public void run() {  
                  try {  
                	  Thread.sleep(time*1000); // time after which pop up will be disappeared.  
                      frame.dispose();  
                      }
                  catch (Exception e)
                  {new handleExceptions(e);} };}.start(); 

	}
}
