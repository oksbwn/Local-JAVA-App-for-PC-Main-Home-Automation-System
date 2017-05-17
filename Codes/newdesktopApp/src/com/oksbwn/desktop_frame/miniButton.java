package com.oksbwn.desktop_frame;
/*
 * Creates buttons for the DesktopFrame 
 * */

import java.awt.Toolkit;
import java.io.File;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.SequentialTransitionBuilder;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class miniButton {	
	SequentialTransition transitionForward ;
	 SequentialTransition transitionBackward ;
	public void initFxLater(JFXPanel panel,String imageFile){
		    File file = new File("c:\\Alberto\\Interface\\deskFrameImages\\"+imageFile+".png");
		    Image image = new Image(file.toURI().toString(),23,20,false,true);
		    ImageView imageView = new ImageView(image);
		    transitionForward = createTransition(imageView, image);
		    transitionBackward = createTransition(imageView,image); 

	        final Tooltip tooltip = new Tooltip(imageFile);
	        tooltip.setFont(new Font("Arial",12));
		    
	        Button button = new Button("",imageView);
	        button.setTooltip(tooltip);
	        button.setContentDisplay(ContentDisplay.CENTER);
	        button.addEventFilter(MouseEvent.MOUSE_ENTERED, new MyEventHandler());
            Scene scene  = new Scene(button,20,20);
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

