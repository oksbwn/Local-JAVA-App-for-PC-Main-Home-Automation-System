package com.oksbwn.dailyRoutines;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;
public class scheduleShowFrame {
public static void main(String[] args)
  {
	new scheduleShowFrame(0, 0, "bikash narayan anda", "745734653656354564","");
	}
final JFrame frame=new JFrame();
public scheduleShowFrame(int xpos,int ypos,String name,String no,final String Sl_No){
	frame.setUndecorated(true);
	frame.setType(javax.swing.JFrame.Type.UTILITY);
	frame.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),1));
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
	lblNewLabel.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),0));
	frame.getContentPane().add(lblNewLabel);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(45, 21, 110, 2);
	frame.getContentPane().add(separator);
	
	JEditorPane lblNewLabel_1 = new JEditorPane();
	lblNewLabel_1.addMouseListener(mouseListener);
	lblNewLabel_1.addMouseMotionListener(mouseListener);
	lblNewLabel_1.setText(no);
	lblNewLabel_1.setEditable(false);
	lblNewLabel_1.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),1));
	lblNewLabel_1.setForeground(Color.white);
	lblNewLabel_1.setBounds(0, 21, 150, 100);
	frame.getContentPane().add(lblNewLabel_1);
	
	JButton delButton = new JButton("Del");
	delButton.setBounds(frame.getWidth()-65,frame.getHeight()-25,60, 20);
	delButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			 final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
				if (runnable != null)
				runnable.run();
				try{
				 Class.forName("com.mysql.jdbc.Driver");
				   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikash","root","");
				   int x=con.prepareStatement("DELETE FROM `schedule` WHERE `Sl_No`LIKE '"+Sl_No+"'").executeUpdate();
				  if(x==1)
				  {
					  new Voice("Sir I have deleted the Schedule.");
					  new popMe("Schedule sucessfully deleted.","Scheduler","note",6,125);
				  }
				}catch(Exception e){new handleExceptions(e);}
		}
	});
	frame.getContentPane().add(delButton);
	
	
	frame.setVisible(true);
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
        	frame. setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
        }
    }
};
}