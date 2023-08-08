
public class MethodTest {
	
	static final double PI = 3.141592;
	
	//	1. 7단 출력 메소드
	
	public void gugu1() {
		for(int i = 1; i < 10; i++) {
			System.out.println("7 x " + i + " = " + 7*i);
		}
	}
	//	2. 원하는 단을 출력해주는 메서드를 만들어주세요.
	public void gugu1(int num) {
		for(int i = 1; i < 10; i++) {
			System.out.println(num  + " x " + i + " = " + num*i);
		}
	}
	
	public void gugu1(int num,int limit) {
		for(int i = 1; i < 10; i++) {
			System.out.println(num  + " x " + i + " = " + num*i);
		}
	}
	//	3. 원하는 단까지 출력해주는 메서드를 만들어주세요.
	public void gugu3(int num) {
		for(int i = 1; i < num + 1; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.println(i  + " x " + j + " = " + j*i);
				
			}
		}
	}
	//	4. 원하는 이름을 출력해주는 메서드를 만드시오
	public void printName(String name) {
		System.out.println(name);
	}
	//	5. 자신의 이름을 리턴하는 메서드
	public String getName() {
		String name = "성정현";
		return  name;
	}
	//	6. 원하는 수를 제곱해서 리턴해주는 메서드
	public int square(int num1) {
		int result = (int) Math.pow(num1, 2);
		return result;
	}
	
	static double area(double radius) {
		return radius * radius * PI;
	}
	
	public static void main(String[] args) {	//	static 메소드는 프로그램 종료시까지 저장되는 공간
		
		MethodTest met = new MethodTest();	//	힙 메모리 할당 , 초기화
		//		주소값			생성자
		
		System.out.println("1번=============");
		met.gugu1();
		System.out.println("2번=============");
		met.gugu1(3);
		System.out.println("3번=============");
		met.gugu3(5);
		System.out.println("4번=============");
		met.printName("홍길동");
		System.out.println("5번=============");
		String my_name = met.getName();
		System.out.println(my_name);
		System.out.println("6번=============");
		int num1 = met.square(10);
		System.out.println(num1);
		
		System.out.println(MethodTest.area(6.0));
		
	}

}
