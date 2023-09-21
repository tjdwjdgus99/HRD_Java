package my.day05.exam9;

import java.util.Scanner;

public class Student extends Person {

	private String sID;
	private String className;
	
	public String personInfo() {
		String info = super.personInfo();	//	이름이 리턴됨
		info += "\n학번: " + sID + "\n수강과목 " + className;
		return info;
	}
	
	public void inputInfo() {
		
		super.inputInfo();
		
		System.out.print("학번을 입력하세요=>");
		Scanner scanner = new Scanner(System.in);
		String sid = scanner.next();
		setId(sid);	//	맴버 변수에 입력값을 저장
		
		System.out.print("수강과목을 입력하세요=>");
		String cn = scanner.next();	//	 맴버 변수에 입력값을 저장
		setClassName(cn);
	}

	@Override
	public String getId() {
		return sID;
	}

	@Override
	public void setId(String id) {
		sID = id;
		
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	


	
}
