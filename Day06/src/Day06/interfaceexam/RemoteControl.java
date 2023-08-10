package Day06.interfaceexam;

public interface RemoteControl {

	//	상수필드
	
	static final int MAX_VOLUME = 10;
	static final int MIN_VOLUME = 0;
	
	//	추상메소드
	abstract void turnOn();//	abstract 생략가능
	void turnOff();
	void setVolume(int volume);
	
	//	디폴드 메소드
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
			//	추상 메소드 호출하면서 상수 필드 사용
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("무음을 해제합니다");
		}
	}
	
	//	정적 메소드 : 구현 객체 없이 호출 가능
	static void changeBattery() {	//	배터리는 리모콘을 통해 교체할 필요가 없기 때문에
		System.out.println("리모콘 건전지를 교환합니다");
	}
}
