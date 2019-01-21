/**
* The Corporate Email program receives a name list and an email domain
*  and creates a corporate email to them.
*
* @author  Fernanda Pereira dos Santos Sousa
* @version 1.0
* @since   2018-01-20 
*/

package email.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorporateEmail {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> namesList = new ArrayList<String>();
	static ArrayList<String> emailsList = new ArrayList<String>();
	static String domain;
	// Regex patterns
	static Pattern pn = Pattern.compile("[^-a-zA-Z ,]");
	static Pattern pd = Pattern.compile("[^a-zA-Z0-9 .]");

	// Receives and treats the names
	public static void receiveNames() {
		System.out.println("Please enter the names separated by comma: ");

		String input = sc.nextLine();
		Matcher mn = pn.matcher(input);

		while (mn.find()) {
			System.out.println("Invalid insert, please enter the names again: ");
			input = sc.nextLine();
			mn = pn.matcher(input);
		}
		// Add on names ArrayList/Convert the list to Array/Catch the full name/Separate the different names
		namesList.addAll(Arrays.asList(input.split(",")));
	}

	// Receive the domain
	public static void receiveDomain() {
		System.out.println("Please enter the company domain (without @): ");

		String input = sc.nextLine();
		Matcher md = pd.matcher(input);

		while (md.find()) {
			System.out.println("Invalid insert, please enter the domain again: ");
			input = sc.nextLine();
			md = pd.matcher(input);
		}
		domain = input.toLowerCase();
	}

	// Creates the corporate email
	public static void createEmail() {
		for (String n : namesList) {
			String[] tempNames = n.trim().replaceAll("-", "").split("\\s");

			String email = "";
			String lastName = tempNames[tempNames.length - 1];

			if (tempNames.length > 2) {
				// Gets the last name + the middle name's first letter + first name's first letter 
				email = (lastName + "." + tempNames[1].charAt(0) + "." + tempNames[0].charAt(0)).toLowerCase();
			} else {
				// Gets the last name + first name's first letter 
				email = (lastName + "." + tempNames[0].charAt(0)).toLowerCase();
			}
			int c = 1;

			while (emailsList.contains(email + "@" + domain)) {
				c++;
				email = (email.replaceAll("[0-9@]", "")) + c;
			}
			emailsList.add(email + "@" + domain);
		}
	}

	public static void main(String[] args) {
		receiveNames();

		receiveDomain();

		createEmail();

		for (int count = 0; count < namesList.size(); count++) {
			System.out.println(namesList.get(count).trim() + " <" + emailsList.get(count) + ">");
		}
	}
}
