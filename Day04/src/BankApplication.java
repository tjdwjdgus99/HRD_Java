import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {

	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<String> AccountNum = new ArrayList<String>();
	private static ArrayList<String> AccountOwner = new ArrayList<String>();
	private static ArrayList<Integer> money = new ArrayList<Integer>();

	public static ArrayList<String> getAccountNum() {
		return AccountNum;
	}

	public static void setAccountNum(ArrayList<String> accountNum) {
		AccountNum = accountNum;
	}

	public static ArrayList<String> getAccountOwner() {
		return AccountOwner;
	}

	public static void setAccountOwner(ArrayList<String> accountOwner) {
		AccountOwner = accountOwner;
	}

	public static ArrayList<Integer> getMoney() {
		return money;
	}

	public static void setMoney(ArrayList<Integer> money) {
		BankApplication.money = money;
	}

	static void createAccount() { // 1.계좌생성
		System.out.println("-------------------");
		System.out.println("계좌생성");
		System.out.println("-------------------");
		System.out.print("계좌번호: ");
		String a = scanner.next();
		AccountNum.add(a);
		System.out.print("계좌주: ");
		a = scanner.next();
		AccountOwner.add(a);
		System.out.print("초기입금액: ");
		int b = scanner.nextInt();
		money.add(b);
		System.out.println("결과: 계좌가 생성되었습니다");
	}

	static void accountList() { // 2.계좌목록
		if (AccountNum.size() != 0) {
			System.out.println("-------------------");
			System.out.println("계좌목록");
			System.out.println("-------------------");
			for (int i = 0; i < AccountNum.size(); i++) {
				System.out.println(AccountNum.get(i) + "    " + AccountOwner.get(i) + "    " + money.get(i));
			}
		} else {
			System.out.println("계좌가 없습니다.");
		}
	}

	static void deposit() { // 3.예금
		System.out.println("-------------------");
		System.out.println("예금");
		System.out.println("-------------------");
		System.out.print("계좌번호: ");
		String a = scanner.next();
		System.out.print("예금액: ");
		int b = scanner.nextInt();
		int empty = 0; // 맞는 계좌 있는지 확인용
		for (int i = 0; i < AccountNum.size(); i++) {
			if (a.equals(AccountNum.get(i))) {
				int c = money.get(i) + b;
				money.add(i, c);
				empty = 1;
				System.out.println("입금이 성공하였습니다.");
				break;
			}
		}
		if (empty == 0) {
			System.out.println("계좌가 없습니다.");
		}
	}

	static void withdraw() { // 4.출금
		System.out.println("-------------------");
		System.out.println("출금");
		System.out.println("-------------------");
		System.out.print("계좌번호: ");
		String a = scanner.next();
		System.out.print("출금액: ");
		int b = scanner.nextInt();

		for (int i = 0; i < AccountNum.size(); i++) {
			if (a.equals(AccountNum.get(i))) {
				if (money.get(i) <= 0) {
					System.out.println("금액부족..");
					break;
				} else {
					int c = money.get(i) - b;
					money.add(i, c);
					System.out.println("출금이 성공하였습니다.");
					break;
				}
			}

		}

	}
	static void stop() {
		System.out.println("프로그램 종료");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean bool = true;

		while (bool) {
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택> ");

			int num = scanner.nextInt();

			switch (num) {
			case 1:
				createAccount();
				break;
			case 2:
				accountList();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			default:
				stop();
				bool = false;
				break;
			}
		}
	}
}
