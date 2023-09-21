package Day06.interfaceexam;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc;
		
		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
		rc.setVolume(15);
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(3);
		rc.setVolume(-3);
		rc.turnOff();
		
		rc.setMute(true);
		rc.setMute(false);
		
		RemoteControl.changeBattery();
	}

}
