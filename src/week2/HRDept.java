package week2;

import java.util.Date;

public class HRDept {
	private static Employee[] personnel;

	// constructors
	public HRDept() {
		personnel = new Employee[0];

	}

	public HRDept(Employee[] employees) {
		personnel = employees;
	}

	// methods
	public void hireEmployee(String firstName, String lastName, double salary, Date dateHired, String title) {

		Employee n = new Employee(firstName, lastName, salary, dateHired, title);
		Employee[] after = new Employee[personnel.length + 1];

		after[personnel.length] = n;

		for (int i = 0; i < after.length - 1; i++) {
			after[i] = personnel[i];
		}
		personnel = after;
	}

	public void fireEmployee(int id) {
		if (id < 0 || id >= personnel.length) {
			System.out.println("Invalid Employee ID. ");
		} else if (!personnel[id].isCurrentlyEmployed()) {
			System.out.println("Employee has already been terminated. ");
		} else {
			personnel[id].setCurrentlyEmployed(false);
			System.out.println(personnel[id].getFirstName() + ", you are fired! ");
		}
	}

	public void fireEmployee(String firstName, String lastName) {
		for (int i = 0; i < personnel.length; i++) {
			if (firstName.equals(personnel[i].getFirstName()) && lastName.equals(personnel[i].getLastName())) {
				fireEmployee(i);
			}
		}
	}

	public void promoteEmployee(int id, double newSalary, String newTitle) {
		if (id < 0 || id >= personnel.length) {
			System.out.println("Invalid Employee ID. ");
		} else if (!personnel[id].isCurrentlyEmployed()) {
			System.out.println("Employee has already been terminated. ");
		} else if (newTitle == null || newTitle == "") {
			System.out.println("No title provided. No action taken.");
		} else {
			personnel[id].promoteEmployee(newSalary, newTitle);
			System.out.println(personnel[id].getFirstName() + " has been promoted to " + newTitle + " making "
					+ newSalary + " per year.");
		}

	}

	public static void listEmployees() {
		int[] ids;
		double[] salaries;
		int index = 0;
		for (int i = 0; i < personnel.length; i++) {
			if (personnel[i].isCurrentlyEmployed()) {
				index++;
			}
		}
		
		ids = new int[index];
		salaries = new double[index];

		index = 0;
		for (int i = 0; i < personnel.length; i++) {
			if (personnel[i].isCurrentlyEmployed()) {
				ids[index] = personnel[i].getEmployeeNumber();
				salaries[index++] = personnel[i].getSalary();
			}
		}
		
//		//bubble sort salaries and reorder ids simultaneously
//		boolean flag = true;
//		double temp;
//		int itemp;
//		
//		while(flag){
//			flag = false;
//			for(int j = 0; j < salaries.length - 1; j++){
//				if(salaries[j] < salaries[j + 1]){
//					temp = salaries[j];
//					itemp = ids[j];
//					salaries[j] = salaries[j+1];
//					ids[j] = ids[j+1];
//					salaries[j+1] = temp;
//					ids[j+1] = itemp;
//					flag = true;
//				}
//			}
//		}//end bubble sort
		
		System.out.println("Current Employees: ");
		for (int i = 0; i < ids.length; i++){
			personnel[ids[i]].display();
		}
	}

	public void promoteEmployee(String firstName, String lastName, double newSalary, String newTitle) {
		for (int i = 0; i < personnel.length; i++) {
			if (firstName.equals(personnel[i].getFirstName()) && lastName.equals(personnel[i].getLastName())) {
				promoteEmployee(i, newSalary, newTitle);
			}
		}
	}

	public static Employee getPersonnel(int i) {
		return personnel[i];
	}
	
	public static Employee[] getPersonnelList() {
		return personnel;
	}

}
