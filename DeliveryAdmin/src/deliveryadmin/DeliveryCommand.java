package deliveryadmin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

@Component(service = DeliveryCommand.class)
	public class DeliveryCommand {
	
	 
	    public void dispatchOrder(BundleContext bundleContext, EventAdmin eventAdmin) {

			Scanner userInput = new Scanner(System.in);
			
			System.out.println("\n>> DELIVERY DETAILS <<\n");
			
			// Gets user input for delivery address
			
			System.out.println("Delivery address : ");
			String delAddress = userInput.nextLine();
			System.out.println("City : ");
			String city = userInput.next();
			System.out.println("Zip Code : ");
			String zipCode = userInput.next();
			
        	System.out.println("\nPlease confirm your delivery address");
        	System.out.println("====================================");
        	System.out.println("Delivery address : "+delAddress);
			System.out.println("City : "+city);
			System.out.println("Zip Code : "+zipCode);

			// User verifies address
			System.out.println("\nTo confirm press (Y) to re-enter press (N)");
			String confirmAddress = userInput.next();
			
			
	        while(confirmAddress.equalsIgnoreCase("N")) {
	        	
	        	userInput = new Scanner(System.in);
	        	
	        	// Correcting the address
				System.out.println("\n>> RE-ENTER DELIVERY DETAILS <<\n");
				
				System.out.println("Delivery address : ");
				delAddress = userInput.nextLine();
				System.out.println("City : ");
				city = userInput.next();
				System.out.println("Zip Code : ");
				zipCode = userInput.next();
				
	        	System.out.println("\nPlease confirm your delivery address");
	        	System.out.println("====================================");
	        	System.out.println("Delivery address : "+delAddress);
				System.out.println("City : "+city);
				System.out.println("Zip Code : "+zipCode);
	        	
				System.out.println("\nTo confirm press (Y) to re-enter press (N)");
				confirmAddress = userInput.next();
	        }
			
	        System.out.println("\nThank you for confirming your delivery address\n");
	        
	        Map<String, Object> properties = new HashMap<>();
	        	        
	        properties.put("city", city);
	        properties.put("deliveryAddress", delAddress);
	        properties.put("orderNumber", DeliveryServicesConstants.currentOrderNumber);
	        Event event = null;
	        
	        Integer provinceCode = Character.getNumericValue(zipCode.charAt(0));
	        String province = "";
	        
	        // Dispatches with province data for the relevant delivery branch service to consume the event
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
	 
	        // Sends event
	        if (event != null) {
	        	System.out.println("DELIVERY ADMIN :     ===== Delivery branch in "+province+" province notified =====");
	            eventAdmin.sendEvent(event);
	        }
	    }
	}
