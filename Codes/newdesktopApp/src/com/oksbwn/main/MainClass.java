package com.oksbwn.main;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.plaf.metal.MetalIconFactory;

import com.oksbwn.add_quickies.AddNote;
import com.oksbwn.desktop_frame.DesktopFrame;
import com.oksbwn.periodic_updates.CheckForDailyStatusEveryOneHour;
import com.oksbwn.periodic_updates.CheckForNewEMailEveryOneHour;
import com.oksbwn.periodic_updates.CheckForNewTweetsEveryOneHour;
import com.oksbwn.voiceEnable.Voice;

public class MainClass {
	static TrayIcon icon = new TrayIcon(getImage(),"OKSBWN My Assistant",createPopupMenu());
	public static void main(String[] args) throws AWTException, InterruptedException {
		backgroundOperations();
		SystemTray.getSystemTray().add(icon);
		Thread.sleep(3000);
		icon.displayMessage("Alberto","Running",TrayIcon.MessageType.INFO);
	}
	private static void backgroundOperations() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				new CheckForNewTweetsEveryOneHour();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {

				new CheckForNewEMailEveryOneHour();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				new CheckForDailyStatusEveryOneHour();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {	try {
				new DesktopFrame();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}).start();
	
		icon.addActionListener(new ActionListener() 
			{    
				public void actionPerformed(ActionEvent e) { 
				}});  
	}
	private static Image getImage() throws HeadlessException 
	{  
		Icon defaultIcon = MetalIconFactory.getFileChooserHomeFolderIcon(); 
		Image img = new BufferedImage(defaultIcon.getIconWidth(),defaultIcon.getIconHeight(),BufferedImage.TYPE_4BYTE_ABGR);
		defaultIcon.paintIcon(new Panel(), img.getGraphics(), 0, 0);   
		return img;
	}  
	private static PopupMenu createPopupMenu() 
	{ 
		PopupMenu menu = new PopupMenu();  
		MenuItem exit = new MenuItem("Exit");  
		MenuItem note = new MenuItem("Note"); 
		MenuItem ImGal = new MenuItem("ImGal");
		exit.addActionListener(new ActionListener() 
		{   
			public void actionPerformed(ActionEvent e) 
			{
				new ClassCalledWhenClosingApp();
				new Voice("Sir its a pleasure to work with you.");
				System.exit(0);
		}});
		note.addActionListener(new ActionListener() 
		{   
			public void actionPerformed(ActionEvent e) 
			{ 
				new AddNote();
		}});
		ImGal.addActionListener(new ActionListener() 
		{   
			public void actionPerformed(ActionEvent e) 
			{
				//mainGalleryMenu sl=new mainGalleryMenu();
				//sl.LoginFunc();
		}});  
		
		menu.add(ImGal);
		menu.add(note);
		// menu.add(Exp);
		menu.add(exit);
		return menu;
	}
}