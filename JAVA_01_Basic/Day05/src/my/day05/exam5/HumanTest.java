package my.day05.exam5;

public class HumanTest {

	public static void main(String[] args) {
		
		Human su = new SuperMan();	//	자동 형변환(업캐스팅)
		
		su.name = "슈퍼맨";
		su.height = 190;
		((SuperMan)su).power = 500;	//	강제 형변환(다운 캐스팅)
		String result = su.getInfo();
		System.out.println("---슈퍼맨의 정보---");
		System.out.println(result);

		Human aq = new Aquaman();
		aq.name = "아쿠아맨";
		aq.height = 180;
		((Aquaman)aq).speed = 3000;
		String result1 = aq.getInfo();
		System.out.println("---아쿠아맨의 정보---");
		System.out.println(result1);
	}

}
