package vendor;

import e_shoplk.Ishop;
import e_shoplk.Login;
import e_shoplk.Shop;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	ServiceReference shopServiceReference;
	ServiceReference loginServiceReference;
	Ishop shopServicePublish;

	Scanner scan = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {

		//Refer login service
		loginServiceReference = context.getServiceReference(Login.class.getName());
		Login loginServicePublish = (Login) context.getService(loginServiceReference);

		//Refer shop service
		shopServiceReference = context.getServiceReference(Shop.class.getName());
		shopServicePublish = (Shop) context.getService(shopServiceReference);

		//Validate vendor
		System.out.println("Seller Id: ");
		String uId = scan.next();
		System.out.println("Seller password: ");
		String password = scan.next();

		if (loginServicePublish.isUser(uId, password)) {

			System.out.println("");
			System.out.println("*****Start selling your products*****");
			System.out.println("");

			if (shopServicePublish.viewProduct()) {
				System.out.println("----ALL ITEMS-----");
				System.out.println("");
				System.out.println("Select is your need?");
				System.out.println("Update your product list => update");
				System.out.println("Delete your product list => delete");
				String opt = scan.next().toLowerCase();

				//Delete existing product
				if (opt.equals("update")) {
					addProducts();
				} else if (opt.equals("delete")) {
					//Delete existing product
					System.out.println("Enter what do you want to delete?");
					String deleteItem = scan.next().toLowerCase();
					if (shopServicePublish.deleteProduct(deleteItem)) {
						System.out.println("Product deleted.");
					} else {
						System.out.println("Something went wrong...");
					}

				} else {
					System.out.println("Invalid input!");
				}
			} else {
				System.out.println("No Current Items");
				addProducts();
			}

		} else {
			System.out.println("Invalid user!!!");
		}

	}

	//Add new products
	public void addProducts() {
		System.out.println("How many product do you want to add?");
		int count = scan.nextInt();

		String name = "";
		double price = 0.0;
		int qty = 0;

		for (int i = 0; i < count; i++) {
			System.out.println("Item " + (i + 1));
			System.out.print("Enter name :");
			name = scan.next();
			System.out.print("Enter price :");
			price = scan.nextDouble();
			System.out.print("Enter quntity :");
			qty = scan.nextInt();

			shopServicePublish.addProduct(name, price, qty);
			System.out.println("");
		}
		if (shopServicePublish.viewProduct()) {
			System.out.println("----ALL ITEMS-----");
		}
	}

	//Deactivated services
	public void stop(BundleContext context) throws Exception {
		System.out.println("Vendor plugin deactivated !!!");
		context.ungetService(loginServiceReference);
		context.ungetService(shopServiceReference);
	}
}
