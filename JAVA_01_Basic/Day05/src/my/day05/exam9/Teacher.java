package my.day05.exam9;

import java.util.Scanner;

public class Teacher extends Person {
	private String tId;
	private String subject;
	
	public String personInfo() {
		String info = super.personInfo();	//	이름이 리턴됨
		info += "\n교번: " + tId + "\n강의과목 " + subject;
		return info;
	}
	
	public void inputInfo() {
		
		super.inputInfo();
		
		System.out.print("교번을 입력하세요=>");
		Scanner scanner = new Scanner(System.in);
		String sid = scanner.next();
		settId(sid);	//	맴버 변수에 입력값을 저장
		
		System.out.print("강의과목을 입력하세요=>");
		String cn = scanner.next();	//	 맴버 변수에 입력값을 저장
		setSubject(cn);
	}
	
	@Override
	public String getId() {
		return tId;
	}

	@Override
	public void setId(String id) {
		tId = id;
		
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	

	
	
}
