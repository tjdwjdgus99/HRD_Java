import java.util.Scanner;

public class MemberServiceExample {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Member user1 = new Member("홍길동", "hong");
		MemberService memberservice = new MemberService();

		String id, pw;

		System.out.print("아이디를 입력하세요 : ");
		id = scanner.next();
		System.out.print("비밀번호를 입력하세요 : ");
		pw = scanner.next();

		boolean result = memberservice.login(id, pw);

		if (result) {
			System.out.println( id+"님이 로그인 되었습니다.");
			memberservice.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		

	}

}

class Member {

	String name;
	String id;
	String password;
	String age;

	public Member() {

	}

	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public Member(String name, String id, String password, String age) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}


}

class MemberService{
	String name;
	String id;
	String password;
	String age;
	
	public MemberService() {
		
	}
	public MemberService(String name, String id, String password, String age) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}
	
	public boolean login(String id, String password) {
		if (id.equals("hong") && password.equals("12345")) {
			return true;
		} else {
			return false;
		}
	}

	public void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}
	
	
}
