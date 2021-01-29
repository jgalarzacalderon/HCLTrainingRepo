package com.example.learnjava;

import java.util.ArrayList;
import java.util.HashMap;

public class LearnJavaApplication {

	public static void main(String[] args) {
		
		ArrayList<HashMap<String, String>> students = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> john = new HashMap<String, String>();
		
		john.put("name", "John");
		
		john.put("address", "123 Main Street");

		john.put("city", "Tampa");
		
		john.put("state", "FL");
		
		john.put("zip", "10000");
		
		students.add(john);

		
		System.out.println(john.get("name"));
		System.out.println(john);
		System.out.println(john.get("city"));

	}
}