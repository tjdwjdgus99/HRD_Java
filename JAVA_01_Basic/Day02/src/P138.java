public class P138 {

	public static void main(String[] args) {

		//	3
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;

			}

		}
		System.out.println(sum);

		//	6
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println("");
		}
		
		System.out.println("=================");
		
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println("");
		}
		
		System.out.println("=================");
		int add = 0;
		for (int i = 10; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.printf(" ");
			}
			for (int j = i; j <= 10 + add; j++) {
				System.out.printf("*");
			}
			add++;
			System.out.println("");
		}
		
		
	}
}