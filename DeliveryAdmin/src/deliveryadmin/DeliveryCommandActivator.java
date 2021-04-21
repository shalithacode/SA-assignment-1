package deliveryadmin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.EventAdmin;

public class DeliveryCommandActivator implements BundleActivator {

    @Reference
    EventAdmin eventAdmin;
	ServiceReference deliveryAdminServiceReference;
	ServiceReference cartServiceReference;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		
		DeliveryCommand deliverycmd = new DeliveryCommand();
		
		deliveryAdminServiceReference = bundleContext.getServiceReference(EventAdmin.class.getName());

        eventAdmin = (EventAdmin)bundleContext.getService(deliveryAdminServiceReference);
       
        // Starts service to get delivery details and notify relevant delivery branch
		deliverycmd.dispatchOrder(bundleContext, eventAdmin);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {

		System.out.println("Stopping delivery service");
		
		// Deactivates service
		bundleContext.ungetService(deliveryAdminServiceReference);
	}

}
