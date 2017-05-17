package com.oksbwn.News;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class shownewsFrames{
	static createFrame f1=new createFrame();
	static createFrame f2=new createFrame();
	static createFrame f3=new createFrame();
	static createFrame f4=new createFrame();
	static createFrame f5=new createFrame();
	static createFrame f6=new createFrame();
	static createFrame f7=new createFrame();
	static createFrame f8=new createFrame();
	static createFrame f9=new createFrame();
	static createFrame f10=new createFrame();
	static createFrame f11=new createFrame();
	static createFrame f12=new createFrame();
	static 	createFrame f13=new createFrame();
	static createFrame f14=new createFrame();
	static createFrame f15=new createFrame();
	static createFrame f16=new createFrame();
	static createFrame f17=new createFrame();
	static createFrame f18=new createFrame();
	
	static createFrame f19=new createFrame();
	static createFrame f20=new createFrame();
	static createFrame f21=new createFrame();
	static createFrame f22=new createFrame();
	static createFrame f23=new createFrame();
	static createFrame f24=new createFrame();
	static createFrame f25=new createFrame();
	static createFrame f26=new createFrame();
	static createFrame f27=new createFrame();

	static createFrame f28=new createFrame();
	static createFrame f29=new createFrame();
	static createFrame f30=new createFrame();
	static 	createFrame f31=new createFrame();
	static createFrame f32=new createFrame();
	static createFrame f33=new createFrame();
	static createFrame f34=new createFrame();
	static createFrame f35=new createFrame();
	static createFrame f36=new createFrame();
	
	static createFrame f37=new createFrame();
	static createFrame f38=new createFrame();
	static 	createFrame f39=new createFrame();
	static createFrame f40=new createFrame();
	static createFrame f41=new createFrame();
	static createFrame f42=new createFrame();
	static createFrame f43=new createFrame();
	static createFrame f44=new createFrame();
	static lastframe f45=new lastframe();
	String std="f45";
	public static void main(String[] args) { new shownewsFrames().createFrames();}
	public void createFrames(){
		String[] newsHead=new String[46] ;
		String[] Sl_No=new String[46];
		int i=0;
		try{
		  Class.forName("com.mysql.jdbc.Driver");
	      Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/alberto","root","");
			ResultSet resultNews=con1.prepareStatement("SELECT * FROM `news` ORDER BY `news`.`Sl_No`  DESC LIMIT 0,45").executeQuery();
	         while(resultNews.next())
	         {
	        	 Sl_No[i]=resultNews.getString(1);
	        	 newsHead[i]=resultNews.getString(2);
	        	 Thread.sleep(5);
	        	 i++;
	         } con1.close(); }catch(Exception e){System.out.println(e);}
	         
		//int k=0;
		//while(k<i){System.out.println(Sl_No[k]+"  "+newsHead[k]+"  "+i);k++;}
		
	try{
		f1.frame(20,20,newsHead[0],Sl_No[0]);
		f18.frame(900,130,newsHead[1],Sl_No[1]);
		f17.frame(790,130,newsHead[2],Sl_No[2]);
		f16.frame(680,130,newsHead[3],Sl_No[3]);
		f15.frame(570,130,newsHead[4],Sl_No[4]);
		f14.frame(460,130,newsHead[5],Sl_No[5]); 
		f3.frame(240,20,newsHead[6],Sl_No[6]);
		f2.frame(130,20,newsHead[7],Sl_No[7]);
		f13.frame(350,130,newsHead[8],Sl_No[8]); 
		f12.frame(240,130,newsHead[9],Sl_No[9]);
		f11.frame(130,130,newsHead[10],Sl_No[10]); 
		f10.frame(20,130,newsHead[11],Sl_No[11]);
		f9.frame(900,20,newsHead[12],Sl_No[12]);
		f8.frame(790,20,newsHead[13],Sl_No[13]);
		f7.frame(680,20,newsHead[14],Sl_No[14]); 
		f6.frame(570,20,newsHead[15],Sl_No[15]);
		f5.frame(460,20,newsHead[16],Sl_No[16]);
		f4.frame(350,20,newsHead[17],Sl_No[17]);

	    f44.frame(790,460,newsHead[18],Sl_No[18]);
		f43.frame(680,460,newsHead[19],Sl_No[19]);
		f42.frame(570,460,newsHead[20],Sl_No[20]);
		f41.frame(460,460,newsHead[36],Sl_No[36]); 
		f40.frame(350,460,newsHead[37],Sl_No[37]);
		f39.frame(240,460,newsHead[38],Sl_No[38]);
		f38.frame(130,460,newsHead[39],Sl_No[39]);
		f37.frame(20,460,newsHead[40],Sl_No[40]);
	    f36.frame(900,350,newsHead[41],Sl_No[41]); 
		f35.frame(790,350,newsHead[42],Sl_No[42]);
		f34.frame(680,350,newsHead[43],Sl_No[43]);
		f33.frame(570,350,newsHead[21],Sl_No[21]);
		f32.frame(460,350,newsHead[22],Sl_No[22]); 
		f31.frame(350,350,newsHead[23],Sl_No[23]);
		f30.frame(240,350,newsHead[24],Sl_No[24]);
		f29.frame(130,350,newsHead[25],Sl_No[25]); 
		f28.frame(20,350,newsHead[26],Sl_No[26]);
		f27.frame(900,240,newsHead[27],Sl_No[27]); 
		f26.frame(790,240,newsHead[28],Sl_No[28]);
		f25.frame(680,240,newsHead[29],Sl_No[29]); 
		f24.frame(570,240,newsHead[30],Sl_No[30]);
		f23.frame(460,240,newsHead[31],Sl_No[31]);
		f22.frame(350,240,newsHead[32],Sl_No[32]); 
		f21.frame(240,240,newsHead[33],Sl_No[33]);
		f20.frame(130,240,newsHead[34],Sl_No[34]); 
		f19.frame(20,240,newsHead[35],Sl_No[35]);
		f45.frame(900,460);}catch(Exception e){System.out.println(e);}
	}
	void allDispose()
		{
		f1.dispose().dispose();
		f2.dispose().dispose();
		f3.dispose().dispose();
		f4.dispose().dispose();
		f5.dispose().dispose();
		f6.dispose().dispose();
		f7.dispose().dispose();
		f8.dispose().dispose();
		f9.dispose().dispose();
		f10.dispose().dispose();
		f11.dispose().dispose();
		f12.dispose().dispose();
		f13.dispose().dispose();
		f14.dispose().dispose();
		f15.dispose().dispose();
		f16.dispose().dispose();
		f17.dispose().dispose();
		f18.dispose().dispose();
		f19.dispose().dispose();
		f20.dispose().dispose();
		f21.dispose().dispose();
		f22.dispose().dispose();
		f23.dispose().dispose();
		f24.dispose().dispose();
		f25.dispose().dispose();
		f26.dispose().dispose();
		f27.dispose().dispose();
		f28.dispose().dispose();
		f29.dispose().dispose();
		f30.dispose().dispose();
		f31.dispose().dispose();
		f32.dispose().dispose();
		f33.dispose().dispose();
		f34.dispose().dispose();
		f35.dispose().dispose();
		f36.dispose().dispose();
		f37.dispose().dispose();
		f38.dispose().dispose();
		f39.dispose().dispose();
		f40.dispose().dispose();
		f41.dispose().dispose();
		f42.dispose().dispose();
		f43.dispose().dispose();
		f44.dispose().dispose();
		f45.dispose().dispose();
		
		
		}
}


