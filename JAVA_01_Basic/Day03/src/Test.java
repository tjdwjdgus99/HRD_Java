import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		boolean bool = true;
		while (bool == true) {

			System.out.println("=============================================");
			System.out.println("1 . 가정용 | 2. 상업용 | 3. 공업용 | 4. 종료");
			System.out.println("=============================================");

			System.out.printf("메뉴를 선택해 주세요 : ");
			int menunum = scanner.nextInt();
			if (menunum >= 4) {
				System.out.printf("프로그램을 종료합니다...");
				break;
			}
			System.out.printf("사용량을 입력해 주세요 : ");
			int used = scanner.nextInt(); // 사용량
			int fare = 0; // 사용요금
			double tax = 0; // 총 수도 요금

			switch (menunum) {
			case 1:
				fare = used * 50;
				tax = used * 0.05;

				break;
			case 2:
				fare = used * 40;
				tax = used * 0.05;

				break;
			case 3:
				fare = used * 30;
				tax = used * 0.05;
				break;
			default:
				bool = false;
				System.out.printf("입력값을 찾을수 없습니다...");
				break;
			}
			double total =tax + fare;
			System.out.println("사용 요금 = " + fare);
			System.out.println("총 수도요금 요금 = " + total + "원");
			
		}

	}

}
