package my.day05.exam5;

public class SuperMan extends Human {
	
	int power;
	
	//	오버라이딩
	@Override
	public String getInfo() {
		String str = super.getInfo() + "\n초능력: " + power;
		return str;
	
	}
	
}
