package week2;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Fleet {
	static Scanner kb = new Scanner(System.in);
	static Jet fleetJet[];

	public Fleet(Jet[] jets) {
		Fleet.fleetJet = jets;
	}

	public static Jet getJet(int i) {
		return fleetJet[i];
	}

	public static void generateFleet() {
		Date purchased = new GregorianCalendar(1982, 7, 20).getTime();
		Jet aircraft[] = new Jet[] { new Jet("Boeing", "787", 586, 7645, 440, 2, 224_600_000, purchased, true),
				new Jet("Boeing", "777", 587, 10900, 550, 2, 261500000, purchased, true),
				new Jet("Boeing", "747", 594, 8900, 467, 3, 228000000, purchased, true),
				new Jet("Airbus", "A320", 541, 6500, 236, 2, 75100000, purchased, true),
				new Jet("Airbus", "A330", 544, 7250, 300, 2, 231500000, purchased, true) };

		fleetJet = aircraft;
	}

	public static void menu(int choice) {
		switch (choice) {
		case 1:
			listJets();
			break;
		case 2:
			System.out.println("Fastest jet");
			fastest();
			break;
		case 3:
			System.out.println("Jet with longest range");
			range();
			break;
		case 4:
			System.out.println("Add a jet to Fleet");
			addJet();
			break;
		case 5:
			System.out.println("Decommision a jet from Fleet");
			decommissionJet();
			break;
		case 6:
			System.out.println("Error: 6 is not an option for this menu");
			break;
		}

	}

	public static void fastest() {
		int index = 0;
		for (int i = 0; i < fleetJet.length; i++) {
			if (fleetJet[i].isActive()) {
				index++;
			}
		}

		int[] ids = new int[index];
		int[] speedMPH = new int[index];

		index = 0;
		for (int i = 0; i < fleetJet.length; i++) {
			if (fleetJet[i].isActive()) {
				ids[index] = fleetJet[i].getId();
				speedMPH[index++] = fleetJet[i].getTopMPH();
			}
		}

		// bubble sort speedMPH and reorder ids simultaneously
		boolean flag = true;
		int temp;
		int itemp;

		while (flag) {
			flag = false;
			for (int j = 0; j < speedMPH.length - 1; j++) {
				if (speedMPH[j] < speedMPH[j + 1]) {
					temp = speedMPH[j];
					itemp = ids[j];
					speedMPH[j] = speedMPH[j + 1];
					ids[j] = ids[j + 1];
					speedMPH[j + 1] = temp;
					ids[j + 1] = itemp;
					flag = true;
				}
			}
		} // end bubble sort
		System.out.println("Currently active jets, sorted by speed: ");
		for (int i = 0; i < ids.length; i++) {
			// System.out.println(ids[i] - 1);
			System.out.println(Fleet.getJet(ids[i] - 1).toString());
			System.out.println();
		}
	}

	public static void range() {
		int index = 0;
		for (int i = 0; i < fleetJet.length; i++) {
			if (fleetJet[i].isActive()) {
				index++;
			}
		}

		int[] ids = new int[index];
		int[] rangeMiles = new int[index];

		index = 0;
		for (int i = 0; i < fleetJet.length; i++) {
			if (fleetJet[i].isActive()) {
				ids[index] = fleetJet[i].getId();
				rangeMiles[index++] = fleetJet[i].getMaxRangeMiles();
			}
		}

		// bubble sort speedMPH and reorder ids simultaneously
		boolean flag = true;
		int temp;
		int itemp;

		while (flag) {
			flag = false;
			for (int j = 0; j < rangeMiles.length - 1; j++) {
				if (rangeMiles[j] < rangeMiles[j + 1]) {
					temp = rangeMiles[j];
					itemp = ids[j];
					rangeMiles[j] = rangeMiles[j + 1];
					ids[j] = ids[j + 1];
					rangeMiles[j + 1] = temp;
					ids[j + 1] = itemp;
					flag = true;
				}
			}
		} // end bubble sort
		System.out.println("Currently active jets, sorted by range: ");

		for (int i = 0; i < ids.length; i++) {
			// System.out.println(ids[i]-1);
			System.out.println(Fleet.getJet(ids[i] - 1).toString());
			System.out.println();
		}
	}

	public static void addJet() {
		String make = null, model = null, countryManufacture = null;
		char active;
		Jet newJet = new Jet(); // make blank jet to be filled
		// collect information for new plane from user
		System.out.print("Enter jet make: ");
		newJet.setMake(kb.next());
		System.out.print("Enter jet model: ");
		newJet.setModel(kb.next());
		System.out.print("Enter top speed(nMPH): ");
		float speed = kb.nextFloat();
		if (speed <= 6.72) {
			newJet.setTopMach(speed);
		} else {
			newJet.setTopMPH((int) (speed));
		}
		System.out.print("Enter jet range (miles): ");
		newJet.setMaxRangeMiles(kb.nextInt());
		System.out.print("Enter passenger capacity: ");
		newJet.setMaxCapacity(kb.nextInt());
		System.out.print("Enter number of cockpit crew: ");
		newJet.setCockpitCrewNo(kb.nextInt());
		System.out.print("Enter aquisition cost: ");
		newJet.setBaseCost(kb.nextDouble());
		System.out.println("Enter purchase date");
		int year = 0;
		do {
			System.out.print("\tYear (YYYY): ");
			year = kb.nextInt();
			if (year < 1968) {
				System.out.println("Year of purchase must be a 4 digit year after 1968.");
			}
		} while (year < 1968);
		int month = 0;
		do {
			System.out.print("\tMonth (MM): ");
			month = kb.nextInt();
			if (month < 1 || month > 12) {
				System.out.println("Month of purchase must be between 1 and 12.");
			}
		} while (month < 1 || month > 12);
		int day = 0;
		do {
			System.out.print("\tDay (DD): ");
			day = kb.nextInt();
		} while (Checker.validDay(day, month, year));
		Date purchaseDate = new GregorianCalendar(year, month - 1, day).getTime();
		newJet.setPurchaseDate(purchaseDate);
		System.out.print("Will the jet be immediately active (Y/N): ");
		active = kb.next().toUpperCase().charAt(0);
		if (active == 'Y') {
			newJet.setActive(true);
		} else {
			newJet.setActive(false);
		}

		int randomNum = (int)(HRDept.getPersonnelList().length*Math.random());
		newJet.addPilots(randomNum);
		
		Jet[] fleetAfter = new Jet[fleetJet.length + 1];
		fleetAfter[fleetJet.length] = newJet;

		for (int i = 0; i < fleetAfter.length - 1; i++) {
			fleetAfter[i] = fleetJet[i];
		}
		fleetJet = fleetAfter;
	}

	public static void listJets() {
		int index = 0;
		for (int i = 0; i < fleetJet.length; i++) {
			if (fleetJet[i].isActive()) {
				index++;
			}
		}

		int[] ids = new int[index];
		int[] rangeMiles = new int[index];

		index = 0;
		for (int i = 0; i < fleetJet.length; i++) {
			if (fleetJet[i].isActive()) {
				ids[index] = fleetJet[i].getId();
				rangeMiles[index++] = fleetJet[i].getMaxRangeMiles();
			}
		}

		System.out.println("Currently active jets: ");

		for (int i = 0; i < ids.length; i++) {
			Fleet.getJet(ids[i] - 1).display();
			System.out.println();
		}
	}

	public static void decommissionJet() {
		listJets();
		System.out.print("Enter id of jet to decommission: ");
		int id = kb.nextInt() - 1;
		if (id < 0 || id > fleetJet.length) {
			System.out.println("Invalid Jet ID. ");
		} else if (!fleetJet[id].isActive()) {
			System.out.println("Jet has already been retired.");
		} else {
			fleetJet[id].setActive(false);
			System.out.println(fleetJet[id].getId() + ", has been retired.");
		}
	}
}
