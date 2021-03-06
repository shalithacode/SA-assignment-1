package e_shoplk;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration shopServiceRegistration;
	ServiceRegistration loginServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		//Shop service registration 
		System.out.println("Shop plugin activated");
		Ishop publisherShopService = new Shop();
		shopServiceRegistration = context.registerService(Shop.class.getName(), publisherShopService, null);

		//Login service registration 
		Login publisherLoginService = new Login();
		loginServiceRegistration = context.registerService(Login.class.getName(), publisherLoginService, null);
	}

	public void stop(BundleContext context) throws Exception {
		
		//Deactivate all the services
		System.out.println("Shop plugin deactivated");
		shopServiceRegistration.unregister();
		loginServiceRegistration.unregister();
	}
}
