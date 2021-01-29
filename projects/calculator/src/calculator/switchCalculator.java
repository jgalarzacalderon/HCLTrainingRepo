package calculator;
import java.util.Scanner;

public class switchCalculator {

	//Welcome message variables
	static String m1 = "Welcome to Simple Arithmetic Calculator!";
	static String m2 = "Please type an operation from the list: +, -, *. /";
	static String m3 = "Type 'q' to quit.";
	//Variable request messages
	static String v1 = "Please enter your first variable.";
	static String v2 = "Please enter your second variable.";
	
	public static void main(String[] args) {
		
		//Declaring scanner and program variables
		Scanner input = new Scanner(System.in);
		double var1 = 0, var2 = 0;
		double sol;
		char arith;
		float cast;
		
		//Print out welcome message and initial directions to user.
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
		/*do-while loop that initiates the calculator to run at least once
		  while running it uses a switch statement and cases to take the user entered operator
		  once user selects an operator it enters the case and requests the variables the user wishes
		  to perform the arithmetic function on. Arithmetic equations follow format a (+,-,*,/) b = sol
		  it then converts the double var sol to a float through type casting. 
		  When user enters 'q' the do-while loop exits and the program quits. */
		
		do {
		
			arith = input.next().charAt(0);

			switch(arith) {
			case '+':
				System.out.println(v1);
				var1 = input.nextDouble();
				System.out.println(v2);
				var2 = input.nextDouble();
				sol = var1 + var2;
				cast = (float)sol;
				System.out.println(cast);
				break;
			case '-':
				System.out.println(v1);
				var1 = input.nextDouble();
				System.out.println(v2);
				var2 = input.nextDouble();
				sol = var1 - var2;
				cast = (float)sol;
				System.out.println(cast);
				break;
			case '*':
				System.out.println(v1);
				var1 = input.nextDouble();
				System.out.println(v2);
				var2 = input.nextDouble();
				sol = var1 * var2;
				cast = (float)sol;
				System.out.println(cast);
				break;
			case '/':
				System.out.println(v1);
				var1 = input.nextDouble();
				System.out.println(v2);
				var2 = input.nextDouble();
				sol = var1 / var2;
				cast = (float)sol;
				System.out.println(cast);
				break;
			case 'q':
				System.out.println("Calculator exiting");
				break;  
			}
		
		} while (arith != 'q');
		
		input.close();
	}
}
