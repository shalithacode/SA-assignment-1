package e_shoplk;

import java.util.ArrayList;
import java.util.Iterator;

public class Shop {
	ArrayList<Item> item = new ArrayList<>();
	
	public void addProduct(String name, double price, int qty) {
		
		item.add(new Item(name, price, qty));
	}
	
	public boolean viewProduct() {
		 Iterator itr=item.iterator();  
		 
		 if(item.isEmpty())
			 return false;
		 else {
			 System.out.println(" Item | Price | Quntity ");
		  while(itr.hasNext()){  
		    Item product=(Item)itr.next();  
		    System.out.println(" " + product.getpNname()+" | "+product.getpPrice()+" | "+product.getpQty());  
		  }
		return true; 
		 }
		
	}
}
