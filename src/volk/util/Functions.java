package volk.util;

import java.sql.Date;
import java.util.Scanner;

public class Functions {

	static int result;
	static boolean check;
	static Scanner scan;

	public static int getInteger() {
		scan = new Scanner(System.in);
		check = scan.hasNextInt();
		while (!check) {
			System.out.println("Entering value not number");
			scan.next();
			check = scan.hasNextInt();
		}
		result = scan.nextInt();
		return result;
	}

	public static String getString() {
		// Scanner
		scan = new Scanner(System.in);
		String result = null;
		result = scan.nextLine();
		return result;
	}

	public static Date getDate() {
		Date date = null;
		boolean check = true;
		while (check) {
			try {
				System.out.println("Enter date, in format YYYY-MM-DD");
				date = Date.valueOf(getString());
				check = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Repeat enter date");
			}
		}
		return date;
	}

	public static void AllocationMenu() {
		System.out.println("==========================");

	}
}
