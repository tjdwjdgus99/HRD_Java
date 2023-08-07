import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("6,8번========================================");
		int array[][] = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0, count = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
				sum += array[i][j];
				count += 1;
			}	
			System.out.println("");
		}
		System.out.println("전체 합 :" + sum);
		double avg = (double)sum / count;
		System.out.println("평균 : " + (double)(avg));
		
		System.out.println("7번========================================");
		int max = -1;
		int min = 99999;
		int array1[] = {1,5,3,8,2};
		for(int i = 0; i < array1.length; i++) {
			max = Math.max(max, array1[i]);
			min = Math.min(min, array1[i]);
		}
		
		System.out.println("최댓 값 :" + max);
		System.out.println("최솟 값 :" + min);
		
		System.out.println("9번========================================");
		
		int studentcount = 0;
		int studentarr[]= null;	
		boolean bool = true;
		int max1 = -1;
		double avg1 = 0;
		int sum1 = 0;
		
		while(bool) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("------------------------------------------------------------");
			System.out.print("선택> ");
			int num = scanner.nextInt();
			switch(num) {
			case 1:
				System.out.print("학생수> ");
				studentcount = scanner.nextInt();
				studentarr = new int[studentcount];
				break;
			case 2:
				for(int i = 0; i < studentarr.length; i++) {
					System.out.print("scores["+i + "]" +  "> ");
					studentarr[i] = scanner.nextInt();
				}
				break;
			case 3:
				for(int i = 0; i < studentarr.length; i++) {
					System.out.println("scores["+ i + "]" +  ": " + studentarr[i]);
				}
				break;
			case 4:
				for(int i = 0; i < studentarr.length; i++) {
					max1 = Math.max(max1, studentarr[i]);
					sum1 += studentarr[i];
				}
				avg1 = sum1 / studentcount;
				System.out.println("최고 점수: " + max1);
				System.out.println("평균 점수: " + avg1);
				break;
			case 5:
				bool = false;
				System.out.println("프로그램을 종료합니다....");
				break;
			default:
				bool = false;
				System.out.println("프로그램을 종료합니다....");
				break;
			}
		}
		
		
	}
	
}
