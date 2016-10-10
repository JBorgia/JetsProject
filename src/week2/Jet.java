package week2;

import java.util.Date;
import java.util.GregorianCalendar;

public class Jet {
	private String airline = "JAVA";
	private static int vesselNo = 0;
	private String make;
	private String model;
	private int id;
	private int topMPH;
	private float topMach;
	private int maxRangeMiles;
	private int maxCapacity;
	private int cockpitCrewNo;
	private double baseCost;
	private Date purchaseDate;
	private Date serviceDate = new GregorianCalendar(0, 0, 0).getTime();
	private boolean active;
	private int pilots[] = new int[cockpitCrewNo];

	// add jet with only make make and model information and at least make and
	// model information (no 'blank' boats)
	public Jet() {
		this("", "", 0, 0, 0, 0, 0, null, true);
	}

	public Jet(String make, String model, int topMPH, int maxRangeMiles, int maxCapacity, int cockpitCrewNo,
			double baseCost, Date purchaseDate, boolean active) {
		setMake(make);
		setModel(model);
		setId();
		setTopMPH(topMPH);
		setMaxRangeMiles(maxRangeMiles);
		setMaxCapacity(maxCapacity);
		setCockpitCrewNo(cockpitCrewNo);
		setBaseCost(baseCost);
		setPurchaseDate(purchaseDate);
		setServiceDate(serviceDate);
		setActive(active);
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getId() {
		return id;
	}

	// set jet ID based off current vesselNo
	public void setId() {
		this.setId(++vesselNo);
		;
	}

	// override vesselNo and set jet ID based off number passed to method
	public void setId(int num) {
		if (num < 0 || num > 9999) {
			throw new AircraftNumberOutofRange();
		} else {
			this.id = num;
		}
	}

	public int getTopMPH() {
		return topMPH;
	}

	public void setTopMPH(int topMPH) {
		this.topMPH = topMPH;
		setTopMach(topMPH / 661.4714);
	}

	public float getTopMach() {
		return topMach;
	}

	public void setTopMach(double d) {
		this.topMach = (float) d;
		// setTopMPH((int)(d*661.4714));
	}

	public int getMaxRangeMiles() {
		return maxRangeMiles;
	}

	public void setMaxRangeMiles(int maxRangeMiles) {
		this.maxRangeMiles = maxRangeMiles;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getCockpitCrewNo() {
		return cockpitCrewNo;
	}

	public void setCockpitCrewNo(int cockpitCrewNo) {
		this.cockpitCrewNo = cockpitCrewNo;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date object) {
		this.purchaseDate = object;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void display() {
		System.out.println(airline + " Aircraft " + id + "\nManufactured by " + make + "\nModel " + model
				+ "\nTop speed: " + topMPH + "nMPH (Mach " + topMach + ")\nMax rated range: " + maxRangeMiles
				+ " miles\nMaximum passenger load: " + maxCapacity + "\nMinimum cockpit crew personal: "
				+ cockpitCrewNo);
		if (pilots.length != 0) {
			System.out.print("Pilot assigned to aircraft:\n");
			getPilots();
		}
		System.out.println("Base cost: " + baseCost + "\nPurchase date: " + purchaseDate + "\nLast serviced on: "
				+ serviceDate + "\nCurrently active: " + active);
	}

	public void getPilots() {
		for (int i = 0; i < pilots.length; i++) {
			System.out.println("\t" + PersonnelList.getEmployees(pilots[i]).getFirstName() + " "
					+ PersonnelList.getEmployees(pilots[i]).getLastName());
		}
	}

	public void addPilots(int pilotID) {
		int[] pilotsAfter = new int[pilots.length + 1];
		pilotsAfter[pilots.length] = pilotID;

		for (int i = 0; i < pilotsAfter.length - 1; i++) {
			pilotsAfter[i] = pilots[i];
		}
		pilots = pilotsAfter;
	}

	public void setPilots(int[] pilots) {
		this.pilots = pilots;
	}

}
