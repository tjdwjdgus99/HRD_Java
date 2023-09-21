package ch01.sec09;

public class Exam3 {

	public static void main(String[] args) {
		
		int charCode ='A';	//	65
		int charCode2 = 10;
		double charCode3 = 159.5 ;
		

		if ((charCode>=65) && (charCode <= 90 )) {	//	65이상이고 90 이하라면
			System.out.println("대문자 입니다");
		}
		if ((charCode2>=15) || (charCode3 <= 160 )) {	//	15세 이상이고 160이하일 경우
			System.out.println("놀이기구 탑승가능 입니다");
		}
		if (charCode2 % 2 == 0) {
			System.out.println("짝수 입니다.");
		} else {
			System.err.println("홀수 입니다.");
		}
		
		
		boolean a = (charCode2 % 2 == 0) ? true : false;
		System.out.println(a ? "짝수 입니다." : "홀수 입니다");
		
		//	1번
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.printf("%d %d %d\n",z,x,y);
		
		//	3번
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = (pencils/students);
		System.out.println(pencilsPerStudent);
		
		int pepncilsLeft = (pencils%students);
		System.out.println(pepncilsLeft);
		
		//	4
		int value = 356;
		System.out.println(value/100*100);
		
		//	5
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom) * height / 2.0;
		System.out.println(area);
				
		//	6
		int x2 = 10;
		int y2 = 5;
		System.out.println((x2>7) && (y2<=5));
		System.out.println((x2%3 == 2) || (y2%2 != 1));
				
		//	7
		double x3 = 5.0;
		double y3 = 0.0;
		double z3 = 5 % y3;
		
		if (Double.isNaN(z3)) {
			System.out.println("0.0으로 나눌 수 없습니다.");
		}else {
			double result = z3 + 10;
			System.out.println("결과: " + result);
		}
		
	}

}
