package com.oksbwn.mail;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.popUp.popMe;

//import com.oksbwn.popUp.popMe;

public class SendMail  extends JFrame {

	final static JFrame frame = new JFrame();
	private static final long serialVersionUID = 1L;
	public void SendMailTo(){
	   //public static void main(String[] args) {

		frame.addMouseListener(mouseListener);
		frame.addMouseMotionListener(mouseListener);
		frame.setUndecorated(true);
	    frame.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),1));
	     ((JComponent)frame.getContentPane()).setBorder(    
			        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );
		frame.setType(javax.swing.JFrame.Type.UTILITY);
		frame.setBounds(100, 100, 440, 280);
		frame.getContentPane().setLayout(null);
		
		final JTextField textField = new JTextField();
		textField.setOpaque(false);
		textField.setForeground(Color.white);
		textField.setBounds(159, 11, 245, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		final JTextField textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setForeground(Color.white);
		textField_1.setBounds(159, 52, 245, 34);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
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
		cloesButton.setBounds(430, 2, 15,15);
		frame.getContentPane().add(cloesButton);
		
		final JTextPane textPane = new JTextPane();
		textPane.setOpaque(false);

		textPane.setForeground(Color.white);
		textPane.setBounds(74, 97, 330, 134);
		textPane.setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.pink ) );
		frame.getContentPane().add(textPane);

		JLabel lblTo = new JLabel("To :");
		lblTo.setForeground(Color.white);
		lblTo.setBounds(70, 19, 66, 14);
		frame.getContentPane().add(lblTo);
		
		JLabel lblSub = new JLabel("Subject :");
		lblSub.setForeground(Color.white);
		lblSub.setBounds(74, 62, 66, 14);
		frame.getContentPane().add(lblSub);
		
		JLabel lblMessage = new JLabel("Message :");
		lblMessage.setOpaque(false);
		lblMessage.setForeground(Color.white);
		lblMessage.setBounds(10, 137, 70, 14);
		frame.getContentPane().add(lblMessage);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sendMailTo(textField.getText(),textField_1.getText(),textPane.getText());
				frame.dispose();
				
			}
		});
		btnNewButton.setBounds(330, 239, 74, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}
 public static void  sendMailTo (String to,String sub,String bod)
 {
  //Get the session object
  Properties props = new Properties();
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.port", "465");
 
  Session session = Session.getDefaultInstance(props,
   new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
	   Properties prop = new Properties();
		InputStream input = null;
		try{
			input = new FileInputStream("C:\\Alberto\\Config\\gmail.properties");
			prop.load(input);
			input.close();
		 }
		catch(Exception e){new handleExceptions(e);}
   return new PasswordAuthentication(prop.getProperty("mail"),prop.getProperty("pwd"));//change accordingly

	
   }
  });
  try {
   MimeMessage message = new MimeMessage(session);
   Properties prop = new Properties();
	InputStream input = null;
	try{
		input = new FileInputStream("C:\\Alberto\\Config\\gmail.properties");
		prop.load(input);
		input.close();
	 }
	catch(Exception e){new handleExceptions(e);}
   message.setFrom(new InternetAddress(prop.getProperty("mail")));//change accordingly
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
   message.setSubject(sub);
   message.setText(bod);
   Transport.send(message);
   new popMe("message sent successfully","E-Mail","email",5,125);
  } catch (Exception e){new handleExceptions(e);}
  }
 final static MouseAdapter mouseListener = new MouseAdapter() {
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
