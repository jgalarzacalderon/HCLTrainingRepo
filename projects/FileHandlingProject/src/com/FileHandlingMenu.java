/**
 * FileHandlingMenu.java contains methods to create, read, write, append, and delete 
 * a .txt file. The class is called by FileHandlingMain.java which contains the main()
 * class of the overall project. 
 * 
 * @author John Galarza-Calderon
 * @version 1.0
 * @since 2021-02-08
 */
package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingMenu {
	
	static Scanner usrIn = new Scanner(System.in);
	
	/*
	 * Method initiates a switch statement that will call other methods in the class depending on the user input
	 * into the console.
	 */
	public static void Menu() {
		
		System.out.println("Welcome to the File Handling Project program.");
		System.out.println("The program will allow you to create, read, write, and append to a txt file");
		System.out.println("Please enter the name of the file you would like to create.");
		
		/* 
		 * Prompts user for input for the file name. Then calls the CreateFile() method that takes the String
		 * entered by the user as a parameter to create the .txt file. 
		 */
		String fileName = usrIn.nextLine();
		fileName = fileName.concat(".txt");
		CreateFile(fileName);
		
		String userCom;;
		/* 
		 * Switch statement that functions as the "menu" for the program.
		 */
		do {
			System.out.println(System.lineSeparator() + "Please type a command: read, write, append, delete, quit");
			System.out.println("NOTE: If user enters 'delete' it will automatically quit the program after file removal finishes.");
			userCom = usrIn.nextLine();
			userCom = userCom.toLowerCase();
			
			switch(userCom) {
			case "write":
				WriteFile(fileName);
				break;
			case "read":
				ReadFile(fileName);
				break;
			case "append":
				AppendFile(fileName);
				break;
			case "delete":
				DeleteFile(fileName);
				userCom = "quit";
				System.out.println(System.lineSeparator() + "No file remaining to operate on.");
				break;
			} 
		} while (userCom.equals("quit") == false);
		
		System.out.println(System.lineSeparator() + "Program closing");
	
	}

	/*
	 * Deletes the file that was originally named at the beginning of the program initiation.
	 */
	private static void DeleteFile(String fileName) {
		// TODO Auto-generated method stub
		File myFile = new File(fileName);
		if (myFile.exists()) {
			myFile.delete();
			System.out.println(System.lineSeparator() + myFile + " Deleted.");
		} else {
			System.out.println(System.lineSeparator() + "File does not exists");
		}		
	}
	/*
	 * Appends user input to the end of the file that was originally created at the beginning of the program initiation. 
	 */
	private static void AppendFile(String fileName) {
		// TODO Auto-generated method stub
		File myFile = new File(fileName);
		System.out.println(System.lineSeparator() + "Please enter the text/data you would like to append to the file.");
		String appendInput= usrIn.nextLine();
		try {
			FileWriter fileWriter = new FileWriter(myFile, true);
			fileWriter.write(System.lineSeparator() + appendInput);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(System.lineSeparator() + "An error occured in the AppendFile class.");
			e.printStackTrace();
		}
	}
	/*
	 * Reads the contents of the file originally created at the beginning of the program initiation to the console.
	 */
	private static void ReadFile(String fileName) {
		// TODO Auto-generated method stub
		File myFile = new File(fileName);
		try {
			Scanner fileScanner = new Scanner(myFile);
			while (fileScanner.hasNextLine()) {
				String data = fileScanner.nextLine();
				System.out.println(data);
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(System.lineSeparator() + "An error has occured in the ReadFile class.");
			e.printStackTrace();
		}
	}
	/*
	 * Writes to, overwrites if the file already exists, the file originally created at the beginning of the program
	 * initiation.
	 */
	private static void WriteFile(String fileName) {
		// TODO Auto-generated method stub
		try {
			File myFile = new File(fileName);
			FileWriter writer = new FileWriter(myFile);
			System.out.println(System.lineSeparator() + "Please enter the text/data you would like to write to the file. Then hit 'Enter' when done.");
			String textToWrite = (System.lineSeparator() + usrIn.nextLine());
			writer.write(textToWrite);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(System.lineSeparator() + "An error has occured in the WriteFile class.");
			e.printStackTrace();
		}
		
	}
	/*
	 * Called in the Menu() method. Takes user entered input as a String and creates a new .txt file if the file does not
	 * already exist. If the file exist, notifies user in console that the file exist. Will also print the absolute path name
	 * of the file to the console for the user. 
	 */
	private static void CreateFile(String fileName) {
		// TODO Auto-generated method stub
		File myFile = new File(fileName);
			try {
				if (myFile.createNewFile()) { 
					System.out.println(System.lineSeparator() + "File created: " + myFile.getName());
				} else { 
					System.out.println(System.lineSeparator() + "File already exists.");
				}
			} catch (IOException e) {
					System.out.println(System.lineSeparator() + "An error occured in the CreateFile class.");
					e.printStackTrace();
			}
			String path = myFile.getAbsolutePath();
			System.out.println(System.lineSeparator() + "File Location " + path);
	}
		
}
	
