package cartService;

import java.util.Scanner;

public class Cart implements ICart{
	
	String itemCategory,itemFashion,itemPhones,decision;
	Double cost, finalCost = 0.0;
	char[] items = new char[100];
	int[] quantities = new int[100];
	int quantity, x = 0, y = 0;
	
	Scanner getInput = new Scanner(System.in);
	
	public void publishService() {
		
		customerCart();
	}
	
	public void customerCart() {
		
		System.out.println("Please select the item category that you prefer to shop: ");
		System.out.println(" A) Fashion \n"
				+ " B) Phones and Telecommunications \n"
				+ " C) Toys,Kids and Babies \n"
				+ " D) Beauty,Health & Hair ");	
		itemCategory = getInput.next();
		
		System.out.println(" ");
		

		if(itemCategory.equals("A") || itemCategory.equals("a")) {

			
				do {
					double returnCost = CategoryA();  //calling Category A
					
					finalCost += returnCost; //adding final costs while running in loop
					
					System.out.println("Do you want to continue shopping? (Yes/No)");
					decision = getInput.next();
						
				} while(decision.equals("Yes") || decision.equals("yes"));
				
				CategoryAPrint();  //Printing details of Category A
			
		} else if(itemCategory.equals("B") || itemCategory.equals("b")) {
				
				do {
					double returnCost = CategoryB(); //calling Category B
					
					finalCost += returnCost;
					
					System.out.println("Do you want to continue shopping? (Yes/No)");
					decision = getInput.next();
						
				} while(decision.equals("Yes") || decision.equals("yes"));
			
			CategoryBPrint(); //Printing details of category B
		}
		
		return;
	}
	
	public double CategoryA() {
		String status = "No";
		
		while(status.equals("No")) {
			System.out.println((" A)Dress \n"
								+ " B)Casual Short \n"
								+ " C)Blouse \n"
								+ " D)Jacket \n"
								+ " E)Sweater"));
			System.out.println(" ");
			System.out.println("Please select the items that you need to add to cart : ");
			
			
			itemFashion = getInput.next(); //getting input from user for items in fashion section
			
			if(itemFashion.equals("A") || itemFashion.equals("a")) {
				status = "Ok";
				
				cost = 1500.00;
				
				if(itemFashion.equals("A")) {
					items[x] = 'A';
					
				} else {
					items[x] = 'a';
				}
				
				x++;
				
			}
			else if(itemFashion.equals("B") || itemFashion.equals("b")) {
				status = "Ok";
				
				cost = 800.00;
				
				if(itemFashion.equals("B")) {
					items[x] = 'B';
					
				} else {
					items[x] = 'b';
				}
				
				x++;
				
			}
			
			else if(itemFashion.equals("C") || itemFashion.equals("c")) {
				status = "Ok";
				
				cost = 1000.00;
				
				if(itemFashion.equals("C")) {
					items[x] = 'C';
					
				} else {
					items[x] = 'c';
				}
				
				x++;
			}
			else if(itemFashion.equals("D") || itemFashion.equals("d")) {
				status = "Ok";
				
				cost = 3000.00;
				
				if(itemFashion.equals("D")) {
					items[x] = 'B';
					
				} else {
					items[x] = 'd';
				}
				
				x++;
			}
			else if(itemFashion.equals("E") || itemFashion.equals("e")) {
				status = "Ok";
				
				cost = 3500.00;
				
				if(itemFashion.equals("E")) {
					items[x] = 'E';
					
				} else {
					items[x] = 'e';
				}
				
				x++;
			}
			else {
				System.out.println("Wrong input,Enter again");
				
			}
			
		}
		
		System.out.println(" ");
		
		System.out.println("Please enter the quantity of items that you wish to buy :");
		quantity = getInput.nextInt();
		
		quantities[y] = quantity;
		y++;
		
		return quantity * cost;
		
	}
	
