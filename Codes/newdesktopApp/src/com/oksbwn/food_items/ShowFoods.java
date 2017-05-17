package com.oksbwn.food_items;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.oksbwn.popUp.PopMe;
import com.oksbwn.server_activity.SendData;
import com.oksbwn.voiceEnable.Voice;

public class ShowFoods {
	JFrame frame= new JFrame();
	JLabel close= new JLabel("X");
	static Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	static int x=gh.width;
	static int y=gh.height; 
	Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());
	private int xTemp=0;
	private int tempY=0;
	int i=0;
	String foods = "";
	SendData sd= new SendData();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		new ShowFoods().getFoodTaken("dinner");
	}
	public void  getFoodTaken(final String what) throws Exception{
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(false);
		frame.setBackground(new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(),Color.BLACK.getBlue(),1));
		frame.setType(javax.swing.JFrame.Type.UTILITY); 
		frame.setBounds(toolHeight.left,0,x-toolHeight.left,y);
		frame.getContentPane().setLayout(null);
		
		close.setBounds(frame.getWidth()-20,5,15,15);
		close.setForeground(Color.GREEN);
		frame.getContentPane().add(close);
		//Server Communication to get food lists
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getFoodNamesFromDatabase.php",new String[]{"TYPE"}, new String[]{what}));
		final JSONArray json=(JSONArray)obj;
		
		final JEditorPane[] pane=new JEditorPane[json.toArray().length+2];
		for(i=0;i<(json.toArray().length+2);i++){
			 pane[i]= new JEditorPane();
			 pane[i].setContentType("text/html");
			 if(i==json.toArray().length ){
				 URL url =new File("C:/Alberto/desktopApp/icons/add.jpg").toURI().toURL();
				 pane[i].setText("<html><img src="+url+" width=\""+frame.getWidth()/11+"\" height=\""+((frame.getHeight()/7)-25)+"\"></img><br><b><i>Add Food Name</i></b></html>");
			 
	
			 }
			 else if(i==json.toArray().length+1){
				 URL url =new File("C:/Alberto/desktopApp/icons/save.png").toURI().toURL();
				 pane[i].setText("<html><img src="+url+" width=\""+frame.getWidth()/11+"\" height=\""+((frame.getHeight()/7)-25)+"\"></img><br><b>Save</b></html>");
			 
	 
			 }
			 else{
				 JSONObject objData= (JSONObject) json.get(i);
				 URL url =new File("C:/Alberto/desktopApp/icons/"+objData.get("image")+".jpg").toURI().toURL();
				 pane[i].setText("<html><img src="+url+" width=\""+frame.getWidth()/11+"\" height=\""+((frame.getHeight()/7)-25)+"\"></img><br><b><i>"+objData.get("food")+"</i></b>"+"  "+objData.get("calorie")+"</html>");
			 
			 }
			pane[i].setBounds((frame.getWidth()/99)*tempY+((frame.getWidth()/11)*tempY),frame.getHeight()/24+xTemp,frame.getWidth()/11,frame.getHeight()/6);
			if((x-((frame.getWidth()/99)*(tempY-1)+((frame.getWidth()/11)*(tempY))))<(2.5*(frame.getWidth()/11+frame.getWidth()/99))){
				xTemp=xTemp+(frame.getHeight()/7)+frame.getHeight()/24;
				tempY=-1;
			}
			tempY++;
			frame.getContentPane().add(pane[i]);
			pane[i].setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black));
			pane[i].addMouseListener(new MouseAdapter() {
				int x=i;
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					pane[x].setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.black));
	
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					pane[x].setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.red));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(x==json.toArray().length+1){
						new PopMe("Daily Stats", "Added "+what, "ok", false);
						new Voice("Sir i have added "+what+" to the database.");
						frame.dispose();
		        		try {
							sd.sendPost("http://192.168.0.1/smart_home/API/desktopApp/getParameterFromDailyStatsIfInserted.php",
										new String[]{"TYPE","PARA","VAL"}, new String[]{"Update",what,foods.substring(1)});
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        		}
					else if(x==json.toArray().length){
		        		try {
		        			foods=foods+JOptionPane.showInputDialog("Enter Food Not in Database");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        		}
					else{
						JSONObject jo=(JSONObject)json.get(x);
						new PopMe("Daily Stats", "Added food "+jo.get("food"), "ok", false);
						foods=foods+", "+jo.get("food");
						}
				}
			});
		}
		
		frame.setVisible(true);
		close.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				close.setForeground(Color.GREEN);	}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				close.setForeground(Color.RED);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		
	}
}
