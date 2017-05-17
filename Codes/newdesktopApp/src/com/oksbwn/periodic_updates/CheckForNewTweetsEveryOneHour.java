package com.oksbwn.periodic_updates;

import com.oksbwn.social_networks.AddTweetsToDatabase;

public class CheckForNewTweetsEveryOneHour extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckForNewTweetsEveryOneHour();
	}
	public CheckForNewTweetsEveryOneHour(){
		start();
	}
	public void run(){
		while(true){
			try{
				new AddTweetsToDatabase();
				Thread.sleep(3600*1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
