package ch01.sec09;

import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		String name;
		int age;
		String dept;
		double height;
		
		//	입력 객체 생성
		Scanner scanner = new Scanner(System.in);
		//	데이터 읽어오기
		System.err.print("이름을 입력하세요:>>");
		
		name = scanner.next();
		
		System.err.print("나이를 입력하세요:>>");
		
		age = scanner.nextInt();
		
		System.err.print("키를 입력하세요:>>");
		
		height = scanner.nextDouble();
		
		System.err.print("전공을 입력하세요:>>");
		
		dept = scanner.next();
		
		System.out.printf("%s %d %5.1f %s" ,name,age,height,dept);
		
	}
}
