package ch01.sec09;

public class Calculator {

	public static void main(String[] args) {

//		double x = 10.3;
//		double y = 20.1;
//		double result = x + y;
//		System.out.println(result);
//		
//		int z;	//	지역변수는 항상 초기화를 해야한다
//		z=0;	//	초기화
//		int zesult2 = z + 10;
//		
		
		float 키 = 200.4f;
		int 몸무게 = 45;
		int 나이 = 20;
		
		System.out.print("키:" + 키 + "\t몸무게:" + 몸무게 + "\t나이:" + 나이 + "\n");
		System.out.printf("키: %5.1f\n" + "몸무게:%d\n" + "나이:%d\n",키 ,몸무게 ,나이);
		
		boolean offset = false;	//	논리형
		
		char var1 = 'A';	//	문자 자료형

		System.out.println(offset);
		System.out.println("\\"+var1);
		
	}

}
