public class ForTest {

	public static void main(String[] args) {
		//	1부터 10 까지의 합을 출력하시오. 이때, 출력은 결과 만 출력하기
		//	출력 결과 : 1 - 10까지의 합
		
		int sum = 0;
		
		for(int i = 0; i <10; i++) {
			System.out.println( i + 1 + "Hello JAVA");
			sum += (i + 1);
			
		}
		System.out.printf("1부터 10까지의 합 : " + sum );
		
		//	2. 구구단 2단 출력하기
		//	출력 결과 : 2 X 1 = 1
		int two = 2;
		int gugu = 0;
		for(int i = 0; i <10; i++) {
			gugu = two * i;
			System.out.println( two + " X " + i + " = " + gugu );
			
		}
		//	구구단
		for(int i = 2; i <10; i++) {
			for(int j = 1; j <10; j++) {
				gugu = j * i;
				System.out.println( i + " X " + j + " = " + gugu );
				
			}
			System.out.println("================");
			gugu = 0;
		}
		
		//	구구단
		for(int i = 2; i <10; i++) {
			for(int j = 1; j <10; j++) {
				gugu = j * i;
				System.out.println( i + " X " + j + " = " + gugu );
				
			}
			System.out.println("================");
			gugu = 0;
		}
	}
}