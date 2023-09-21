public class CalculaorTest {

	public static void main(String[] args) {
		
		Calculaor calculaor1 = new Calculaor();
		Calculaor calculaor2 = new Calculaor(200,300);
		
		//	메소드 호출
		int result = calculaor1.plus(40, 50);
		System.out.println("더하기 : " + result);

		//	빼기 메소드 호출
		calculaor1.minus(40,50);
		
		//	곱하기 메소드 호출
		System.out.println(calculaor2.multi());
		
		//	메소드 정보 출력하는 메소드 호출
		calculaor1.methodInfo();
	}

}
