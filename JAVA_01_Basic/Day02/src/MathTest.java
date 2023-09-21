public class MathTest {

	public static void main(String[] args) throws Exception{
		
		int mx = Math.max(-5, -8);
		System.out.println("8과 -5의 최대 값 : " + mx);

		double mx2 = Math.max(1.23, 3.45);
		System.out.println("1.23과 3.45의 최대 값 : " + mx2);
		System.out.println("5.67과 옮림값 : " + Math.ceil(5.67));
		System.out.println("5.67과 내림값 : " + Math.floor(5.67));
		
		//	문제 1] 3의 7승 값
		double pw = Math.pow(3,7);
		System.out.println("3의 7승 : " + pw);
		
		//	문제 2] 64.0의 제곱근은?
		double sq = Math.sqrt(64.0);
		System.out.println("65.0의 제곱근 : " + pw);

		//	문제 3] 반지름이 5인 원의 면적과 둘레를 계산하시요.
		int radius = 5;
		double area = radius * radius * Math.PI;
		System.out.println("반지름이 "+ radius + "인 원의 면적은 : " + area);
		double area2 = 2 * radius * Math.PI;
		System.out.println("반지름이 "+ radius + "인 원의 면적은 : " + area2);
	}
}