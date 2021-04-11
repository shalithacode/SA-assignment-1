package e_shoplk;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration shopServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Shop start");
		Shop publisherShopService = new Shop();
		shopServiceRegistration = context.registerService(Shop.class.getName(), publisherShopService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Shop stop");
		shopServiceRegistration.unregister();
	}
}
