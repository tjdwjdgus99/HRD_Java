package my.day05;

public class Human {
	
	private String name;
	private int age;
	private String adde;
	
	//	기본
	public Human() {
		
	}
	
	//	인자

	public Human(String name, int age, String adde) {
		super();
		this.name = name;
		this.age = age;
		this.adde = adde;
	}
	public Human(String name, int age) {
		this(name, age, "대전 동구 용운동");
	}

	//	get set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdde() {
		return adde;
	}

	public void setAdde(String adde) {
		this.adde = adde;
	}

	@Override	//	재정의
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", adde=" + adde + "]";
	}
	
	
	
}
