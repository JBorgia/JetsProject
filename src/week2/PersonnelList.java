package week2;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PersonnelList {

	static Employee[] employees;
	static HRDept theOffice;
	private static Date blankDate = new GregorianCalendar(0, 0, 0).getTime();
	private static Scanner kb = new Scanner(System.in);

	public static void generateEmployees() {
		employees = new Employee[] { new Employee("Jimi", "Hendrix", 180000, blankDate, "Sr. Pilot"),
				new Employee("Jim", "Morrison", 150000, blankDate, "Jr. Pilot"),
				new Employee("Jim", "Henson", 80000, blankDate, "Sr. Pilot"),
				new Employee("Def", "Grandma", .01, blankDate, "Sr. Pilot"),
				new Employee("Jim", "Bond", 0.07, blankDate, "Co Pilot") };

		theOffice = new HRDept(employees);
	}

	public static void menu(int choice) {

		switch (choice) {
		case 1:
			theOffice.listEmployees();
			break;
		case 2:
			String fn, ln, ti;
			double salary;
			Date hD;
			System.out.println("Adding new employee. ");
			System.out.print("Enter first name: ");
			fn = kb.next();
			System.out.print("Enter last name: ");
			ln = kb.next();
			System.out.print("Enter salary: ");
			salary = kb.nextDouble();
			System.out.println("Enter hire date");
			int year = 0;
			do {
				System.out.print("\tYear (YYYY): ");
				year = kb.nextInt();
				if (year < 1950) {
					System.out.println("Year of hire must be a 4 digit year after 1950.");
				}
			} while (year < 1950);
			int month = 0;
			do {
				System.out.print("\tMonth (MM): ");
				month = kb.nextInt();
				if (month < 1 || month > 12) {
					System.out.println("Month of hire must be between 1 and 12.");
				}
			} while (month < 1 || month > 12);
			int day = 0;
			do {
				System.out.print("\tDay (DD): ");
				day = kb.nextInt();
				kb.nextLine();
			} while (Checker.validDay(day, month, year));
			hD = new GregorianCalendar(year, month - 1, day).getTime();
			System.out.print("Enter title: ");
			ti = kb.nextLine();
			theOffice.hireEmployee(fn, ln, salary, hD, ti);
			System.out.println(fn + " " + ln + " has been added to the roster.");
			break;
		case 3:
			String fn2, ln2;
			System.out.println("Deleting employee. ");
			System.out.print("Enter first name: ");
			fn2 = kb.next();
			System.out.print("Enter last name: ");
			ln2 = kb.next();
			theOffice.fireEmployee(fn2, ln2);
			System.out.println(fn2 + " " + ln2 + " has been deleted from the roster.");
			break;
		case 4:
			int pilotId = 0, jetId = 0;
			HRDept.listEmployees();
			System.out.print("Enter pilot ID#: ");
			pilotId = kb.nextInt();
			Fleet.listJets();
			System.out.print("Enter aircraft ID#: ");
			jetId = kb.nextInt();
			Fleet.getJet(jetId - 1).addPilots(pilotId);
			System.out.println("Pilot ID#" + pilotId + " has been assigned to aircraft ID#" + jetId);
			break;
		case 5:
			break;
		default:
			System.out.println("That is not a valid choice.");
		}
	}

	public static Employee getEmployees(int i) {
		return employees[i];
	}

	public static void setEmployees(Employee[] employees) {
		PersonnelList.employees = employees;
	}
}