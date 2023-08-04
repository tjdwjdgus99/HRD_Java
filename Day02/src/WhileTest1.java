public class WhileTest1 {

	public static void main(String[] args) {

		int i = 1;
		int sum = 0;
		
		while(i <= 10) {
			sum += i;
			i++;
		}
		System.out.println("1부터 10까지의 합 : "+sum);
		
		i = 10;
		while(i >= 1) {

			System.out.println(i);
			i--;
		}
		//	구구단
		int dan = 2;
		int num = 1;
		while(num < 10) {
			System.out.println( dan + " X " + num + " = " + dan*num );
			num++;
		}
		System.out.println("===============");
		//	구구단
		
		while(dan < 10) {
			num = 1;
			while(num < 10) {
				System.out.println( dan + " X " + num + " = " + dan*num );
				num++;
			}
			System.out.println("===============");
			dan++;
		}

	}
}