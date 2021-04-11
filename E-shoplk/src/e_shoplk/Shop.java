package e_shoplk;

import java.util.ArrayList;
import java.util.Iterator;

public class Shop {
	ArrayList<Item> item = new ArrayList<>();
	
	public void addProduct(String name, double price, int qty) {
		
		item.add(new Item(name, price, qty));
	}
	
	public void viewProduct() {
		 Iterator itr=item.iterator();  
		  while(itr.hasNext()){  
		    Item product=(Item)itr.next();  
		    System.out.println(product.getpNname()+" "+product.getpPrice()+" "+product.getpQty());  
		  }  
		
	}
}
