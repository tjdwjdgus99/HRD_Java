import java.util.ArrayList;
import java.util.Scanner;

public class JobApp {
	
	//	속성

	public JobApp(){
		
	}
	//	메뉴 메소드
	public void shopMenu() {
		System.out.println("*********JOB v1.1************");
		System.out.println("**1. 구직 등록");
		System.out.println("**2. 구인 등록");
		System.out.println("**3. 구직자 정보 출력");
		System.out.println("**4. 구인회사 정보 출럭");
		System.out.println("**5. 종료");
		System.out.println("*****************************");
		System.out.println("메뉴 번호를 입력하세요=>");
		System.out.println("*****************************");
		
	}
	//	사람의 정보를 입력받는 메소드 반환타입은 문자열, 매개변수는 없는 메소드 타입
	public void inputPerson() {
		Scanner scanner = new Scanner(System.in);
		//	이름, 나이, 성별, 전화번호를 입력받아
		System.out.println("이름 입력 >>>");
		String name = scanner.next();
		System.out.println("나이 입력 >>>");
		int age = scanner.nextInt();

		System.out.println("---성별 메뉴---");
		System.out.println("1.남자 2.여자");
		System.out.println("---------------");
		
		char sex;
		int n = scanner.nextInt();
		if (n == 1) {
			sex = 'M';
		}else {
			sex = 'F';
		}
		System.out.println("전화번호 입력 >>>");
		String tel = scanner.next();
		
		Person person = new Person(name,age,sex,tel);
		
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(person);
		
		//	메소드 내에서 메소드 호출
		String result = person.showProfile();
		System.out.println(result);
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		JobApp jap = new JobApp();
		jap.shopMenu();
		
		int num = scanner.nextInt();
		
		if(num == 5) {
			System.out.println("정상종료~~");
			System.exit(0);
		}else if(num == 1) {
			jap.inputPerson();
		}
		

	}

}
