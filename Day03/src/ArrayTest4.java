import java.util.Vector;

public class ArrayTest4 {

	public static void main(String[] args) {

		//	배열 사이즈 변경 불가 해결...
		//	ArrayList 사용
		
		Vector<String> arr = new Vector<String>();
		
		arr.add("JAVA");
		arr.add("재미");
		arr.add("있다");

		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		for(String i : arr) {
			System.out.println(i);			
		}
		
	}
}
