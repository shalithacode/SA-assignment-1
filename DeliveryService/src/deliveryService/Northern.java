package deliveryService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

@Component(property = org.osgi.service.event.EventConstants.EVENT_TOPIC + "=NORTHERN")
	public class Northern implements EventHandler {
	 

		@Override
		public void handleEvent(Event event) {
			System.out.println("DELIVERY SERVICE :   Delivery to "+ event.getProperty("city") +", Northern province dispatched from Northern branch");
			System.out.println("(NORTHERN)\n");
			
		}
	 
	}
