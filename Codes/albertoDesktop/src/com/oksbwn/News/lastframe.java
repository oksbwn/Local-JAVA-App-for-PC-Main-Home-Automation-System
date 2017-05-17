package com.oksbwn.News;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class lastframe {

    final JFrame jf = new JFrame("JIFrameDemo Main Window");
	public JFrame dispose(){
	return jf;
}
	public void frame(int xPos,int yPos){
    jf.setUndecorated(true);
    jf.setAlwaysOnTop(true);
    jf.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),0));
    jf.setSize(100,100);
    jf.setLocation(xPos, yPos);
    JDesktopPane dtp = new JDesktopPane();
    dtp. setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),100));
   // dtp.setBackground(Color.GREEN);
    jf.setContentPane(dtp);  
    jf.setType(javax.swing.JFrame.Type.UTILITY);
    
	((JComponent)jf.getContentPane()).setBorder(    
	        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );

	final JLabel lblX1 = new JLabel("<html><body><img width= '100' height='90' src='"+getClass().getResource("exit.png") +"'</body></html>");
	lblX1.setLocation(0,0);
	lblX1.setForeground(new Color(255, 255,255));
	lblX1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			shownewsFrames xy=new shownewsFrames();
			xy.allDispose();
		}
	});
	lblX1.setSize(110,110);
	lblX1.setToolTipText("Completed");
	lblX1.setFocusable(false);
	jf.add(lblX1);
    jf.setVisible(true);
    }
}
