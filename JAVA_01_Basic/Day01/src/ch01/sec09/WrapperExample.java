package ch01.sec09;

public class WrapperExample {

	public static void main(String[] args) {
		
		String str = "100";
		int value1 = Integer.parseInt(str);
		
		double value2 = Double.parseDouble("3.14");
		
		System.out.println(value1 + 100);
		System.out.println(value2 + 100);
	}
}
