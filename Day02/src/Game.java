import java.util.Scanner;

public class Game {

	
	public static void C(int x) {
		if(x==1) {
			System.out.println("가위");
		}
		if(x==2) {
			System.out.println("바위");
		}
		if(x==3) {
			System.out.println("보");
		}
	}
	public static void main(String[] args) {
		
		Game game = new Game();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("==========Game Menu===========");
		System.out.println("1. 가위\t2. 바위\t3. 보\t9. 종료");
		System.out.println("==============================");
		
		int user = 0;
		
		while (user != 9){
			
			int computer = (int)(Math.random()*3)+1;
			
			System.out.print("번호를 입력하세요 : ");
			user = scanner.nextInt();
			
			game.C(user);
			game.C(computer);
			
			if (user == 9) {
				System.out.println("==============================");
				System.out.print("게임을 종료합니다");
				break;
			}
			
			//	1. 비길경우
			if((user == 1 && computer == 1) || (user == 2 && computer == 2) || (user == 3 && computer == 3)) {
				System.out.println("비겼습니다");
			}
			//	2. 내가 이길경우
			else if((user == 1 && computer == 3) || (user == 2 && computer == 1) || (user == 3 && computer == 2)) {
				System.out.println("이겼습니다");
			}
			//	3. 내가 질 경우
			else{
				System.out.println("졌습니다");
			}
		}
		
	}
}