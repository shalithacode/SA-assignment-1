package cart;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import e_shoplk.Ishop;
import e_shoplk.Shop;

public class CartActivator implements BundleActivator {

	ServiceReference shopServiceReference;
	Ishop shopServicePublish;
	ServiceRegistration cartServiceRegistration;
	HashMap<String, Integer> cartItems = new HashMap<String, Integer>();

	public void start(BundleContext bundleContext) throws Exception {

		//TODO remove (dummy data)
		cartItems.put("Pen", 10);
		cartItems.put("Book", 3);
		
		System.out.println("Starting cart\n");
		
		shopServiceReference = bundleContext.getServiceReference(Shop.class.getName());
		shopServicePublish = (Shop)bundleContext.getService(shopServiceReference);
		shopServicePublish.checkout(bundleContext, cartItems);

	}
	
	public Map<String, Integer> getCartItems(){
		return cartItems;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Cart deactivated");
		bundleContext.ungetService(shopServiceReference);
	}

}
