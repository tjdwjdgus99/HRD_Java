package moviehouse;

import java.util.Scanner;

public abstract class AbstractMenu implements Menu{
	
	protected String menuText;	//	기본 문구
	protected Menu prevMenu;	//	이전 메뉴
	protected static final Scanner scanner = new Scanner(System.in);
	
	public AbstractMenu(String menuText, Menu preMenu) {	//	생성자
		this.menuText = menuText;
		this.prevMenu = preMenu;
	}
	
	public void print() {	//	메뉴 출력
		System.out.print("\n" + menuText);
	}
	
	public void setPrevMenu(Menu prevMenu) {	//	세터 메소드
		this.prevMenu = prevMenu;
	}
	
}