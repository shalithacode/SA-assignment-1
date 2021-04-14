package deliveryadmin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.EventAdmin;

public class DeliveryCommandActivator implements BundleActivator {

	private static BundleContext context;
	ServiceReference serviceReference;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		
		Map<String, String> address= new HashMap<String, String>();
		
		//TODO remove test values
		address.put("40000", "Jaffna");
		address.put("20400", "Peradeniya");
		address.put("10120", "Battaramulla");
		address.put("30000", "Batticaloa");
		address.put("00500", "Havelock Town");
		
		DeliveryCommand deliverycmd = new DeliveryCommand();

		address.forEach((zipCode,city) -> deliverycmd.dispatchOrder(zipCode, city, bundleContext));
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		DeliveryCommandActivator.context = null;
		System.out.println("Stopping delivery service");
	}

}
