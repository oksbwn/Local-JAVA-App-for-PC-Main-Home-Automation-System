package com.oksbwn.main;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import com.oksbwn.popUp.PopMe;
import com.oksbwn.server_activity.SendData;
import com.oksbwn.system_interactions.OsLoginTime;

/*
* /*
* Author :Bikash Narayan Panda
* Date: 08/Jul/2015
* *
* API: http:192.168.0.1/smart_home/API/desktopApp/saveLoginTime.php
* */
public class ClassCalledWhenClosingApp  {
	public static void main(String[] args) throws Exception{
		new ClassCalledWhenClosingApp();
	}
	public ClassCalledWhenClosingApp() {
		Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
		if (runnable != null)
			runnable.run();

		Object[] choices = {"Exit", "No"};
		Object[] choices2 = {"Shutdown", "Continue"};
		
		Object defaultChoice = choices[0];
		int v=JOptionPane.showOptionDialog(null,
	             "Want to exit Alberto ?",
	             "Alberto",
	             JOptionPane.YES_NO_OPTION,
	             JOptionPane.QUESTION_MESSAGE,
	             null,
	             choices,
	             defaultChoice);
		if (v==0){
			int shutDownOption=JOptionPane.showOptionDialog(null,
		             "Interested in shutdown PC ?",
		             "Alberto",
		             JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE,
		             null,
		             choices2,
		             defaultChoice);
			if (shutDownOption==0){
				try {
					double x = OsLoginTime.getSystemUptime();
					new SendData().sendPost("http://192.168.0.1/smart_home/API/desktopApp/saveLoginTime.php",
					new String[]{"TIME"}, new String[]{""+x/(3600*1000)});
					
					Runtime rt = Runtime.getRuntime();   
					rt.exec("shutdown -s");//s for shutdown r restart
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(v==1)
			{
				try {
					System.exit(0);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else if(v==1)
		{
			new PopMe("Nice to get you back.", "Thank  you.", "ok",false);
		}			
	}
}