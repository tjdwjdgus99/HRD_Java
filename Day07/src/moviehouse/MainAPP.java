package moviehouse;

public class MainAPP {
	
	static Movie moive;
	
	public static void main(String[] args) throws Exception {
		System.out.println("프로그램을 시작합니다!");
		
		Menu menu = MainMenu.getInstance();
		
		while(menu !=null ) {
			menu.print();
			menu = menu.next();
		}
		
		System.out.println("프로그램을 종료합니다!");
		
	}
}


interface Menu{	//	메뉴로 돌아가기
	
	void print();
	Menu next();	//	이전 메뉴 출력
}