import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
//		for (int i = 1; i <= 10; i++) {
//
//			if (i % 3 == 0) {
//				System.out.printf("짝 ");
//				continue;
//			}
//			System.out.printf("%d ", i);
//
//		}

		boolean bool = true;
		int balance = 0;
		while (bool) {
			System.out.println("----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------------");
			System.out.printf("선택> ");
			int select = scanner.nextInt();
			if (select == 1) {
				System.out.printf("예금액> ");
				int select1 = scanner.nextInt();
				balance += select1;
			} else if (select == 2) {
				System.out.printf("출금액> ");
				int select2 = scanner.nextInt();
				if(balance < select2) {
					System.out.println("잔액이 부족합니다.");
					continue;
				}
				balance -= select2;
			} else if (select == 3) {
				System.out.printf("잔고> ");
				System.out.println(balance);
			} else {
				System.out.printf("프로그램 종료");
				bool = false;
			}
		}
	}
}