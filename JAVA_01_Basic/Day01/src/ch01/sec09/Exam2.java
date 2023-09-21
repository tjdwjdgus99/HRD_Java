package ch01.sec09;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int a = 10;
		int b = 20;
		System.out.println(a>b);
		String c = "홍길동";
		String d = "박길동";
		System.out.println(c == d);
		System.out.println(c.equals(d));
		
		System.out.println(c != d);
		System.out.println(!c.equals(d));
		
	}

}
