/**
 * Shows Image Icons For Device LAn status
 * 
 * */

package com.oksbwn.switchingBoardOne;

import java.awt.Toolkit;
import java.io.File;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.SequentialTransitionBuilder;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class fxPanelImage {	
	SequentialTransition transitionForward ;
	 SequentialTransition transitionBackward ;
	public void initFxLater(JFXPanel panel,String imageFile){
		    File file = new File("c:\\Alberto\\Interface\\loads\\"+imageFile+".png");
		    Image image = new Image(file.toURI().toString(),40,40,false,true);
		    DropShadow ds1 = new DropShadow();
		    ds1.setOffsetY(4.0f);
		    ds1.setOffsetX(4.0f);

		    Group root = new Group();
		    Scene scene = new Scene(root);
	        final ImageView  imageView = new ImageView();
	        imageView.setImage(image);
	        imageView.setEffect(ds1);
		    transitionForward = createTransition(imageView, image);
		    transitionBackward = createTransition(imageView,image); 
            imageView.addEventFilter(MouseEvent.MOUSE_ENTERED, new MyEventHandler());
            
		      root.getChildren().add(imageView);
		   //   Text tv = new Text("GOOF");
			//root.getChildren().add(tv);
		      
		      scene.setFill(null);
		      panel.setScene(scene);
            scene.setFill(null);
            panel.setScene(scene);
            
    }
	
	 class MyEventHandler implements EventHandler<MouseEvent> {

	        @Override
	        public void handle(MouseEvent t) {
	        	final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.asterisk");
				if (runnable != null)
				runnable.run();
	        	 transitionForward.play();
	        	 transitionBackward.play();
	        	 
	        }
	    }
	 SequentialTransition createTransition(final ImageView iv, final Image img){
	        FadeTransition fadeOutTransition
	                        = new FadeTransition(Duration.seconds(1), iv);
	                fadeOutTransition.setFromValue(1.0);
	                fadeOutTransition.setToValue(0.0);
	                fadeOutTransition.setOnFinished(new EventHandler<ActionEvent>(){
	 
	                    @Override
	                    public void handle(ActionEvent arg0) {
	                        iv.setImage(img);;
	                    }
	                     
	                });
	                 
	                FadeTransition fadeInTransition
	                        = new FadeTransition(Duration.seconds(1), iv);
	                fadeInTransition.setFromValue(0.0);
	                fadeInTransition.setToValue(1.0);
	                SequentialTransition sequentialTransition
	                        = SequentialTransitionBuilder
	                        .create()
	                        .children(fadeOutTransition, fadeInTransition)
	                        .build();
	                 
	                return sequentialTransition;
	    }
}
