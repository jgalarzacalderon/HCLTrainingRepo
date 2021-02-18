package com.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
    private static ArrayList<Integer> expenses = new ArrayList<Integer>();
    private static Scanner sc = new Scanner(System.in);
    
    // Adds the base expenses to the ArrayList expenses.
    public static void addSampleExpenses() {
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
    }
    
    // Main method to initiate program.
    public static void main(String[] args) {	
        	
        addSampleExpenses();
    	System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }
    
    // Prints the menu of options to the user and prompts them to enter a value. 
    private static void menu() {
    	String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1,2,3,4,5,6};
        int  slen = arr1.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
        }
        
        System.out.println("\nEnter your choice:\t" + System.lineSeparator());

    }
    
    /* Switch statement that acts as the trigger to initiate the specific method requested
     * by the user. The available options are reviewExpenses, addExpenses, deleteExpenses, 
     * sortExpenses, searchExpenses, closeApp, and default (prints a statement indicating 
     * invalid selection).
     */
    
    private static void optionsSelection() {
        
    	menu();

        Scanner sc = new Scanner(System.in);
        int options;
        try {
			do {
			    options =  sc.nextInt();

				switch (options){
			    	case 1:
			    		reviewExpenses(expenses);
			            menu();
			            break;
			        case 2:
			        	addExpenses(expenses);
			            menu();
			            break;
			        case 3:
			        	deleteExpenses(expenses, options);
			            menu();
			            break;
			        case 4:
			            sortExpenses(expenses);
			            menu();
			            break;
			        case 5:
			            searchExpenses(expenses);
			            menu();
			            break;
			        case 6:
			            closeApp();
			            break;
			        default:
			        	System.out.println(System.lineSeparator() + "You have made an invalid choice!" + System.lineSeparator());
			            menu();
			        	break;
			    }
			    
			} while (options != 6);
			
			sc.close();
		} catch (InputMismatchException e) {
			System.out.println("MAIN: Exception in main thread: " + e + "Program shutting down");
		}
        
    }
    
    // Deletes all the values in ArrayList expenses
    private static void deleteExpenses(ArrayList<Integer> arrayList, int options) {
        System.out.println(System.lineSeparator() + "You are about the delete all your expenses! \nConfirm again by selecting the same option..." + 
        		System.lineSeparator());
        int con_choice = sc.nextInt();
        if(con_choice==options){
        	expenses.clear();
            System.out.println(expenses + System.lineSeparator());
            System.out.println("All your expenses are erased!" + System.lineSeparator());
        } else {
            System.out.println("Oops... try again!" + System.lineSeparator());
        }	
    }
    
    // Adds the user entered value into ArrayList expenses
    private static void addExpenses(ArrayList<Integer> arrayList) {
        System.out.println(System.lineSeparator() + "Enter the value to add your Expense:" + System.lineSeparator());
        int value = sc.nextInt();
        expenses.add(value);
        System.out.println(System.lineSeparator() + "Your value is updated" + System.lineSeparator());
        System.out.println(expenses + System.lineSeparator());
    }
    
    // Prints out the contents of ArrayList expenses. 
    private static void reviewExpenses(ArrayList<Integer> arrayList) {
		System.out.println(System.lineSeparator() + "Your saved expenses are listed below:" + System.lineSeparator());
        System.out.println(expenses + System.lineSeparator());
    }
    
    // Closes the application. 
    private static void closeApp() {
        System.out.println(System.lineSeparator() + "Closing your application... \nThank you!");
            }
    
    /* Finished the searchExpenses method. Method searches the contents of ArrayList expenses for
     * the user entered value and if a match is found it switches found to true and then prints that
     * the match was found in the expenses ArrayList. If not match is found a false value for found
     * prints a "no match" message.
     */   
    private static void searchExpenses(ArrayList<Integer> arrayList) {
        System.out.println(System.lineSeparator() + "Enter the expense you need to search:" + System.lineSeparator());
//        Scanner sc = new Scanner(System.in);
        int expense = sc.nextInt();
        
        System.out.println(System.lineSeparator() + "You are searching for: " + expense + System.lineSeparator());
        //TODO: Complete the method
        boolean found = false;
        for (int i = 0; i < expenses.size(); i++) {
        	if (expense == expenses.get(i)) {
        		found = true;
        	} 
        }
        
    	if (found == true) {
    		System.out.println("Found the value requested: " + expense + " is in the expenses list." + 
    				System.lineSeparator());
    	} else {
    		System.out.println("Could not find the value " + expense + " in the expenses list." + 
    				System.lineSeparator());
    	}

    }
    
    /*
     * Finished the sortExpenses method. Iterates through the ArrayList expenses. As it iterates it will
     * check to see if the i value is lower than the j value in the array and if it finds a lower value it
     * will use temporary to store the value in i, switch it with the value in j, then load the original 
     * i value that is stored in temporary into the position the j value was in to reorder the list. 
     */
    private static void sortExpenses(ArrayList<Integer> arrayList) {
        //TODO: Complete the method. The expenses should be sorted in ascending order.
        for (int i = 0; i < expenses.size(); i++) {
        	for (int j = 0; j < expenses.size(); j++) {
        		if (expenses.get(i) < expenses.get(j)) {
					int temporary = expenses.get(i);
					expenses.set(i, expenses.get(j));
					expenses.set(j, temporary);
				}
        	}
        }
        System.out.println(System.lineSeparator() + "Expenses have been sorted in ascending order: " + expenses + System.lineSeparator());
    }
}