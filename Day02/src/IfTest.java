import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int score = 101;
		
		while(score != 0) {	//	0입력시 정지
			System.out.print("당신의 점수는? : ");
			score = scanner.nextInt();
			
			if (score >= 90) {
				System.out.println("A");
			} else if (score >= 80){
				System.out.println("B");
			} else if (score >= 70){
				System.out.println("C");
			} else if (score >= 60){
				System.out.println("D");
			} else{
				System.out.println("F");
			}
			
		}
		
	}

}
