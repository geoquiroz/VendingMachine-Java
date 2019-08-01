package Vending;
import java.util.Scanner;// scanner class

public class VendingMachine {
	public static void main(String[] args) {
	//initialize variables
	
		double insertMoney = 0.0;
		double itemPrice = 0.0;
		double charge = 0.0;
		double change = 0.0;
		int selection = 1;
		
		// change 
		int quarters;
		int dimes;
		int nickels;
		int pennies; 
		
		double amount = 1.0;
		boolean notdone = true;
		
		
		Scanner input = new Scanner(System.in);
		
//prompt user to input amounts
		System.out.println("The vending machine accepts amounts in coins");
		System.out.println("dime = 0.1, quarter = 0.25, penny = 0.01, nickel = 0.05, 1 dollar bill,and 5 dollars bill");
		System.out.println("Please insert amount and enter 0 to indicate you are done inserting");
//loop that prompt user to purchase 3 times		
	for(int i = 0; i< 3; i++){
		//reset all the value to their initial values after each purchase is completed;
		//create a while loop that ends when user enter 0 which changes the variable not done to false
		//user will enter amount individually 
		//user will receive warn when the amount entered is not penny, dime, nickel, quarter, 1 dollar or 5 dollar
		// try and catch is to avoid non-integer input like string
		
		notdone = true;
		insertMoney = 0.0;
		itemPrice = 0.0;
		change = 0.0;
		charge = 0.0;
		selection = 1;
		quarters= 0;
		dimes = 0;
		amount = 1.0; 
		nickels = 0;
		pennies = 0; 
		
		while (notdone){
			System.out.println("Enter amount ");
			
			try {
				amount = input.nextDouble();
				if(amount == 0.1 || amount ==  0.25 || amount == 0.05 || amount == 0.01 ||
						amount == 1 || amount == 5 || amount == 0){
					insertMoney = insertMoney + amount;
					
					if (amount == 0){
						notdone = false;
					}
				}
				else {
					System.out.println("Invalid input, please re-enter amount ");

																	
				}
			} 
			catch (Exception e) {
				System.out.println("Invalid input, please re-enter amount ");
				input.nextLine();
			}
						
		}
		//output total inserted amount after the while loop is ended 					
			System.out.println("You have inserted the monetary amount of $" + Math.round(insertMoney*100.0)/100.0);
			
		//output user instructions  
		//create a while loop that will end when user enter "0" 
		int count = 1;	
		System.out.println("This vending machine has five items to choose from");
		System.out
				.println("(1 for Doritos $1.50 , 2 for Sour Patch $2.50, 3 for Twix $0.99, 4 for Pretzels $1.75, "
							+ "5 for Pop-Tarts $3.50");
		System.out.println("Stop selection by entering 0");
		
		
		while(selection > 0){
			System.out.println("Please enter your selection for item #" + count);
			selection = input.nextInt();
			if(selection == 1 || selection == 2  || selection == 3 || selection == 4 ||
					selection == 5 || selection == 0){
				count++;
		
				//switch statement  
				//food price based on the selection					
			switch (selection){ 
					case 1: 
						itemPrice = 1.50;
						charge = charge + itemPrice;
						break;
					case 2:
						itemPrice = 2.50;
						charge = charge + itemPrice;
						break;
					case 3:
						itemPrice = 0.99;
						charge = charge + itemPrice;
						break;
						
					case 4:
						itemPrice = 1.75;
						charge = charge + itemPrice;
						break;
					
					case 5:
						itemPrice = 3.50;
						charge = charge + itemPrice;
						break;
					case 0:
						itemPrice = 0;
						charge = charge + itemPrice;
						break;
					
				}
			}
			//user if-else to output different outcomes ( insert amount > total charge or insert amount < total charge or selection = 0)
			//if user input values other than 0, 1 - 5, the machine will display an error message and prompt user to re-enter again until the input is valid 
			else{
				System.out.println("Sorry, the item is unavalible, please re-enter selection for item # "+ count);
				selection = input.nextInt();
				while(selection != 1 && selection !=  2 && selection != 3 && selection != 4 &&
						selection != 5 && selection != 0){
					System.out.println("Sorry, the item is unavalible, please re-enter selection for item # "+ count);
						selection = input.nextInt();
					}
				
				switch (selection){ 
				case 1: 
					itemPrice = 1.50;
					charge = charge + itemPrice;
					break;
				case 2:
					itemPrice = 2.50;
					charge = charge + itemPrice;
					break;
				case 3:
					itemPrice = 0.99;
					charge = charge + itemPrice;
					break;
					
				case 4:
					itemPrice = 1.75;
					charge = charge + itemPrice;
					break;
				
				case 5:
					itemPrice = 3.50;
					charge = charge + itemPrice;
					break;
				case 0:
					itemPrice = 0;
					charge = charge + itemPrice;
					break;
				}
					count++;
					
					
			}
						
		}
						
	
	//display the total amount in two decimal point after the while loop is ended 
	
		System.out.println();
		System.out.println("Thank you!");
		System.out.println("You have inserted the total amount of $ "+ Math.round(insertMoney*100.0)/100.0);
		
		//if the total charge is less than amount inserted and not equal to 0		
		if(insertMoney > charge && charge!= 0){
			change = Math.round((insertMoney - charge)*100.0)/100.0; 
			System.out.println("The total amount of $" + Math.round(charge*100.0)/100.0 + " will be charged");	
			System.out.println("The total change in the amount of $"+ change);
			System.out.println("You will receive the amount of change in ");
		}
		//if user did not select any item and enter 0 right away 
		else if (charge == 0){
			change = Math.round((insertMoney - charge)*100.0)/100.0; 
			
			System.out.println("Item not Selected, you will receive a full amount of refund ");
			System.out.print("The change refunded will be in ");
				
		}	
				
		//if total price is more than amount inserted
		//user will get full refund 
		else{
				change = 0;
				change = Math.round((insertMoney - change)*100.0)/100.0; 
				System.out.println("Sorry, Insufficient fund");
				System.out.println("You will receive full amount of refund");
				System.out.print("The change refunded will be in ");
				
			
			}
			
		//calculate change in quarters, dimes, nickels, and pennies 	
		change = change * 100;
		quarters = (int)change/ 25;
		change = change % 25;
		dimes = (int)change / 10;
		change = change % 10;
		nickels = (int)change /5;
		change = change % 5;
		pennies = (int)change;
		
			
		// display the change in quarters, dimes, nickels, and pennies 
		System.out.println(quarters+
				" quarter(s), "+ dimes +" dime(s), "+nickels +
				" nickel(s), "+pennies +" penny(s)");
		System.out.println("Enjoy!");
		System.out.println();
		
		
		}
	input.close();
	}	
	}
