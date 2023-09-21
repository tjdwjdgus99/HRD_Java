package my.day05.exam9;

import java.util.Scanner;

public class Staff extends Person{
	
	private String dept;	//	부서
	private String id;	//	사번
	
	public String personInfo() {
		String info = super.personInfo();	//	이름이 리턴됨
		info += "\n부서: " + dept + "\n직원번호 " + id;
		return info;
	}
	
	public void inputInfo() {
		
		super.inputInfo();
		
		System.out.print("부서을 입력하세요=>");
		Scanner scanner = new Scanner(System.in);
		String sid = scanner.next();
		setDept(sid);	//	맴버 변수에 입력값을 저장
		
		System.out.print("직원번호을 입력하세요=>");
		String cn = scanner.next();	//	 맴버 변수에 입력값을 저장
		setId(cn);
	}
	
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String id) {
		this.id = id;
		
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
