package ch01.sec09;

import java.util.Scanner;

public class TestExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int midScore;
		int finalScore;
		
		System.out.print("학기 전 홍팍이의 중간점수 : ");
		midScore = scanner.nextInt();
		System.out.print("학기 전 홍팍이의 기말점수 : ");
		finalScore = scanner.nextInt();
		
		System.out.println("학기 전 홍팍이의 중간점수 : ");
		System.out.println(midScore);
		System.out.println("학기 전 홍팍이의 기말점수 : ");
		System.out.println(finalScore);
		
	}

}
