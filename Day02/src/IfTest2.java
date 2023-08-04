public class IfTest2 {

	public static void main(String[] args) {
		
		//	난수 생성 Math.random() 0.0이상 ~ 1.0미만
		int n = (int)(Math.random()*6) + 1;
		switch (n) {
			case 1:
				System.out.println("1이 나왔습니다.");
				break;
			case 2:
				System.out.println("2이 나왔습니다.");
				break;
			case 3:
				System.out.println("3이 나왔습니다.");
				break;
			case 4:
				System.out.println("4이 나왔습니다.");
				break;
			case 5:
				System.out.println("5이 나왔습니다.");
				break;
			case 6:
				System.out.println("6이 나왔습니다.");
				break;
			default:
				System.out.println("값이 존재하지 않습니다.");
				break;
		}
	}
}