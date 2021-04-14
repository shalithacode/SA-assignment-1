package deliveryadmin;

public final class DeliveryServicesConstants {

	private DeliveryServicesConstants() {/*Private, to avoid extension of this class*/};
	
	public static final String TOPIC_BASE = "DeliveryCommand/";
	
	/* Delivery branches available */
	public static final String TOPIC_NORTHERN_PROV = TOPIC_BASE+"NORTHERN";
	public static final String TOPIC_CENTRAL_PROV = TOPIC_BASE+"CENTRAL";
	public static final String TOPIC_WESTERN_PROV = TOPIC_BASE+"WESTERN";
	
}
