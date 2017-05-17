package com.oksbwn.Y2014.twitter;
import javafx.scene.effect.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.oksbwn.ErrorHandling.handleExceptions;
public class newMessageBox 
  {
    static Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    static int x=gh.width;
	static int y=gh.height;
    Random randomGenerator = new Random();
    static JFrame jFrame = new JFrame();
    public void close()
      {
    	jFrame.dispose();
      }
   
    public static void main(String[] args)
     {
    	//new newMessageBox();
    	TwitterDatabaseAccess td=new TwitterDatabaseAccess();
    	try {
			td.update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    //	nm.close();
     }

    public newMessageBox()
      {
  	  jFrame.setLayout(null);
   	  jFrame.setUndecorated(true);
  	  jFrame.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),0));
  	  jFrame.setType(javax.swing.JFrame.Type.UTILITY);
      jFrame.setBounds(0,0,x,y);
      
	  final JLabel cloesButton = new JLabel("X");
	  cloesButton.setForeground(Color.white);
	  cloesButton.setToolTipText("Close");
	  cloesButton.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
		     	jFrame.dispose();
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
	  cloesButton.setBounds(jFrame.getWidth()-17, 2, 15,15);
	  jFrame.getContentPane().add(cloesButton);
	
      final JFXPanel jFXPanel3 = getPanel("");  
       jFrame.setVisible(true);
      
      Platform.setImplicitExit(false);
       Platform.runLater(new Runnable(){
            @Override
            public void run() {
            	  try {
					initFxLater(jFXPanel3,"","");
					   String text;ResultSet result=null;
					   Class.forName("com.mysql.jdbc.Driver");
					   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
                       result=con.prepareStatement("SELECT * FROM `twitter` ORDER BY `No`  DESC").executeQuery();
					   
					String Otext;
					int size=0;
					 int i;
					 
		               for (i=0;result.next() && i<25;i++) 
		                  {
		            	   text=URLDecoder.decode(URLDecoder.decode(result.getString("Content"),"UTF-8"),"UTF-8");
		          	       size=text.length();
		          	       size=size/4;
		          	  	   Otext=text.substring(0,size)+"\n"+text.substring(size+1,2*size)+"\n"+text.substring(2*size+1,3*size)+"\n"+text.substring(3*size+1,4*size)+"\n";
		          	       initFxLater(getPanel("C:\\Alberto\\Interface\\Twitter\\ed.jpg"),"C:\\Alberto\\Interface\\Twitter\\ed.jpg",Otext);
	            		   size=0;
	            		   }
            	con.close(); } catch (Exception e) {new handleExceptions(e);
            	 new handleExceptions(e);}
              }
        });
    }

//****************************************************************************************************************************//
private  void initFxLater(JFXPanel panel,String path,String text)
{
  File file = new File(path);
  Image image = new Image(file.toURI().toString(),270,100,false,true);
  DropShadow ds1 = new DropShadow();
  ds1.setOffsetY(4.0f);
  ds1.setOffsetX(4.0f);

  Group root = new Group();
  Scene scene = new Scene(root);
    final ImageView  chart = new ImageView();
    chart.setImage(image);
    chart.setEffect(ds1);
  
    Text tv=new Text();
    tv.setText(text);
    tv.setX(chart.getX()+26);
    tv.setY(chart.getY()+26);
    
    root.getChildren().add(chart);
    root.getChildren().add(tv);
    
    scene.setFill(null);
    panel.setScene(scene);
}
private JFXPanel getPanel(String path)
{  
    final  JFXPanel jFXPanel = new JFXPanel();
	jFXPanel.setOpaque(false);
    jFXPanel.setBounds(randomGenerator.nextInt(x-250),randomGenerator.nextInt(y-120),300,110);
    jFXPanel .addMouseListener(setPos(jFXPanel,path));
    jFXPanel.addMouseMotionListener(setPos(jFXPanel,path));
    jFrame.getContentPane().add(jFXPanel);
	return jFXPanel;
	}
private	MouseAdapter setPos(final JFXPanel comp,final String path){
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
		  public void mouseClicked(MouseEvent e) {
		     }

		  @Override
		  public void mouseDragged(MouseEvent e) {
		      if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
		    	  comp.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
		      }
		  }
		};
return mouseListener2;
}

}

