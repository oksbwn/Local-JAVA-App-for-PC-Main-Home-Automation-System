package com.oksbwn.switchingBoardOne;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class mouseClickedOnLoad {

	initialLoadStatus iLs=new initialLoadStatus();
	fxPanelImage fxp=new fxPanelImage();
	public static void main(String[] args) {
	}
public void clickedOn(final int noOfPanel,final JFXPanel fx1,final String image,final String dbPinName)
{
	final String initialStatus=iLs.getInitial();
	 Platform.setImplicitExit(false);
	   Platform.runLater(new Runnable(){
	        @Override
	        public void run() {
	        	try {
	        	    if(initialStatus.charAt(noOfPanel)=='F')
	  	        	{
	        	    	fxp.initFxLater(fx1,image+"On");
	        	    	HttpClient client = new DefaultHttpClient();
	        		    HttpGet httppost = new HttpGet("http://192.168.0.1/API/controlModule/JAVA_API/update.php?point="+dbPinName+"&to=O");
	        		    ResponseHandler<String> responseHandler = new BasicResponseHandler();
						client.execute(httppost,responseHandler);
	  	        	}
	        	    else{
	        	    	fxp.initFxLater(fx1,image+"Off");
	        	    	HttpClient client = new DefaultHttpClient();
	        		    HttpGet httppost = new HttpGet("http://192.168.0.1/API/controlModule/JAVA_API/update.php?point="+dbPinName+"&to=F");
	        		    ResponseHandler<String> responseHandler = new BasicResponseHandler();
						client.execute(httppost,responseHandler);
	        	    }
	  	        	}catch(Exception e){}
	        }
	});
}
}
