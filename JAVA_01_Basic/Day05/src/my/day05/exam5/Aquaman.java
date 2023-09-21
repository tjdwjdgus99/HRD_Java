package my.day05.exam5;

public class Aquaman extends Human {
	
	int speed;
	
	//	오버라이딩
	@Override
	public String getInfo() {
		String str = super.getInfo() + "\n속도: " + speed;
		return str;
	
	}
	
	//	메소드 오버로딩
	public String getInfo(int speed) {
		return super.getInfo()+"\n속도: " + speed;
	}
	
}
