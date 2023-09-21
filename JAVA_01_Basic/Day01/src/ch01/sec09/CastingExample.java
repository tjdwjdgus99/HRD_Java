package ch01.sec09;

public class CastingExample {

	public static void main(String[] args) {
//		
//		int var1 = 10;
//		byte var2 = (byte)var1;
//		
//		double var3 = 3.14;
//		int var4 = (int)var3;	//	큰 타입에서 작은 타입으로 갈때는 강제 형변환이 필요
//		
//		System.out.println(var3);
//		System.out.println(var4);
//		if(var3 == var4) {
//			System.out.println("두수는 같다");			
//		}else {
//			System.out.println("두수는 같지 않다");
//		}
		
		char v6 = 'A';
		char v7 = 2;
		int result = v6 + v7;
		System.err.println("result: " + result);
		System.err.println("result: " + (char)result);
		System.err.println((int)v6);
		
		int v8 = 10;
		double result2 = v8 / 4.0;
		System.out.println(result2);
	}

}
