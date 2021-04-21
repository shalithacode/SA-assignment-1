package e_shoplk;

import java.util.HashMap;

import org.osgi.framework.BundleContext;

public interface Ishop {

	public void addProduct(String name, double price, int qty);
	public boolean viewProduct();
	public boolean deleteProduct(String prod);
	public void checkout(BundleContext context, HashMap<String, Integer> cartItems);
	public void generateInvoice(HashMap<String, Integer> cartItems);
	
}
