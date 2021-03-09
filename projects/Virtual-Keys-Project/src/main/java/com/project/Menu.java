package com.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	private static Scanner input = new Scanner(System.in);
	private static String option;
	private static ArrayList<String> mainMenuOptions = new ArrayList<String>();
	private static ArrayList<String> fileMenuOptions = new ArrayList<String>();
    private static String welcomeText = "Welcome to VirtualKey!";
    private static String developerText = "Developer: John Galarza-Calderon";
    private static FileHandler fHand = new FileHandler();
	
	protected static void addMainMenuMessages() {
		mainMenuOptions.add("1: Show all files in directory.");
		mainMenuOptions.add("2: File options menu.");
		mainMenuOptions.add("3: Quit program.");	
	}
	
	protected static void addFileMenuMessages() {
		fileMenuOptions.add("1: Add a file.");
		fileMenuOptions.add("2: Delete a file.");
		fileMenuOptions.add("3: Search a file.");
		fileMenuOptions.add("4: Return to main menu.");
		fileMenuOptions.add("5: Quit program.");	
	}
	
	protected static void showMainMessages() {
		System.out.println(welcomeText);
		System.out.println(developerText + System.lineSeparator());
		
		for (String s: mainMenuOptions) {
			System.out.println(s);
		}
	}
	
	protected static void showFileMessages() {
		for (String s: fileMenuOptions) {
			System.out.println(s);
		}
	}
	
	protected static void displayWelcomeMenu() {
		//Populate the message arrays with the respective messages
		addMainMenuMessages();
		addFileMenuMessages();
		
		/*
		 * Initiated the MainMenu method to show options to the user and begin receiving
		 * user input
		 */
		displayMainMenu();
	}
	protected static void displayMainMenu() {

		//Show the main menu message to the user.
		showMainMessages();

		try {
			do {
				option = input.nextLine();
				switch (option) {
				case "1":
					System.out.print(System.lineSeparator());
					fHand.printFiles();
					break;
				case "2":
					System.out.print(System.lineSeparator());
					System.out.println("File options menu" + System.lineSeparator());
					displayFileMenu();
					option = "3";
					break;
				case "3":
					System.out.print(System.lineSeparator());
					System.out.println("Quitting program. Cleaning up files created during runtime: " + System.lineSeparator());
					fHand.cleanupFiles();
					option = "3";
					break;
				default:
					System.out.print(System.lineSeparator());
					System.out.println("Invalid input.");
					break;
				}
				
			} while (option.equals("3") == false);
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	protected static void displayFileMenu() {
		String fileOption;
		
		showFileMessages();
		
		try {
			do {
				fileOption = input.nextLine();
				switch (fileOption) {
				case "1":
					System.out.print(System.lineSeparator());
					fHand.addFile();
					break;
				case "2":
					System.out.print(System.lineSeparator());
					fHand.deleteFile();
					break;
				case "3":
					System.out.print(System.lineSeparator());
					fHand.searchFile();
					break;
				case "4":
					System.out.print(System.lineSeparator());
					System.out.println("Returning to main menu." + System.lineSeparator());
					displayMainMenu();
					fileOption = "5";
					break;
				case "5":
					System.out.print(System.lineSeparator());
					System.out.println("Quitting program. Cleaning up files created during runtime: " + System.lineSeparator());
					fileOption = "5";
					option = "3";
					fHand.cleanupFiles();
					break;
				default:
					System.out.print(System.lineSeparator());
					System.out.println("Invalid input" + System.lineSeparator());
					showFileMessages();
					break;
				} 
			} while(fileOption.equals("5") == false);
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}