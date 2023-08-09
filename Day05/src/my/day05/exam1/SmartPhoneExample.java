package my.day05.exam1;

public class SmartPhoneExample {

	public static void main(String[] args) {
		
		//	객체 생성
		SmartPhone smartPhone  = new SmartPhone("갤럭시", "은색");
		
		//	Phone으로 부터 상속 받은 필드 읽기
		System.out.println("모델: " + smartPhone.model);
		System.out.println("색상: " + smartPhone.color);
		
		//	SmartPhone의 필드 읽기
		System.out.println("와이파이 상태: " + smartPhone.wifi);
		
		//	Phone으로 부터 상속받은 메소드 호출
		smartPhone.bell();
		smartPhone.sendVoice("여보세요: ");
		smartPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		smartPhone.sendVoice("아 네 반갑습니다.");
		smartPhone.hangUp();
		
		//	SmartPhone의 메소드 호출
		smartPhone.setWifi(true);
		smartPhone.internet();

	}

}
