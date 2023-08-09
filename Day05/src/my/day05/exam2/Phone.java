package my.day05.exam2;

public class Phone {

	public String model;
	public String color;
	
	//	인자 생성자
	public Phone() {
		
	}

	public Phone(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

	//	메소드 선언

	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("나 : " + message);
	}
	public void receiveVoice(String message) {
		System.out.println("상대방 : " + message);
	}
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}

}
