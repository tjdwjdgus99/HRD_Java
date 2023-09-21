
public class Person {
	
	String name = "";
	int age;
	
	public void eat(String sr) {
		System.out.println(sr+"을 먹는다.");
	}
	public void showInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
	
	public static void main(String[] args) {
		
		Person person = new Person();	//	heap메모리에 할당하는 작업, person은 heap메모리의 주소값을 가짐
		Person person2 = new Person();	//	같은 클래스를 가르켜도 서로 주소값이 다름
		
		person.age = 20;
		person.name = "홍길동";
		person.showInfo();
		
		person2.age = 30;
		person2.name = "박길동";
		person2.showInfo();
		
		
	}

}
