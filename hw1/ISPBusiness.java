package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author <<Write your name here>>
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		//TODO: Write your code here.
		
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		//TODO: Write/update your code here.
		return 0;
	}
	
	/**
	 * Returns the number the user inputs for how the town is created
	 * @param none
	 * @return user entered number
	 */
	public static int inputOption() {
		int userInputInt;
		while(true) {
			System.out.println("How to populate grid (type 1 or 2):\n1: from a file.\n2: randomly " + 
					"with seed");
			String userInputString = userInput();
			try {
				userInputInt = Integer.parseInt(userInputString);
				if(userInputInt == 1 || userInputInt == 2) {
					return userInputInt;
				}
				else {
					badInput();
				}
			}
			catch(Exception e) {
				badInput();
			}
		}
	}
	
	/**
	 * Returns the number the user inputs for how the town is created
	 * @param 
	 * @return user entered string
	 */
	public static String userInput() {
		Scanner tempObj = new Scanner(System.in);
		String userInput = tempObj.nextLine();
		//tempObj.close();
		return userInput;
	}
	
	/**
	 *prints statement saying the user input was bad
	 * @param 
	 * @return 
	 */
	public static void badInput() {
		System.out.println("You did not enter an acceptable option, please try again...\n");
		return;
	}
	
	/**
	 *generates the town object based on the users input
	 * @param userSelection : the user selection of 1 or 2
	 * @return 
	 */
	public static Town generateTown(int userSelection) {
		if (userSelection == 1) {
			while(true) {
				System.out.println("Please enter file path:");
				String userfp = userInput();
				try {
					Town myTown = new Town(userfp);
					return myTown;
				} 
				catch (FileNotFoundException e) {
					System.out.println("File is not found, please enter again...\n");
					e.printStackTrace();
				}
			}
		}
		else if (userSelection == 2) {
			while(true) {
				int[] newUserSpecs = new int[3];
				System.out.println("Provide rows, cols and seed integer separated by spaces:");
				String userSpecs = userInput();
				String[] userSpecsSplit = userSpecs.split("\\s+");
				if (userSpecsSplit.length == 3) {
					try {
						for(int i = 0; i < 3; i++) {
							newUserSpecs[i] =  Integer.parseInt(userSpecsSplit[i]);
						}
						Town myTown = new Town(newUserSpecs[0], newUserSpecs[1]);
						myTown.randomInit(newUserSpecs[2]);
						return myTown;
					}
					catch(Exception e) {
						badInput();
					}
				}
				else {
					badInput();
				}
			}
		}
		return null;
	}
	

	/**
	 * Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should only print the integer part (Just print the 
	 *  integer value. Example if profit is 35.56%, your output should be just: 35).
	 *  
	 * Note that this method does not throws any exception, thus you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */	
	public static void main(String []args) {
		//TODO: Write your code here.
		int userSelection = inputOption();
		Town myTown = generateTown(userSelection);
		System.out.println("\n" + myTown.toString());
		for(int month = 0; month < 12; month++) {
			myTown.
		}
		
		System.out.println("doneski");
	}
}
