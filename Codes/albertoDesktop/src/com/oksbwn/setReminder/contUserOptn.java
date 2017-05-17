package com.oksbwn.setReminder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class contUserOptn {
	final static JToggleButton lblKill = new JToggleButton();
	static int x=8;
	public void contUserOptnDisp() {
		final JFrame frame;
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setUndecorated(true);
		frame.setBounds(100, 100,165,67);
		frame.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),1));
		JDesktopPane dtp = new JDesktopPane();
		dtp. setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),1));
		frame.setContentPane(dtp);  
		((JComponent)frame.getContentPane()).setBorder(    
		BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );

		frame.setType(javax.swing.JFrame.Type.UTILITY);
		frame.getContentPane().setLayout(null);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			x=1;
			}
		});
		btnYes.setBounds(8, 35, 60, 23);
		frame.getContentPane().add(btnYes);
		JButton btnNo = new JButton("No");
		btnNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				x=0;
			}
		});
		 
		btnNo.setBounds(75, 35, 50, 23);
		frame.getContentPane().add(btnNo);

		lblKill.setBounds(135, 35,23,23);
		frame.getContentPane().add(lblKill);
		
		frame.setType(javax.swing.JFrame.Type.UTILITY);
		final JLabel cloesButton = new JLabel("X");
		cloesButton.setForeground(Color.white);
		cloesButton.setToolTipText("Close");
		cloesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				cloesButton.setForeground(Color.red);
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
				cloesButton.setForeground(Color.white);
				}
			
		});
		cloesButton.setSize(15,15);
		cloesButton.setBounds(frame.getWidth()-15,0, 15,15);
		frame.getContentPane().add(cloesButton);
		JLabel lblWantToRead = new JLabel("Want to read More");
		lblWantToRead.setForeground(Color.blue);
		lblWantToRead.setBounds(10, 11, 110, 16);
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen  
        Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar  
        frame.setLocation(scrSize.width - frame.getWidth(), scrSize.height - toolHeight.bottom - frame.getHeight()); 
		frame.getContentPane().add(lblWantToRead);
		frame.setVisible(true);}
	public int getVal(){
					return x;
}
	}
