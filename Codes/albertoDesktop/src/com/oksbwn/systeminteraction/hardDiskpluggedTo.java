package com.oksbwn.systeminteraction;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import com.oksbwn.ErrorHandling.handleExceptions;
import com.oksbwn.voiceEnable.Voice;
public class hardDiskpluggedTo {

	public static void main(String[] args) throws Exception
	{
		hardDiskpluggedTo hd =new hardDiskpluggedTo();
		hd.setDrivetoDB();
	}
	public void setDrivetoDB()
	{try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
	   String say="";
		 double x=FreeSpaceInDrive("E");
		if(x<20 && x>0)
		   {
		     con.prepareStatement("UPDATE usbdrives SET `drive`='E' Where `device` like 'Flash' ").executeUpdate();
		  say="Sir I have added a "+x+"GB   Pendrive.";
		   }
		if(x>500 && x>0)
		   {
		     con.prepareStatement("UPDATE usbdrives SET `drive`='E' Where `device` like 'Hard' ").executeUpdate();
		     say="Sir I have added the Hard-disk.";
			   }
	    x=FreeSpaceInDrive("F");
		if(x<20 && x>0)
		   {
		     con.prepareStatement("UPDATE usbdrives SET `drive`='F' Where `device` like 'Flash' ").executeUpdate();
		     say="Sir I have added a "+x+"GB   Pendrive.";
			  
		   }
		if(x>500 && x>0)
		   {
		     con.prepareStatement("UPDATE usbdrives SET `drive`='F' Where `device` like 'Hard' ").executeUpdate();
		     say="Sir I have added the Hard-disk.";
			  
		   }
		 x=FreeSpaceInDrive("G");
			if(x<20 && x>0)
			   {
			     con.prepareStatement("UPDATE usbdrives SET `drive`='G' Where `device` like 'Flash' ").executeUpdate();
			     say="Sir I have added a "+x+"GB   Pendrive.";
				  
			   }
			if(x>500 && x>0)
			   {
			     con.prepareStatement("UPDATE usbdrives SET `drive`='G' Where `device` like 'Hard' ").executeUpdate();
			     say="Sir I have added the Hard-disk.";
			   } 
			x=FreeSpaceInDrive("H");
				if(x<20 && x>0)
				   {
				     con.prepareStatement("UPDATE usbdrives SET `drive`='H' Where `device` like 'Flash' ").executeUpdate();
				     say="Sir I have added a "+x+"GB   Pendrive.";
					  
				   }
				if(x>500 && x>0)
				   {
				     con.prepareStatement("UPDATE usbdrives SET `drive`='H' Where `device` like 'Hard' ").executeUpdate();
				     say="Sir I have added the Hard-disk.";
				   }
			 x=FreeSpaceInDrive("I");
				if(x<20 && x>0)
				   {
				     con.prepareStatement("UPDATE usbdrives SET `drive`='I' Where `device` like 'Flash' ").executeUpdate();
				     say="Sir I have added a "+x+"GB   Pendrive.";
					  
				   }
				if(x>500 && x>0)
				   {
				     con.prepareStatement("UPDATE usbdrives SET `drive`='I' Where `device` like 'Hard' ").executeUpdate();
				     say="Sir I have added the Hard-disk.";
				   }
			 x=FreeSpaceInDrive("J");
				if(x<20 && x>0)
					   {
					     con.prepareStatement("UPDATE usbdrives SET `drive`='J' Where `device` like 'Flash' ").executeUpdate();
					     say="Sir I have added a "+x+"GB   Pendrive.";
						  
					   }
				if(x>500 && x>0)
					   {
					     con.prepareStatement("UPDATE usbdrives SET `drive`='J' Where `device` like 'Hard' ").executeUpdate();
					     say="Sir I have added the Hard-disk.";
					   }
			 x=FreeSpaceInDrive("K");
				if(x<20 && x>0)
				   {
				     con.prepareStatement("UPDATE usbdrives SET `drive`='K' Where `device` like 'Flash' ").executeUpdate();
				     say="Sir I have added a "+x+"GB   Pendrive.";
					  
				   }
				if(x>500 && x>0)
				   {
				     con.prepareStatement("UPDATE usbdrives SET `drive`='K' Where `device` like 'Hard' ").executeUpdate();
				     say="Sir I have added the Hard-disk.";
				   }
		con.close();
		if(say.isEmpty())
			say="Sorry sir i can not find any drive attached.";
		new Voice(say);
	}catch(Exception e){new handleExceptions(e);}
		
	}
	public static double FreeSpaceInDrive(String drive)
		{	
		double space=0;
		File file = new File(drive+":");
		long totalSpace = file.getTotalSpace(); //total disk space in bytes.
		 space=totalSpace /1024 /1024/1024;
		    	return space;
		    	}
}
