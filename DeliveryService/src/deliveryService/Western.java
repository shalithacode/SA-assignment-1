package deliveryService;

import java.io.FileWriter;
import java.io.IOException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import deliveryadmin.DeliveryServicesConstants;

@Component(property = org.osgi.service.event.EventConstants.EVENT_TOPIC + "=WESTERN")
	public class Western implements EventHandler {
	 

		@Override
		public void handleEvent(Event event) {
			System.out.println("DELIVERY SERVICE :   Delivery to "+ event.getProperty("city") +", Western province dispatched from Western branch");
			System.out.println("(WESTERN)\n");
			
	        try {
	            FileWriter writer = new FileWriter(DeliveryServicesConstants.QUEUE_WESTERN_PROV, true);
	            writer.write("Delivery Address : "+event.getProperty("deliveryAddress"));
	            writer.write("\r\n"); 
	            writer.write("Order Items : "+event.getProperty("orderItems"));
	            writer.write("\r\n"); 
	            writer.write("\r\n"); 
	            writer.close();
	            
	            System.out.println("Delivery details and items added to Western Branch Queue");  
	            
	        } catch (SecurityException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}
	 
	}