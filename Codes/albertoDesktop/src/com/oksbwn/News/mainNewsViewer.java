/*
 *Shows Clicked news as well as Speaks
 * */
package com.oksbwn.News;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;

import com.oksbwn.voiceEnable.Voice;
public class mainNewsViewer {
	public mainNewsViewer(String Date,String Head,String Detal)
	{//System.out.println(Date+Head+Detal);
		Runnable r = new MyThread(Date,Head,Detal);
		new Thread(r).start();
		//System.out.println(Date+Head+Detal);
	}

 }
class MyThread implements Runnable {
	private String Date;
	private String Header;
	private String Details;
	JFrame frame;
	
public MyThread(String Date1,String Head1,String Detal1) {
	//System.out.println(Date1+Head1+Detal1);
       // store parameter for later user
	this.Date=Date1;
	this.Header=Head1;
	this.Details=Detal1;
	   
   }
	public void run() {
		new Voice(Details);
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),100));
	    ((JComponent)frame.getContentPane()).setBorder(BorderFactory.createMatteBorder( 3, 2, 2, 2, Color.black ) ); 
		frame.setBounds(100, 50, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(mouseListener);
		frame.addMouseMotionListener(mouseListener);
		frame.getContentPane().setLayout(null);
		
		 final JLabel lblX = new JLabel("X");
		 lblX.setLocation(frame.getWidth()-15,5);
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
		
		JLabel lblNewLabel = new JLabel(Header);
		lblNewLabel.setBounds(0, 0, 500, 23);
		lblNewLabel.setForeground(Color.red);
		lblNewLabel.setOpaque(false);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 21, 500, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel(Date);
		lblNewLabel_1.setOpaque(false);
		lblNewLabel_1.setForeground(Color.green);
		lblNewLabel_1.setBounds(0, 21, 500, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 46, 500, 2);
		frame.getContentPane().add(separator_1);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setForeground(Color.CYAN);
		editorPane.setText(Details);
		editorPane.setOpaque(false);
		editorPane.setBounds(0, 49, 500, 350);
		frame.getContentPane().add(editorPane);
		frame.setVisible(true);
	}
	
	//Other Codes
	
	private final MouseAdapter mouseListener = new MouseAdapter() {
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
