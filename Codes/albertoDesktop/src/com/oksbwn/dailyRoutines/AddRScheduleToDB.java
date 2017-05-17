package com.oksbwn.dailyRoutines;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
public class AddRScheduleToDB {
	private JFrame frame;
	public static void main(String[] args) {
					new AddRScheduleToDB();
		}
public AddRScheduleToDB() {
		frame = new JFrame();
		frame.setBounds(100, 100, 241,180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true); 
        frame.addMouseListener(mouseListener);
	    frame.addMouseMotionListener(mouseListener);
		frame.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),1));
	   ((JComponent)frame.getContentPane()).setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );
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
				   }});
		cloesButton.setSize(15,15);
		cloesButton.setBounds(frame.getWidth()-15, 2, 15,15);
		frame.getContentPane().add(cloesButton);
		
		JLabel lblSetReminders = new JLabel("Set Reminders");
		lblSetReminders.setForeground(Color.white);
		lblSetReminders.setBounds(83, 15, 96, 10);
		frame.getContentPane().add(lblSetReminders);
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 28, 221, 99);
		editorPane.setForeground(Color.white);
		editorPane.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),2));
		editorPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				frame.repaint();
			}
			
		});
		frame.getContentPane().add(editorPane);
		
		String[] bankNames = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		final JComboBox comboBox = new JComboBox(bankNames);
		comboBox.setBounds(84,138,70, 20);
		frame.getContentPane().add(comboBox);

		final JSpinner spinner = new JSpinner(new SpinnerNumberModel(00,00,01+23,01));
		spinner.setBounds(10, 138, 47, 20);
		frame.getContentPane().add(spinner);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				try{
				String time="";
				if((Integer)spinner.getValue()<10){time="0"+spinner.getValue()+":00";}
				else {time=""+spinner.getValue()+":00";}
				String day=(String)comboBox.getSelectedItem();
				    Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikash","root","");
					int x =con.prepareStatement("insert into `schedule` values(null,'"+day+"','"+time+"','"+editorPane.getText()+"')").executeUpdate();
					if (x==1)
					{	
				    new popMe("Reminder Added..","Reminder.","note",10,125);  
					new Voice("Sir i have added the reminder....and   I   Will notify about it.");
					}
				}catch(Exception e){new handleExceptions(e);}
			}
			
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					String time="";
					if((Integer)spinner.getValue()<10){time="0"+spinner.getValue()+":00";}
					else {time=""+spinner.getValue()+":00";}
					String day=(String)comboBox.getSelectedItem();
					    Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikash","root","");
						int x =con.prepareStatement("insert into `schedule` values(null,'"+day+"','"+time+"','"+editorPane.getText()+"')").executeUpdate();
						if (x==1)
						{	
					    new popMe("Schedule Added..","Schedule.","note",10,125);  
						new Voice("Sir i have added the schedule.");
						}
					}catch(Exception e){new handleExceptions(e);}
			}
		});
		btnNewButton.setBounds(165,138, 70, 23);
		frame.getContentPane().add(btnNewButton);
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
