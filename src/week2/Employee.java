package week2;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private static int currentID = 0;
	private Date blankDate = new GregorianCalendar(0, 0, 0).getTime();
	private String firstName;
	private String lastName;
	private double salary;
	private Date dateHired;
	private int employeeNumber;
	private String title;
	private boolean currentlyEmployed;
	

	//constructors
	public Employee(String firstName, String lastName, double salary, Date dateHired, String title) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSalary(salary);
		this.setDateHired(dateHired);
		this.setEmployeeNumber(currentID++);
		this.setTitle(title);
		this.setCurrentlyEmployed(true);
	}
	
	//methods
	public void promoteEmployee(double newSalary, String newTitle){
		this.setSalary(newSalary);
		this.setTitle(newTitle);
	}
	
	public void display(){
		System.out.println("Employee ID: " + this.getEmployeeNumber());
		System.out.println("Job Title: " + this.getTitle());
		System.out.println(this.getFirstName() + " " + this.getLastName());
		System.out.println("Salary: " + this.getSalary());
		System.out.println("Date Hired: " + this.getDateHired());
		System.out.println();
	}
	
	//getters and setters	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDateHired() {
		return dateHired;
	}
	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isCurrentlyEmployed() {
		return currentlyEmployed;
	}
	
	public void setCurrentlyEmployed(boolean currentlyEmployed) {
		this.currentlyEmployed = currentlyEmployed;
	}
	//end getters and setters
}
