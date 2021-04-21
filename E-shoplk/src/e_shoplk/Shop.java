package e_shoplk;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.osgi.framework.BundleContext;

import deliveryadmin.DeliveryCommandActivator;
import deliveryadmin.DeliveryServicesConstants;

public class Shop implements Ishop {
	
	// Item list
	ArrayList<Item> item = new ArrayList<>();
	
	int orderNumber = 0;

	@Override
	//Add a new product
	public void addProduct(String name, double price, int qty) {

		item.add(new Item(name, price, qty));
	}

	@Override
	// Get all the items
	public boolean viewProduct() {
		Iterator itr = item.iterator();

		if (item.isEmpty())
			return false;
		else {
			System.out.println(" Item | Price | Quntity ");
			while (itr.hasNext()) {
				Item product = (Item) itr.next();
				System.out.println(" " + product.getpNname() + " | " + product.getpPrice() + " | " + product.getpQty());
			}
			return true;
		}
	}
	
	@Override
	// Delete the item
	public boolean deleteProduct(String prod) {
		Iterator itr = item.iterator();
		while (itr.hasNext()) {
			Item product = (Item) itr.next();
			if (prod.equalsIgnoreCase(product.getpNname())) {

				item.remove(product);
				return true;
			}
		}
		return false;
	}

	@Override
	//Check-out items in the cart
	public void checkout(BundleContext context, HashMap<String, Integer> cartItems) {
		
		Scanner userInput = new Scanner(System.in);
		
		//TODO display cart items in *Cart plug-in* before coming here
		
		System.out.println("Do you want to proceed to the checkout? ( Y to proceed, N to cancel)");
		String checkoutProceed = userInput.next();
				
		if(checkoutProceed.equalsIgnoreCase("Y")) {
			System.out.println("\n======================================");
			System.out.println("=========== STORE CHECKOUT ===========");
			System.out.println("======================================\n");
			
			// print invoice
			generateInvoice(cartItems);
			
			DeliveryCommandActivator deliveryService = new DeliveryCommandActivator();
			try {
				deliveryService.start(context);
			} catch (Exception e) {
				System.out.println("Error in starting delivery service ");
				e.printStackTrace();
			}
		}else {
			System.out.println(">>> Back to store <<<\n");
			viewProduct();
		}
		
	}

	@Override
	// Generates invoice for items checked out from cart
	public void generateInvoice(HashMap<String, Integer> cartItems) {
		
		ArrayList<Item> billItems = new ArrayList<>();
		String currItem;
		double totalPrice, totItemPrice; 
		boolean itemNotFound;
		
		totalPrice = 0;
		
		//Calculating invoice
		for (Map.Entry<String, Integer> set : cartItems.entrySet()) {
			currItem = set.getKey();
			itemNotFound = true;
			
			for (Item thisitem : item) { 
				
				totItemPrice = 0;
				
				if(thisitem.getpNname().equalsIgnoreCase(currItem)) {
					
					itemNotFound = false;
					
					totItemPrice = thisitem.getpPrice() * set.getValue();
					totalPrice += totItemPrice;
					
					billItems.add(new Item(currItem, totItemPrice, set.getValue()));
					
					break;
				}
			}
			
			if(itemNotFound) {
				System.out.println("ERROR : Item "+ currItem.toUpperCase() +" not found");
			}
			
			
		}
		
		//Printing invoice
		
		System.out.println("\n============= INVOICE =============\n");
		
		System.out.printf("%-15s%-15s%-15s%n", "ITEM", "QUANTITY", "PRICE");
		
		for (Item billitem : billItems) {
			System.out.format("%-15s%-15s%-15s%n", billitem.getpNname(), String.valueOf(billitem.getpQty()), String.valueOf(billitem.getpPrice()));
		}
		
		int thisOrderNum = ++orderNumber;
		
		String orderNum = String.format("%04d", thisOrderNum);
		DeliveryServicesConstants.currentOrderNumber = orderNum;
		
		System.out.printf("%-30s%-15s%n","TOTAL PRICE",String.valueOf(totalPrice));
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~");
		System.out.println("ORDER NUMBER : "+orderNum);
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("\n===================================");
		
		//Log Items
        try {
            FileWriter writer = new FileWriter(DeliveryServicesConstants.ORDERS, true);
            writer.write("Order ID : "+orderNum);
            writer.write("\r\n"); 
            writer.write("Order Items");
            writer.write("\r\n"); 
            writer.write("-----------");
            writer.write("\r\n"); 
            for (Item orderitem : billItems) {
            	writer.write("Item : "+orderitem.getpNname());
                writer.write("\r\n"); 
                writer.write("Quantity : "+orderitem.getpQty());
                writer.write("\r\n");
                writer.write("\r\n");
			}
            writer.write("===============");
            writer.write("\r\n"); 
            writer.write("\r\n"); 
            writer.close();
                        
        } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
