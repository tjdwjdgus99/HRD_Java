import java.util.Scanner;

public class IfTest3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		while (num != 10) {	//	10입력시 정지
			System.out.printf("0~9사이의 정수를 입력하세요 : ");
			num = scanner.nextInt();
			
			 if (num  == 0) {
				System.out.println("0입니다.");
			}
			else if (num % 2 == 0) {
				System.out.println("짝수입니다.");
			}
			else {
				System.out.println("홀수입니다.");
			}
		}

	}
}