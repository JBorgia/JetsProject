package week2;

public class TestJet {
	public static void main(String[] args) {
		PersonnelList.generateEmployees();
		Fleet.generateFleet();
		System.out.println("\t" + PersonnelList.getEmployees(1).getFirstName() + " " + PersonnelList.getEmployees(1).getLastName());
		Menu.setChoice();
	}
}
