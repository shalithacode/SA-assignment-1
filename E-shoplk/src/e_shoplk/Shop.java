package e_shoplk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import org.osgi.framework.BundleContext;

import deliveryadmin.DeliveryCommandActivator;

public class Shop implements Ishop {
	
	// Item list
	ArrayList<Item> item = new ArrayList<>();

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
			if (prod.equals(product.getpNname())) {

				item.remove(product);
				return true;
			}
		}
		return false;
	}

	@Override
	//Check out items in the cart
	public void checkout(BundleContext context, HashMap<String, Integer> cartItems) {
		
		Scanner userInput = new Scanner(System.in);
		
		//TODO display cart items in Cart plug-in before coming here
		
		System.out.println("Do you want to proceed to the checkout? ( Y to proceed, N to cancel)");
		String checkoutProceed = userInput.next();
				
		if(checkoutProceed.equalsIgnoreCase("Y")) {
			System.out.println("\n======================================");
			System.out.println("=========== STORE CHECKOUT ===========");
			System.out.println("======================================\n");
			
						//TODO print bill here
			
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
	// Generate invoice for items
	public void generateInvoice(HashMap<String, Integer> cartItems) {
		// TODO Auto-generated method stub
		
	}
}
