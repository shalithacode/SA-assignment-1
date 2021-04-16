package vendor;

import e_shoplk.Login;
import e_shoplk.Shop;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	ServiceReference shopServiceReference;
	ServiceReference loginServiceReference;
	
	public void start(BundleContext context) throws Exception {
		
		loginServiceReference = context.getServiceReference(Login.class.getName());
		Login loginServicePublish = (Login) context.getService(loginServiceReference);
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Seller Id: ");
		String uId = scan.next();
		System.out.println("Seller password: ");
		String password = scan.next();
		
		if(loginServicePublish.isUser(uId, password)) {
			System.out.println("");
			System.out.println("*****Start selling your products*****");
			System.out.println("");
			
			shopServiceReference = context.getServiceReference(Shop.class.getName());
			Shop shopServicePublish = (Shop) context.getService(shopServiceReference);
			
			System.out.println(shopServicePublish.viewProduct());
			
			
			System.out.println("How many product do you want to add?");
			int count = scan.nextInt();
			
			String name ="";
			double price = 0.0;
			int qty=0;
			
			for(int i =0; i<count;i++) {
				System.out.println("Item "+ (i+1));
				System.out.print("Enter name :");
				 name =scan.next();
				 System.out.print("Enter price :");
				 price = scan.nextDouble();
				 System.out.print("Enter quntity :");
				 qty= scan.nextInt();
				 
				 shopServicePublish.addProduct(name, price, qty);
				 System.out.println("");
			}
			System.out.println(shopServicePublish.viewProduct());
		}else {
			System.out.println("Invalid user!!!");
		}
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye !!!");
		context.ungetService(loginServiceReference);
	}
}
