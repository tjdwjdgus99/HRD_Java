package my.day05.exam9;

import java.util.Scanner;

public abstract class Person {
	
	private String name;	//	이름
	private String id;	//	사번,학번
	
	public abstract String getId();
	public abstract void setId(String id);
	

	//	생성자
	public Person() {
		
	}
	public Person(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	//	사람의 정보를 입력받는 모듈
	public void inputInfo() {
		System.out.print("이름을 입력하세요=>");
		Scanner scanner = new Scanner(System.in);
		name = scanner.next();
	}
	
	//	사람의 정보를 문자열로 반환해주는 메소드
	public String personInfo() {
		String info = "이름: " + name;
		return info;
	}
	//	사람 정보를 콘솔에출력해주는 메소드
	public void printAll() {
		System.out.println(this.personInfo());
		
	}
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {	//	검색 삭제를 위해 반환
		this.name = name;
	}
	
	
}