	public void CategoryAPrint(){
		
			if(itemFashion.equals(itemFashion) || itemFashion.equals(itemFashion)) {
				System.out.println("Item Category : Fashion");
				System.out.println("List of items added to cart : ");
				
				for(int i = 0 ; i < items.length ; i++) {
					if((items[i] == 'A') || (items[i] == 'a')) {
						System.out.println("Dress - " + quantities[i]);
						
					} else if((items[i] == 'B') || (items[i] == 'b')) {
						System.out.println("Casual Short - " + quantities[i]);
						
					}
					else if((items[i] == 'C') || (items[i] == 'c')) {
						System.out.println("blouse - " + quantities[i]);
						
					}
					else if((items[i] == 'D') || (items[i] == 'd')) {
						System.out.println("Jacket - " + quantities[i]);
						
					}
					else if((items[i] == 'E') || (items[i] == 'e')) {
						System.out.println("Sweater - " + quantities[i]);
						
					}
				}
				
				System.out.println("Final Cost : " + finalCost);
				
				if(decision.equals("Yes")) {
					
				System.out.println("Final Cost : " + finalCost);
				}
				System.out.println(" ");
				System.out.println(" ");
			}
					
			else {
				System.out.println("Your cart is empty");
			}
	}
	
	public double CategoryB() {
		String status = "No";
		
		while(status.equals("No")) {
			System.out.println((" A) Tempered Full Cover \n"
								+ " B) Magnetic Leather case \n"
								+ " C) iphone 12 \n"
								+ " D) Samsung Galaxy S21 \n"
								+ " E) USB charger"));
			System.out.println(" ");
			System.out.println("Please select the items that you need to add to cart : ");
			
			
			itemPhones = getInput.next();
			
			if(itemPhones.equals("A") || itemPhones.equals("a")) {
				status = "Ok";
				
				cost = 1500.00;
				
				if(itemPhones.equals("A")) {
					items[x] = 'A';
					
				} else {
					items[x] = 'a';
				}
				
				x++;
				
			}
			else if(itemPhones.equals("B") || itemPhones.equals("b")) {
				status = "Ok";
				
				cost = 2000.00;
				
				if(itemPhones.equals("B")) {
					items[x] = 'B';
					
				} else {
					items[x] = 'b';
				}
				
				x++;
				
			}
			
			else if(itemPhones.equals("C") || itemPhones.equals("c")) {
				status = "Ok";
				
				cost = 250000.00;
				
				if(itemPhones.equals("C")) {
					items[x] = 'C';
					
				} else {
					items[x] = 'c';
				}
				
				x++;
			}
			else if(itemPhones.equals("D") || itemPhones.equals("d")) {
				status = "Ok";
				
				cost = 200000.00;
				
				if(itemPhones.equals("D")) {
					items[x] = 'B';
					
				} else {
					items[x] = 'd';
				}
				
				x++;
			}
			else if(itemPhones.equals("E") || itemPhones.equals("e")) {
				status = "Ok";
				
				cost = 3500.00;
				
				if(itemPhones.equals("E")) {
					items[x] = 'E';
					
				} else {
					items[x] = 'e';
				}
				
				x++;
			}
			else {
				System.out.println("Wrong input,Enter again");
				
			}
			
		}
		
		System.out.println(" ");
		
		System.out.println("Please enter the quantity of items that you wish to buy :");
		quantity = getInput.nextInt();
		
		quantities[y] = quantity;
		y++;
		
		return quantity * cost;
		
	}
	public void CategoryBPrint(){
		
		if(itemPhones.equals(itemPhones) || itemPhones.equals(itemPhones)) {
			System.out.println("Item Category : Phones and Telecommunications");
			System.out.println("Items added to cart : ");
			
			for(int i = 0 ; i < items.length ; i++) {
				if((items[i] == 'A') || (items[i] == 'a')) {
					System.out.println("Tempered Full Cover - " + quantities[i]);
					
				} else if((items[i] == 'B') || (items[i] == 'b')) {
					System.out.println("Magnetic Leather case - " + quantities[i]);
					
				}
				else if((items[i] == 'C') || (items[i] == 'c')) {
					System.out.println("iphone 12 - " + quantities[i]);
					
				}
				else if((items[i] == 'D') || (items[i] == 'd')) {
					System.out.println("Samsung Galaxy S21 - " + quantities[i]);
					
				}
				else if((items[i] == 'E') || (items[i] == 'e')) {
					System.out.println("USB charger - " + quantities[i]);
					
				}
			}
			
			System.out.println("Final Cost : " + finalCost);
			
			if(decision.equals("Yes")) {
			System.out.println("Final Cost : " + finalCost);
			}
			
			System.out.println(" ");
			System.out.println(" ");
		}
				

		else {
			System.out.println("Your cart is empty");
		}
	}

}
