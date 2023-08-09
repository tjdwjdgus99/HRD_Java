package my.day05.exam8;

public abstract class Animal {	//	추상 클래스 : 객체를 생성하지 못한다, 적어도 1개의 추상 메소드를 포함해야한다.
	
	String name;
	
	abstract void sound();
	
	public String getName() {
		return name;
	}
}
