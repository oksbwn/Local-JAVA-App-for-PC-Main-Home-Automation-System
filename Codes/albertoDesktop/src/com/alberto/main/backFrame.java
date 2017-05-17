package com.alberto.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class backFrame {
	JFrame jFrame=new JFrame();
	 static Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	 static int x=gh.width;
	 static int y=gh.height; 
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
new backFrame();
	}
	backFrame(){
		
		jFrame.setUndecorated(true);
	  	jFrame.setAlwaysOnTop(true);
	  	jFrame.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),1));
	  	jFrame.setType(javax.swing.JFrame.Type.UTILITY);
		Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(jFrame.getGraphicsConfiguration());// height of the task bar  
	    jFrame.setBounds(toolHeight.left,0,x-toolHeight.left,y);
	    
	   final JFXPanel toShopCart= new JFXPanel();
	   toShopCart.setOpaque(false);
	   toShopCart.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
	   jFrame.getContentPane().add(toShopCart);
		   
	   jFrame.setVisible(true); 
		Platform.setImplicitExit(false);
		Platform.runLater(new Runnable(){
        @Override
        public void run() {
            initFxLater(toShopCart,"bank",jFrame.getWidth(),jFrame.getHeight());
    }
});
	   }
	public void close(){
		this.jFrame.dispose();
	}
	public void initFxLater(JFXPanel panel,String imageFile,int width,int height){
			    File file = new File("c:\\Alberto\\Interface\\back.jpg");
			    Image image = new Image(file.toURI().toString(),width,height,false,true);
			    

			    Group root = new Group();
			    Scene scene = new Scene(root);
		        final ImageView  imageView = new ImageView();
		        imageView.setImage(image);
	            
			      root.getChildren().add(imageView);
			   //   Text tv = new Text("GOOF");
				//root.getChildren().add(tv);
			      
			      scene.setFill(null);
			      panel.setScene(scene);
	            scene.setFill(null);
	            panel.setScene(scene);
	            
	    }

}
