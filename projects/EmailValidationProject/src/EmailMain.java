import java.util.ArrayList;
import java.util.Scanner;

public class EmailMain {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String userIn;

		// Constructs arrayList of Email objects from Email class.
		ArrayList<Email> emailArr = new ArrayList<Email>();

		// Adds initial Email objects and strings to emailArr.
		emailArr.add(new Email("tanya@apple.com", "Tanya"));
		emailArr.add(new Email("raul@gmail.com", "Raul"));
		emailArr.add(new Email("a.j@yu.edu", "AJ"));
		emailArr.add(new Email("jackson34@msn.com", "Jackson"));
		emailArr.add(new Email("john.gc@gmail.com", "John"));
		emailArr.add(new Email("rebecca.b@apple.com", "Rebecca"));
		emailArr.add(new Email("bltsandrp@gmail.com", "Larissa"));
		emailArr.add(new Email("customersupport@tech.co", "Tech Co."));
		emailArr.add(new Email("gedna67@aol.com", "Edna"));
		emailArr.add(new Email("hopeyourdayisgood@gmail.com", "Me to you"));

		System.out.println("\n" + "Welcome! Please type an option from the list of commands provided below.");

		do {
			System.out.println("Command list: ");
			System.out.println("Print email list: print");
			System.out.println("Search emal list: search");
			System.out.println("Enter new email into list: new");
			System.out.println("Quit program: quit" + "\n");

			//Take user input and convert it to lower cases to run through the switch statement below.

			userIn = input.nextLine();
			userIn = userIn.toLowerCase();

			/*Switch statement acts as menu for user to select operations in the program or quit the program.
			  Available operations are: Print, Search, New (new object type Email to arraylist, emailArr), and Quit.
			 */
			switch(userIn) {

			// Prints the arrayList, emailArr, to the console by iterating through the arrayList, emailArr.
			case "print":
				System.out.println("\n" + "Printing emails: " + "\n");
				for(int i = 0; i < emailArr.size(); i++) {
					System.out.println(emailArr.get(i).getEmail());
				}
				System.out.println();
				break;

				// Searches the arrayList, emailArr, based on user entry.
			case "search":
				System.out.println("\n" + "Please enter the email you wish to search for." + "\n");
				String search = input.nextLine();
				search = search.toLowerCase();
				boolean searchValue = false;
				int loc = 0;

				// Searches for the user entered email string by using equals() to compare the string to the email
				// value in the Email object at the specified location. If a match is found changes searchValue to true
				// and breaks the loop to print "Email found." if false will print "Email not found" message.
				for(int i = 0; i < emailArr.size(); i++) {
					searchValue = search.equals(emailArr.get(i).getEmail());
					if (searchValue) {
						loc = i;
						break;
					}
				}
				if (searchValue == true) {
					System.out.println("\n" + "Email found. " + emailArr.get(loc).getName() + " owns the email: " +
							emailArr.get(loc).getEmail() + "\n");
				} else {
					System.out.println("\n" + "Email not found in directory." + "\n");
				}
				break;

				// Enters new email object into arrayList, emailArr, based on user entry.
			case "new":
				int size = emailArr.size();
				emailArr.add(new Email("null", "null"));
				System.out.println("\n" + "Please enter the name of the email owner: " + "\n");
				emailArr.get(size).setName(input.nextLine());
				System.out.println("\n" + "Please enter the email address for " + emailArr.get(size).getName() + "\n");
				emailArr.get(size).setEmail(input.nextLine());
				System.out.println("\n" + "New email added to directory." + "\n" + "Email: " + emailArr.get(size).getEmail() +
						"\n" + "Name: " + emailArr.get(size).getName() + "\n");

			}
			
		} while (userIn.equals("quit") == false);
			System.out.println("\n" + "Program shutting down. Thank you, good-bye!");
			input.close();
	}
}