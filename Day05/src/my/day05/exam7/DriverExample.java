package my.day05.exam7;

public class DriverExample {

	public static void main(String[] args) {
		
		Drive drive = new Drive();
		
		Bus bus = new Bus();
		drive.dive(bus);
		
		Taxi taxi = new Taxi();
		drive.dive(taxi);
		
		
	}

}
