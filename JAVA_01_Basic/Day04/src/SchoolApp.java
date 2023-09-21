import java.util.ArrayList;

public class SchoolApp {

	public static void main(String[] args) {
		
		Student student = new Student();
		student.set학과("정보통신공학과");
		student.setShoolnum("20181476");
		student.set수강과목("자바");
		
		System.out.println("학생1의 학번: " + student.getShoolnum());
		student.showInfo();
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(student);
		list.add(new Student("컴퓨터 공학과", "20220000","파이썬"));
		
		for(Student s : list) {
			s.showInfo();
		}
		System.out.println(list.size());
	}

}
