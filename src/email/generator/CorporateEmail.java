package email.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CorporateEmail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> namesList = new ArrayList<String>();
		ArrayList<String> emailsList = new ArrayList<String>();

		// Receives and treats the names
		System.out.println("Please enter the names separated by comma: ");
		// Add on names ArrayList/Convert the list to to Array/Catch the full
		// name/Separate the different names
		namesList.addAll(Arrays.asList(sc.nextLine().split(",")));

		// Receive the domain
		System.out.println("Please enter the company domain (without @): ");
		String domain = (sc.nextLine()).toLowerCase();

		for (String n : namesList) {
			String[] tempNames = n.trim().replaceAll("-", "").split("\\s");

			String email = "";
			String lastName = tempNames[tempNames.length - 1];

			if (tempNames.length > 2) {
				email = (lastName + "." + tempNames[1].charAt(0) + "." + tempNames[0].charAt(0)).toLowerCase();
			} else {
				email = (lastName + "." + tempNames[0].charAt(0)).toLowerCase();
			}

			int c = 1;

			while (emailsList.contains(email + "@" + domain)) {
				c++;
				email = (email.replaceAll("[0-9]", "")) + c;
			}

			emailsList.add(email + "@" + domain);
		}

		for (int count = 0; count < namesList.size(); count++) {
			System.out.println(namesList.get(count).trim() + " <" + emailsList.get(count) + ">");
		}
	}
}
