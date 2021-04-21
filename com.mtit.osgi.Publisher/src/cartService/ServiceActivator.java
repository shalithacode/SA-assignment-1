package cartService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;
	
	public void start(BundleContext context) throws Exception{
		
		System.out.println("WELCOME TO THE STORE!");
		System.out.println("=====================\n");
		ICart publisherService = new Cart();
		publishServiceRegistration = context.registerService(
				
		ICart.class.getName(),publisherService , null);
		
	}
	
	public void stop(BundleContext context) throws Exception{
		
		System.out.println("Stopping cart");
		publishServiceRegistration.unregister();
	}
	
	
}
