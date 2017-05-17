package com.oksbwn.Y2014.newProduct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.oksbwn.Y2014.FileDnD.CopyFile;
public class MainClassNewProduct {
	  JFrame jFrame = new JFrame();
	  String path2="C:/Alberto/Interface/newProduct/noImage.jpg";;
      JFXPanel jFXPanel = new JFXPanel();
	  Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	  JTextField productName=new JTextField("");
	  JTextField broughtFrom=new JTextField("");
	  JTextField productPrice=new JTextField("");
	  JTextField productWarranty=new JTextField("");
	  JTextField broughtDate=new JTextField("");
	  JButton addData=new JButton("ADD");	
	  JButton tw=new JButton("S");     
      JButton btnBrowse = new JButton("Browse");
	  JFileChooser fileChooser = new JFileChooser();;
	public static void main(String[] args) {
		new MainClassNewProduct().addNewProducts(0);
		}
	public void setContents(String path,String name,String from,String warranty,String date,String price)
	{if(!path.isEmpty())
	{
		this.path2="C:/Alberto/Interface/newProduct/"+path;
	}
		this.productName.setText(name);
		this.broughtDate.setText(date);
		this.broughtFrom.setText(from);
		this.productPrice.setText(price);
		this.productWarranty.setText(warranty);
		this.addData.setVisible(false);
		this.fileChooser.setVisible(false);
		this.btnBrowse.setVisible(false);
	}
	public void addNewProducts(int x)
	{
		  DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		  Date dat = new Date();
		  String date=dateFormat.format(dat);
	  	  jFrame.setLayout(null);
	   	  jFrame.setUndecorated(true);
	  	  jFrame.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),1));
	  	  jFrame.setType(javax.swing.JFrame.Type.UTILITY);
	      jFrame.setBounds(gh.width/2-175-x,(int) (gh.getHeight()/2)-75-x,350,200 );
	      jFrame.addMouseListener(mouseListener2);
	      jFrame.addMouseMotionListener(mouseListener2);
	      
		  JLabel cloesButton = new JLabel("X");
	      cloesButton.setForeground(Color.green);
	      cloesButton.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent arg0) {
		    		jFrame.dispose();
				     }});
		  cloesButton.setBounds(jFrame.getWidth()-10,5,35,10);
		  jFrame.getContentPane().add(cloesButton);
  	  
		  JLabel name=new JLabel("Product:");
		  name.setOpaque(false);
		  name.setForeground(Color.WHITE);
		  name.setBounds(110,15,55,20);
		  jFrame.getContentPane().add(name);
      
		  productName.setOpaque(false);
		  productName.setForeground(Color.WHITE);
		  productName.setBounds(170,15,130,20);
		  jFrame.getContentPane().add(productName);
		  
		  JLabel mail=new JLabel("From:");
		  mail.setOpaque(false);
		  mail.setForeground(Color.WHITE);
		  mail.setBounds(110,45,190,20);
		  jFrame.getContentPane().add(mail);
      
		  broughtFrom.setOpaque(false);
		  broughtFrom.setForeground(Color.WHITE);
		  broughtFrom.setBounds(170,45,130,20);
		  jFrame.getContentPane().add(broughtFrom);
      
	      JLabel fb=new JLabel("Price:");
	      fb.setOpaque(false);
	      fb.setForeground(Color.WHITE);
	      fb.setBounds(110,75,190,20);
	      jFrame.getContentPane().add(fb);
      
	      productPrice.setOpaque(false);
	      productPrice.setForeground(Color.WHITE);
	      productPrice.setBounds(170,75,130,20);
	      jFrame.getContentPane().add(productPrice);
      
	      JLabel twit=new JLabel("Warranty:");
	      twit.setOpaque(false);
	      twit.setForeground(Color.WHITE);
	      twit.setBounds(110,105,190,20);
	      jFrame.getContentPane().add(twit);
	      
	      JLabel WARR=new JLabel("Date:");
	      WARR.setOpaque(false);
	      WARR.setForeground(Color.WHITE);
	      WARR.setBounds(110,135,190,20);
	      jFrame.getContentPane().add(WARR);
	    
	      productWarranty.setOpaque(false);
	      productWarranty.setForeground(Color.WHITE);
	      productWarranty.setBounds(170,105,130,20);
	      jFrame.getContentPane().add(productWarranty);
	      
	      btnBrowse.setBounds(11,130, 87, 23);
	      jFrame.getContentPane().add(btnBrowse);
	      btnBrowse.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		          fileChooser.setAcceptAllFileFilterUsed(true);
		          fileChooser.setCurrentDirectory(new File("C://Users/OKSBWN/Desktop"));
		          int rVal = fileChooser.showOpenDialog(null);
		          if (rVal == JFileChooser.APPROVE_OPTION) {
		            System.out.println(fileChooser.getSelectedFile().toString());
		            Platform.runLater(new Runnable(){
			            @Override
			            public void run() {
			            		initFxLater(jFXPanel,fileChooser.getSelectedFile().toString());
			            	 }
			        });
		          }
	    	  }
	      });
      
	      broughtDate.setOpaque(false);
	      if(x==0)
	      {
	        broughtDate.setText(date);
	      }
	      broughtDate.setForeground(Color.WHITE);
	      broughtDate.setBounds(170,135,130,20);
	      jFrame.getContentPane().add(broughtDate);
      
	      addData.setOpaque(false);
	      addData.setForeground(Color.BLACK);
	      addData.setBounds(185,165,100,20);
	      addData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CopyFile d=new CopyFile();
			    d.copy(fileChooser.getSelectedFile().toString(),"C:/Alberto/Interface/newProduct");
				new addDataToDatabase().add(productName.getText(), broughtFrom.getText(),  productPrice.getText(),productWarranty.getText(),broughtDate.getText(),fileChooser.getSelectedFile().getName());	
			}
				});
		  jFrame.getContentPane().add(addData);
			      
	      jFXPanel.setOpaque(false);
	      jFXPanel.setBounds(5,40,100,100);
	      jFXPanel.setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.WHITE ));
	      ((JComponent) jFrame.getContentPane()).setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.BLACK ));
	      jFrame.getContentPane().add(jFXPanel);
			      
	      jFrame.setVisible(true); 
	      Platform.setImplicitExit(false);
	      Platform.runLater(new Runnable(){
	        @Override
	        public void run() {
	        		initFxLater(jFXPanel,path2);
	        	 }
	         });
			 }
//****************************************************************************************************************************//
		private  void initFxLater(JFXPanel panel,String path)
		{
		  File file = new File(path);
		  Image image = new Image(file.toURI().toString(),100,100,false,true);
		  DropShadow ds1 = new DropShadow();
		  ds1.setOffsetY(4.0f);
		  ds1.setOffsetX(4.0f);
		   
		    final ImageView  chart = new ImageView();
		    chart.setImage(image);
		    chart.setEffect(ds1);
		    Group root = new Group();
		    Scene scene = new Scene(root);
		    HBox box = new HBox();
		       
		    box.getChildren().add(chart);
		    root.getChildren().add(box);
		    scene.setFill(null);
		    panel.setScene(scene);
		}
		final  MouseAdapter mouseListener2 = new MouseAdapter() {
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
					    	  jFrame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
					      }
					  }
					};
	}