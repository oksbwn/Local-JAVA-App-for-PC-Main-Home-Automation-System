/*This will help to maintain a shopping Lst on my PC for future Shopping
 * 
 * */
package com.oksbwn.shoppingCart;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.oksbwn.popUp.popMe;
import com.oksbwn.voiceEnable.Voice;

public class shopList {

	public static void main(String[] args) {
		new shopList().toShopList();
	}
public void toShopList(){
	String item= JOptionPane.showInputDialog(null,"What do you want to buy ?");
	if(item.length()!=0)
	{
		try{
			  String db="jdbc:mysql://localhost:3306/alberto";
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection(db,"root","");
			  boolean x= con.createStatement().execute("INSERT INTO `alberto`.`shoppinglist` (`Sl_No`, `Name`, `Brought`, `Synced`) VALUES (NULL, '"+item+"', 'No', 'No')");
			  if(!x){
				  new popMe("Item added to cart", "Shopping Cart", "ok", 5, 150);
				  new Voice("Sir I have added the item to your cart.");
			  }
		}catch(Exception e){e.printStackTrace();}
	}
	else
		new Voice("Sorry Sir i donot find any item to Add.");
	 
}
}
