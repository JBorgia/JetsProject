package week2;

public class AircraftNumberOutofRange extends RuntimeException {

	public AircraftNumberOutofRange() {
		System.out.println("Aircraft number must be between 0 and 9999.");
	}

	public AircraftNumberOutofRange(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AircraftNumberOutofRange(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public AircraftNumberOutofRange(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AircraftNumberOutofRange(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
