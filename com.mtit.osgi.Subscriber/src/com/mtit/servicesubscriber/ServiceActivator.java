package com.mtit.servicesubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import cartService.ICart;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Starting cart\n");
		serviceReference = context.getServiceReference(ICart.class.getName());
		
		ICart servicePublish = (ICart) context.getService(serviceReference);
		
		servicePublish.publishService();
	}
	
	public void stop(BundleContext context) throws Exception{
		
		System.out.println("Stopping cart");
		context.ungetService(serviceReference);
	}

}
