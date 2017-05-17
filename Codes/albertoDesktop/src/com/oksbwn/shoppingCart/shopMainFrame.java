
/**Display the main Interface for the Shopping cart
 * **/
package com.oksbwn.shoppingCart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.alberto.main.fxPanelImage;
import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.voiceEnable.Voice;

public class shopMainFrame {

	JFrame jFram=new JFrame();
	Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    Random randomGenerator = new Random();
	public static void main(String[] args) {
		new shopMainFrame().showFrame();
	}
public void showFrame(){
	jFram.addMouseListener(mouseListener);
	jFram.setLayout(null);
	jFram.addMouseMotionListener(mouseListener);
	jFram.setUndecorated(true);
	jFram.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),1));
	((JComponent)jFram.getContentPane()).setBorder(    
	        BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );
	jFram.setType(javax.swing.JFrame.Type.UTILITY);
	jFram.setBounds((gh.width/2)-250,(gh.height/2)-250,500,500);   

	final JLabel cloesButton = new JLabel("X");
	cloesButton.setForeground(Color.white);
	cloesButton.setToolTipText("Close");
	cloesButton.addMouseListener(new MouseAdapter() {
	  	@Override
	  	public void mouseClicked(MouseEvent arg0) {
	  		jFram.dispose();
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
	cloesButton.setBounds(jFram.getWidth()-15, 2, 15,15);
	jFram.getContentPane().add(cloesButton);
	
	final JFXPanel addToCart = new JFXPanel();
	addToCart.setForeground(Color.red);
	addToCart.setToolTipText("Add New Item to Cart");
	addToCart.setOpaque(false);
	addToCart.setBounds(jFram.getWidth()-100,jFram.getHeight()-100,100,100);
	jFram.getContentPane().add(addToCart);
	   
	  final JFXPanel jFXPanel3 = getPanel("");  
	  jFram.setVisible(true);
     
     Platform.setImplicitExit(false);
      Platform.runLater(new Runnable(){
           @Override
           public void run() {
           	  try {
					initFxLater(jFXPanel3,"","");
					   String text;ResultSet result=null;
					   Class.forName("com.mysql.jdbc.Driver");
					   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
                      result=con.prepareStatement("SELECT * FROM `shoppinglist` WHERE `Brought` LIKE '%No%'ORDER BY `Sl_No`  DESC").executeQuery();
					   
					int i;
					 
		               for (i=0;result.next() && i<25;i++) 
		                  {
		            	   text=result.getString("Name");
		          	      initFxLater(getPanel(result.getString("Sl_No")),"C:\\Alberto\\Interface\\Cart\\bag.png",text);
	            		   }
           	con.close(); } catch (Exception e) {new handleExceptions(e);
           	 new handleExceptions(e);
           	 e.printStackTrace();}
             }
       });
	jFram.setVisible(true);
	
	
	//......................................FxPanel Codes..........
	jFram.setVisible(true); 
	   Platform.setImplicitExit(false);
	   Platform.runLater(new Runnable(){
	        @Override
	        public void run() {
	            new fxPanelImage().initFxLater(addToCart,"shoppingCartCartImage");
	        }
	    });
	   //---------------------Click Handlers--------------------------
	   addToCart.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			 Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
		     if (runnable != null)
		         runnable.run();
				new shopList().toShopList();
		}
	});
	   
}






////Other Codes

private  void initFxLater(JFXPanel panel,String path,String text)
{
  File file = new File(path);
  Image image = new Image(file.toURI().toString(),100,50,false,true);
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
    javafx.scene.text.Font fnt=new javafx.scene.text.Font(Font.SANS_SERIF,20);
    tv.setEffect(ds1);
    tv.setFill(javafx.scene.paint.Color.RED);
    tv.setFont(fnt);
    tv.setX(chart.getX()+26);
    tv.setY(chart.getY()+26);

    root.getChildren().add(chart);
    root.getChildren().add(tv);
    
    scene.setFill(null);
    panel.setScene(scene);
}
private JFXPanel getPanel(String Sl)
{  
    final  JFXPanel jFXPanel = new JFXPanel();
	jFXPanel.setOpaque(false);
    jFXPanel.setBounds(randomGenerator.nextInt(jFram.getWidth()-100),randomGenerator.nextInt(jFram.getHeight()-50),100,50);
    jFXPanel .addMouseListener(setPos(jFXPanel,Sl));
    jFXPanel.addMouseMotionListener(setPos(jFXPanel, Sl));
    jFram.getContentPane().add(jFXPanel);
	return jFXPanel;
	}

final  MouseAdapter mouseListener = new MouseAdapter() {
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
	    	  jFram. setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
	      }
	  }
	};
	
	private	MouseAdapter setPos(final JFXPanel comp,final String sl){
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
					int x=  JOptionPane.showConfirmDialog(null, "Want to remove this item form List ?");
					if(x==0)
					{
						//DELETE FROM `alberto`.`shoppinglist` WHERE `shoppinglist`.`Sl_No` = 7"
						try {
							   Class.forName("com.mysql.jdbc.Driver");
							   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
							con.prepareStatement("UPDATE `shoppinglist` SET `Brought` = 'Yes' WHERE `Sl_No` ="+sl).executeUpdate();
							new Voice("Sir i have removed the item from the list");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						   
					}
				     }

				  @Override
				  public void mouseDragged(MouseEvent e) {
				      if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
				    	  comp.setLocation( e.getYOnScreen()-jFram.getLocation().x- x, e.getYOnScreen()-jFram.getLocation().y - y);
				      }
				  }
				};
		return mouseListener2;
		}
}
