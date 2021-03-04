package com.project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FileHandler {

    private static ArrayList<File> files = new ArrayList<File>();
    
    protected static void initalizeFiles() {
       File f1 = new File("test1.txt");
       File f2 = new File("abc2.txt");
       File f3 = new File("zrt3.txt");
       File f4 = new File("test4.txt");
       
       files.add(f1);
       files.add(f2);
       files.add(f3);
       files.add(f4);
       
       for(File f: files) {
    	   try {
    		   f.createNewFile();
    	   } catch (IOException e) {
    		   e.printStackTrace();
    	   }
       }              
    }

    protected void addFile () {

    	System.out.println("Please enter the name of the file including the extension.");
    	String fileName = this.getUserInput();
    	File newFile = new File(fileName);
    	try {
    		if (newFile.createNewFile()) {
    			System.out.println("File created: " + newFile.getName());
    			System.out.println("File path is: " + newFile.getAbsolutePath());
    			files.add(newFile);
    		} else {
    			System.out.println("File already exist.");
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	System.out.print(System.lineSeparator());
    	Menu.showFileMessages();
    }
    
    protected void deleteFile() {
    	 
    	System.out.println("Please enter the name of the file you wish to delete including the extension.");
    	String fileName = this.getUserInput();
    	File deleteFile = new File(fileName);
    	try {
			if (deleteFile.exists()) {
				deleteFile.delete();
				System.out.println("File " + deleteFile + " deleted.");
				files.remove(deleteFile);
			} else {
				System.out.println("File not found. Unable to delete. Please check spelling or if file exists ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.print(System.lineSeparator());
    	Menu.showFileMessages();
    }
    
    protected void deleteFile(File fileName) {
    	
    	File deleteFile = new File(fileName.getName());
    	try {
			if (deleteFile.exists()) {
				deleteFile.delete();
				System.out.println("File " + deleteFile + " deleted.");
				files.remove(deleteFile);
			} else {
				System.out.println("File not found. Unable to delete. Please check spelling or if file exists ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    protected void searchFile() {

    	System.out.println("Please enter the name of the file you wish to search for including the extension.");
    	String fileName = this.getUserInput();
    	File searchFile = new File(fileName);
    	boolean found = false;
    	for (File f: files) {
    		if (f.equals(searchFile)) {
    			found = true;
    		} 
    	}
		if (found == true) {
			System.out.println("File found in directory.");
			System.out.println("File path is : " + searchFile.getAbsolutePath());
		} else {
			System.out.println("File not found in directory.");
		}
    	System.out.print(System.lineSeparator());
    	Menu.showFileMessages();
    }
     
    protected void printFiles() {
    	
    	System.out.println("Printing the files in the directory: " + System.lineSeparator());
		try {
			files.sort(Comparator.naturalOrder());
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * for (File f: files) { System.out.println(f); }
		 */
    	// Lambda expression to print out each file name in the ArrayList of File objects files. 
    	files.forEach((f) -> {System.out.println(f); } );
 
    	System.out.print(System.lineSeparator());
    	Menu.showMainMessages();
    }

	private String getUserInput() {
    	
    	Scanner input = new Scanner(System.in);
    	return input.nextLine();

    	
    }
    
	protected void cleanupFiles() {
		for (File f: files) {
			System.out.println("Deleting:   " + f.getName() + "      file path:     " + f.getAbsolutePath());
			f.delete();
		}
		System.out.println(System.lineSeparator() + "Cleanup complete. Shutting down. Thank you.");
	}
	
}
