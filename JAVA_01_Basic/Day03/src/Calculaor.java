
public class Calculaor {
	//	속성
	int num1,num2;
	
	//	생성자
	public Calculaor() {
		
	}
	
	public Calculaor(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	//	메소드 반환타입 o 매개변수 o
	public int plus(int num1, int num2) {
		return num1 + num2;
	}
	//	메소드 반환타입 x(void) 매개변수 o
	public void minus(int num1, int num2) {
		System.out.println(num1 - num2);
	}
	//	메소드 반환타입 o 매개변수 x
	public int multi() {
		return num1 * num2;
	}
	//	메소드 반환타입 x(void) 매개변수 x
	public void methodInfo() {
		System.out.println("반환타입과 매개변수가 없는 메소드 입니다.");
	}

}
