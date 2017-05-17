/**By:Bikash narayan panda
 * This iss the main panle showing Diofferent Icons to the User
 * **/
package com.alberto.main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.Fbook.FacebookNotifications;
import com.oksbwn.Y2014.newProduct.MainClassNewProduct;
import com.oksbwn.Y2014.newProduct.showProduct;
import com.oksbwn.Y2014.twitter.newMessageBox;
import com.oksbwn.cricket.cricScore;
import com.oksbwn.currencyRate.YahooCurrencyConverter;
import com.oksbwn.dailyRoutines.AddRScheduleToDB;
import com.oksbwn.dailyRoutines.showSchedulesFromDb;
import com.oksbwn.mail.ReadMailSample;
import com.oksbwn.mail.SendMail;
import com.oksbwn.quickNotes.addQuickies;
import com.oksbwn.quickNotes.showFromDb;
import com.oksbwn.setReminder.AddReminderToDB;
import com.oksbwn.setReminder.showReminderFromDb;
import com.oksbwn.shoppingCart.shopMainFrame;

public class mainWindowFrame{ 
    static Dimension gh=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    static int x=gh.width;
	static int y=gh.height; 
	int widgetWidth=(x-110)/8;
	int widgetHeight=(y-110)/8;
	JFrame jFrame = new JFrame();  
	backFrame bf=new backFrame();
public static void main(String[] args) {new mainWindowFrame();}

public mainWindowFrame(){
  	jFrame.addMouseListener(mouseListener);
  	jFrame.setLayout(null);
  	jFrame.addMouseMotionListener(mouseListener);
  	jFrame.setUndecorated(true);
  	jFrame.setAlwaysOnTop(true);
  	jFrame.setBackground(new Color(Color.white.getRed(), Color.white.getGreen(),Color.white.getBlue(),1));
  	jFrame.setType(javax.swing.JFrame.Type.UTILITY);
	Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(jFrame.getGraphicsConfiguration());// height of the task bar  
    jFrame.setBounds(toolHeight.left,0,x-toolHeight.left,y);
    
    final  JLabel cloesButton = new JLabel("X");
  	cloesButton.setForeground(Color.red);
  	cloesButton.addMouseListener(new MouseAdapter() {
  	    @Override
  	    public void mouseClicked(MouseEvent arg0) {
  	    	jFrame.dispose();
  	    	bf.close();
  	    }});
   cloesButton.setBounds(jFrame.getWidth()-30,5, 15,15);
   jFrame.getContentPane().add(cloesButton);
  
   final JFXPanel fxPBank = new JFXPanel();
   fxPBank.setForeground(Color.red);
   fxPBank.setToolTipText("All Bank Transactions");
   fxPBank.setOpaque(false);
   fxPBank.setBounds(20,20,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPBank);
   
   final JFXPanel fxPBirthday = new JFXPanel();
   fxPBirthday.setToolTipText("Add or look birthdays");
   fxPBirthday.setForeground(Color.red);
   fxPBirthday.setOpaque(false);
   fxPBirthday.setBounds(widgetWidth+30,20,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPBirthday);
   
   final JFXPanel fxPCharts = new JFXPanel();
   fxPCharts.setToolTipText("View Charts");
   fxPCharts.setForeground(Color.red);
   fxPCharts.setOpaque(false);
   fxPCharts.setBounds(2*widgetWidth+40,20,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPCharts);
   
   final JFXPanel fxPCricket = new JFXPanel();
   fxPCricket.setToolTipText("Follow India Match");
   fxPCricket.setForeground(Color.red);
   fxPCricket.setOpaque(false);
   fxPCricket.setBounds(3*widgetWidth+50,20,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPCricket);
   
   final JFXPanel fxPCurrency = new JFXPanel();
   fxPCurrency.setToolTipText("Convert to rupees");
   fxPCurrency.setForeground(Color.red);
   fxPCurrency.setOpaque(false);
   fxPCurrency.setBounds(4*widgetWidth+60,20,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPCurrency);
   
   final JFXPanel fxPDaily = new JFXPanel();
   fxPDaily.setToolTipText("Add a daily Schedule");
   fxPDaily.setForeground(Color.red);
   fxPDaily.setOpaque(false);
   fxPDaily.setBounds(5*widgetWidth+70,20,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPDaily);
   
   final JFXPanel fxPFbook = new JFXPanel();
   fxPFbook.setToolTipText("Get Latest feeds from Facebook");
   fxPFbook.setForeground(Color.red);
   fxPFbook.setOpaque(false);
   fxPFbook.setBounds(6*widgetWidth+80,20,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPFbook);
   
   final JFXPanel fxPGoolge = new JFXPanel();
   fxPGoolge.setToolTipText("Search something on GOOOOGLE");
   fxPGoolge.setForeground(Color.red);
   fxPGoolge.setOpaque(false);
   fxPGoolge.setBounds(7*widgetWidth+90,20,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPGoolge);
   
   final JFXPanel fxPIdeas = new JFXPanel();
   fxPIdeas.setToolTipText("Add if you have new Idea");
   fxPIdeas.setForeground(Color.red);
   fxPIdeas.setOpaque(false);
   fxPIdeas.setBounds(20,1*widgetHeight+30,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPIdeas);
   
   final JFXPanel fxPMail = new JFXPanel();
   fxPMail.setToolTipText("View Latest mails");
   fxPMail.setForeground(Color.red);
   fxPMail.setOpaque(false);
   fxPMail.setBounds(1*widgetWidth+30,1*widgetHeight+30,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPMail);
   
   final JFXPanel fxPMessage = new JFXPanel();
   fxPMessage.setToolTipText("Send message through mobile");
   fxPMessage.setForeground(Color.red);
   fxPMessage.setOpaque(false);
   fxPMessage.setBounds(2*widgetWidth+40,1*widgetHeight+30,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPMessage);
   
   final JFXPanel fxPMovie = new JFXPanel();
   fxPMovie.setToolTipText("Add watched movie");
   fxPMovie.setForeground(Color.red);
   fxPMovie.setOpaque(false);
   fxPMovie.setBounds(3*widgetWidth+50,1*widgetHeight+30,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPMovie);
   
   final JFXPanel fxPNotes = new JFXPanel();
   fxPNotes.setToolTipText("Add new notes, post to FB or Twitter");
   fxPNotes.setForeground(Color.red);
   fxPNotes.setOpaque(false);
   fxPNotes.setBounds(4*widgetWidth+60,1*widgetHeight+30,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPNotes);
   
   final JFXPanel fxPPhone = new JFXPanel();
   fxPPhone.setToolTipText("Add or view phone nos");
   fxPPhone.setForeground(Color.red);
   fxPPhone.setOpaque(false);
   fxPPhone.setBounds(5*widgetWidth+70,1*widgetHeight+30,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPPhone);
   
   final JFXPanel fxPRecharge = new JFXPanel();
   fxPRecharge.setToolTipText("Add mobile recharge done");
   fxPRecharge.setForeground(Color.red);
   fxPRecharge.setOpaque(false);
   fxPRecharge.setBounds(6*widgetWidth+80,1*widgetHeight+30,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPRecharge);
   
   final JFXPanel fxPReminder = new JFXPanel();
   fxPReminder.setToolTipText("Add a reminder");
   fxPReminder.setForeground(Color.red);
   fxPReminder.setOpaque(false);
   fxPReminder.setBounds(7*widgetWidth+90,1*widgetHeight+30,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPReminder);
   
   final JFXPanel fxPTravel = new JFXPanel();
   fxPTravel.setToolTipText("Add new place Visited");
   fxPTravel.setForeground(Color.red);
   fxPTravel.setOpaque(false);
   fxPTravel.setBounds(0*widgetWidth+20,2*widgetHeight+40,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPTravel);
   
   final JFXPanel fxPTwitter = new JFXPanel();
   fxPTwitter.setToolTipText("See Latest Tweets");
   fxPTwitter.setForeground(Color.red);
   fxPTwitter.setOpaque(false);
   fxPTwitter.setBounds(1*widgetWidth+30,2*widgetHeight+40,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPTwitter);  
   
   final JFXPanel fxPSendMail = new JFXPanel();
   fxPSendMail.setToolTipText("Send new mail using GMAIL");
   fxPSendMail.setForeground(Color.red);
   fxPSendMail.setOpaque(false);
   fxPSendMail.setBounds(2*widgetWidth+40,2*widgetHeight+40,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPSendMail);
   
   final JFXPanel fxPFacebookWork = new JFXPanel();
   fxPFacebookWork.setToolTipText("Do all Facebook Stuffs");
   fxPFacebookWork.setForeground(Color.red);
   fxPFacebookWork.setOpaque(false);
   fxPFacebookWork.setBounds(3*widgetWidth+50,2*widgetHeight+40,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPFacebookWork);
   
   final JFXPanel fxPSearchBoughtItem = new JFXPanel();
   fxPSearchBoughtItem.setToolTipText("Search for brought Item");
   fxPSearchBoughtItem.setForeground(Color.red);
   fxPSearchBoughtItem.setOpaque(false);
   fxPSearchBoughtItem.setBounds(4*widgetWidth+60,2*widgetHeight+40,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPSearchBoughtItem);
   
   final JFXPanel fxPaddNewItem = new JFXPanel();
   fxPaddNewItem.setToolTipText("Add new Brought Item");
   fxPaddNewItem.setForeground(Color.red);
   fxPaddNewItem.setOpaque(false);
   fxPaddNewItem.setBounds(5*widgetWidth+70,2*widgetHeight+40,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPaddNewItem);
   
   final JFXPanel fxPSeeNotes = new JFXPanel();
   fxPSeeNotes.setToolTipText("See added Notes");
   fxPSeeNotes.setForeground(Color.red);
   fxPSeeNotes.setOpaque(false);
   fxPSeeNotes.setBounds(6*widgetWidth+80,2*widgetHeight+40,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPSeeNotes);
   
   final JFXPanel fxPseeSchedule = new JFXPanel();
   fxPseeSchedule.setToolTipText("See Schedules for PArticular Day");
   fxPseeSchedule.setForeground(Color.red);
   fxPseeSchedule.setOpaque(false);
   fxPseeSchedule.setBounds(7*widgetWidth+90,2*widgetHeight+40,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPseeSchedule);
   
   final JFXPanel fxPSeeIdeas = new JFXPanel();
   fxPSeeIdeas.setToolTipText("See new Ideas");
   fxPSeeIdeas.setForeground(Color.red);
   fxPSeeIdeas.setOpaque(false);
   fxPSeeIdeas.setBounds(0*widgetWidth+20,3*widgetHeight+50,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPSeeIdeas);
   
   final JFXPanel fxPSeeReminders = new JFXPanel();
   fxPSeeReminders.setToolTipText("See Set Remindes");
   fxPSeeReminders.setForeground(Color.red);
   fxPSeeReminders.setOpaque(false);
   fxPSeeReminders.setBounds(1*widgetWidth+30,3*widgetHeight+50,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPSeeReminders);
   
   final JFXPanel fxPAddPersonDetails= new JFXPanel();
   fxPAddPersonDetails.setToolTipText("add new Visiting Cards");
   fxPAddPersonDetails.setForeground(Color.red);
   fxPAddPersonDetails.setOpaque(false);
   fxPAddPersonDetails.setBounds(2*widgetWidth+40,3*widgetHeight+50,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxPAddPersonDetails);  
   
   final JFXPanel toShopCart= new JFXPanel();
   toShopCart.setToolTipText("Add item you wish to purchase");
   toShopCart.setForeground(Color.red);
   toShopCart.setOpaque(false);
   toShopCart.setBounds(3*widgetWidth+50,3*widgetHeight+50,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(toShopCart);
   
   final JFXPanel fxpImageGallery= new JFXPanel();
   fxpImageGallery.setToolTipText("Add item you wish to purchase");
   fxpImageGallery.setForeground(Color.red);
   fxpImageGallery.setOpaque(false);
   fxpImageGallery.setBounds(4*widgetWidth+60,3*widgetHeight+50,widgetWidth,widgetHeight);
   jFrame.getContentPane().add(fxpImageGallery);
   
   
   
   jFrame.setVisible(true); 
   Platform.setImplicitExit(false);
   Platform.runLater(new Runnable(){
        @Override
        public void run() {
            new fxPanelImage().initFxLater(fxPBank,"bank");
            new fxPanelImage().initFxLater(fxPBirthday,"birthday");
            new fxPanelImage().initFxLater(fxPCharts,"charts");
            new fxPanelImage().initFxLater(fxPCricket,"cricket");
            new fxPanelImage().initFxLater(fxPCurrency,"currency");
            new fxPanelImage().initFxLater(fxPDaily,"daily");
            new fxPanelImage().initFxLater(fxPFbook,"facebookfeeds");
            new fxPanelImage().initFxLater(fxPGoolge,"google");
            new fxPanelImage().initFxLater(fxPIdeas,"ideas");
            new fxPanelImage().initFxLater(fxPMail,"mail");
            new fxPanelImage().initFxLater(fxPMessage,"message");
            new fxPanelImage().initFxLater(fxPMovie,"movie");
            new fxPanelImage().initFxLater(fxPNotes,"notes");
            new fxPanelImage().initFxLater(fxPPhone,"phone");
            new fxPanelImage().initFxLater(fxPRecharge,"recharge");
            new fxPanelImage().initFxLater(fxPReminder,"reminder");
            new fxPanelImage().initFxLater(fxPTravel,"travel");
            new fxPanelImage().initFxLater(fxPSendMail,"sendMail");
            new fxPanelImage().initFxLater(fxPFacebookWork,"facebook");
            new fxPanelImage().initFxLater(fxPaddNewItem,"shoping");
            new fxPanelImage().initFxLater(fxPSeeNotes,"seeNotes");
            new fxPanelImage().initFxLater(fxPseeSchedule,"seeSchedules");
            new fxPanelImage().initFxLater(fxPSeeIdeas,"seeIdeas");
            new fxPanelImage().initFxLater(fxPSeeReminders,"seereminders");
            new fxPanelImage().initFxLater(fxPSearchBoughtItem,"seeShoping");
            new fxPanelImage().initFxLater(fxPAddPersonDetails,"visiting");
            new fxPanelImage().initFxLater(fxPTwitter,"twitter");
            new fxPanelImage().initFxLater(toShopCart,"shoppingCartCartImage");
            new fxPanelImage().initFxLater(fxpImageGallery,"imageGallery");
        }
    });

///----------------------------------------------------Click Handlers------------------------------------------------------------------
   fxPBank.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jFrame.dispose();
		}
	});
   fxPBirthday.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jFrame.dispose();
		}
	});
   fxPCharts.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			jFrame.dispose();
		}
	});
   fxPCricket.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
	    	  cricScore reader = new cricScore(); 
			  reader.goCricket();
			jFrame.dispose();
		}
	});
   fxPCurrency.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			YahooCurrencyConverter gh=new YahooCurrencyConverter();
			gh.convertToRs();
			jFrame.dispose();
		}
	});
   fxPDaily.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			 new AddRScheduleToDB();
			jFrame.dispose();
		}
	});
   fxPFbook.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			new fbNotThread(); 
			
			jFrame.dispose();
		}
	});
   fxPGoolge.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			new googleThread();
			
			jFrame.dispose();
		}
	});
   fxPIdeas.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jFrame.dispose();
		}
	});
   fxPMail.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			   new mailReadThread();
			
			jFrame.dispose();
		}
	});
   fxPMessage.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			jFrame.dispose();
		}
	});
   fxPMovie.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			new movieClickedThread();
			jFrame.dispose();
		}
	});
   fxPNotes.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			addQuickies event=new addQuickies();
			event.addNote();
			jFrame.dispose();
		}
	});
   fxPPhone.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jFrame.dispose();
		}
	});
   fxPRecharge.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jFrame.dispose();
		}
	});
   fxPReminder.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			new AddReminderToDB();
			jFrame.dispose();
		}
	});
   fxPTravel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {

			jFrame.dispose();
		}
	});
   fxPFacebookWork.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jFrame.dispose();
		}
	});
   fxPaddNewItem.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			new MainClassNewProduct().addNewProducts(0);
			jFrame.dispose();
		}
	});
   fxPSeeNotes.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		showFromDb sfD=new showFromDb();
        String item=JOptionPane.showInputDialog("Search for.");
        try {
			sfD.DbConnAndExe("SELECT * FROM `notes` WHERE `Note` LIKE '%"+item+"%'ORDER BY `notes`.`Sl_No`  DESC", "bikash");
		} catch (Exception e) {new handleExceptions(e);} 
			jFrame.dispose();
		}
	});
   fxPSearchBoughtItem.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			new showProduct().showBaby();
			jFrame.dispose();
		}
	});
   fxPseeSchedule.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jFrame.dispose();
			 new showSchedulesFromDb();
		}
	});
   fxPSeeIdeas.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			new newMessageBox();
			jFrame.dispose();
		}
	});
   fxPSeeReminders.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
            try {
				new showReminderFromDb();
			} catch (Exception e) {new handleExceptions(e);} 
			jFrame.dispose();
		}
	});
   fxPAddPersonDetails.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jFrame.dispose();
		}
	});
   fxPSendMail.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			SendMail send=new SendMail();
			send.SendMailTo();
			jFrame.dispose();
		}
	});
   fxPTwitter.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jFrame.dispose();
			new newMessageBox();
		}
	});
   toShopCart.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			jFrame.dispose();
			new shopMainFrame().showFrame();
		}
	});
   fxpImageGallery.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
				jFrame.dispose();
		}
	}); 
}

///---------------------------Other Codes----------------------------------------------------------------------------------------------------------
class movieClickedThread extends Thread {
	movieClickedThread() { start(); }
    public void run() {
    	//String moviename=JOptionPane.showInputDialog("Movie");
    	//getIMDBRating mov=new getIMDBRating();
		//mov.getRating(moviename);
		//new MovieSearchGUI(moviename);//Now Not Working
    }
}	
class fbNotThread extends Thread {
	fbNotThread() { start(); }
    public void run() {
		FacebookNotifications reader = FacebookNotifications.getInstance(); 
         reader.writeNews();  
    }
}	 

class mailReadThread extends Thread {
	mailReadThread() { start(); }
    public void run() {
    	ReadMailSample sample = new ReadMailSample();
    	sample.readMails(0);  
    }
}	   
class googleThread extends Thread {
	googleThread() { start(); }
    public void run() {			
    }
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
	    	  jFrame. setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
	      }
	  }
	};
public static double FreeSpaceInDrive(String drive)
	{	
	double space=0;
	File file = new File(drive+":");
	long totalSpace = file.getTotalSpace(); //total disk space in bytes.
	 space=totalSpace /1024 /1024/1024;
	    	return space;
	    	}
}