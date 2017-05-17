package com.oksbwn.mail;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mailWebView {
public static void main(final String[] args)
    {
     new mailWebView("<b>gadhgfhadgfhjfag</b>");
    }
final  JFrame frame = new JFrame();
private  void initFX(final JFXPanel fxPanel,String content)
    {
   	 WebView webView = new WebView();
   	 webView.setOpacity(.7);
     Scene scene = new Scene(webView,300,frame.getHeight()-100);
     scene.setFill(null);
     fxPanel.setScene(scene);
     WebEngine webEngine = webView.getEngine();
     webEngine.loadContent(content);
    }
 public mailWebView(final String content) {
        frame.getContentPane().setLayout(null);
        frame.setBounds(0,30,600,500);
        frame.setUndecorated(true);
		frame.addMouseListener(mouseListener);
		frame.addMouseMotionListener(mouseListener);
		frame.setType(javax.swing.JFrame.Type.UTILITY);
		frame.setBackground(new Color(Color.black.getRed(), Color.black.getGreen(),Color.black.getBlue(),1));
		((JComponent)frame.getContentPane()).setBorder(    
				BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black ) );

		final JLabel cloesButton = new JLabel("X");
		cloesButton.setForeground(Color.white);
		cloesButton.setToolTipText("Close");
		cloesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				}});
		cloesButton.setSize(15,15);
		cloesButton.setBounds(frame.getWidth()-15,0, 15,15);
		frame.getContentPane().add(cloesButton);
		
        final JFXPanel fxPanel = new JFXPanel();
        fxPanel.setBounds(50,30,frame.getWidth()-100,frame.getHeight()-60);
        frame.add(fxPanel);
        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() { 
            @Override
            public void run() {
					initFX(fxPanel,content); }
        });
        frame.setVisible(true);
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
	        	frame. setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
	        }
	    }
	};
}