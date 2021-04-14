package deliveryadmin;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

@Component(service = DeliveryCommand.class)
	public class DeliveryCommand {
	
		ServiceReference serviceReference;
	
	    @Reference
	    EventAdmin eventAdmin;
	 
	    public void dispatchOrder(String zipCode,String city, BundleContext bundleContext) {

	        // create the event properties object
	        Map<String, Object> properties = new HashMap<>();
	        properties.put("city", city);
	        Event event = null;
	        
	        serviceReference = bundleContext.getServiceReference(EventAdmin.class.getName());

	        eventAdmin = (EventAdmin)bundleContext.getService(serviceReference);
	        
	        Integer provinceCode = Character.getNumericValue(zipCode.charAt(0));
	        String province = "";
	        
	        switch (provinceCode) {
	            case 4:
	                event = new Event(DeliveryServicesConstants.TOPIC_NORTHERN_PROV, properties);
	                province = "northern";
	                break;
	            case 2:
	                event = new Event(DeliveryServicesConstants.TOPIC_CENTRAL_PROV, properties);
	                province = "central";
	                break;
	            case 1:
	                event = new Event(DeliveryServicesConstants.TOPIC_WESTERN_PROV, properties);
	                province = "western";
	                break;
	            case 0:
	                event = new Event(DeliveryServicesConstants.TOPIC_WESTERN_PROV, properties);
	                province = "western";
	                break;
	            default:
	                System.out.println("DELIVERY ADMIN :     Sorry, no delivery branches for this province.\n                     "
	                		+ "ZIP-CODE : "+zipCode+"\n");
	        }
	 
	        if (event != null) {
	        	System.out.println("DELIVERY ADMIN :     ===== Delivery branch in "+province+" province notified =====");
	            eventAdmin.sendEvent(event);
	        }
	    }
	}
