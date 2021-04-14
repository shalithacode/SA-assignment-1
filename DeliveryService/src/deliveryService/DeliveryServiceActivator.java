package deliveryService;

import deliveryadmin.DeliveryServicesConstants;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

public class DeliveryServiceActivator implements BundleActivator{

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting delivery service");
		
            Dictionary propsCentral = new Hashtable();
            propsCentral.put(EventConstants.EVENT_TOPIC, DeliveryServicesConstants.TOPIC_CENTRAL_PROV);
            EventHandler centralProv = new Central();
            bundleContext.registerService(EventHandler.class.getName(), centralProv, propsCentral);
            
            
            Dictionary propsWestern = new Hashtable();
            propsWestern.put(EventConstants.EVENT_TOPIC, DeliveryServicesConstants.TOPIC_WESTERN_PROV);
            EventHandler westernProv = new Western();
            bundleContext.registerService(EventHandler.class.getName(), westernProv, propsWestern);
            
            Dictionary propsNorthern = new Hashtable();
            propsNorthern.put(EventConstants.EVENT_TOPIC, DeliveryServicesConstants.TOPIC_NORTHERN_PROV);
            EventHandler nothernProv = new Northern();
            bundleContext.registerService(EventHandler.class.getName(), nothernProv, propsNorthern);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping delivery service");
		
	}

}