public class WhileTest2 {

	public static void main(String[] args) throws Exception{
		
//		Scanner scanner = new Scanner(System.in);
//		String str = "";
//		while(true) {
//			str = scanner.next();
//			if (str.equals("x") || str.equals("X")) { int a = 1; b =1; 
//				break;
//			}
//		}
//		System.out.println("bye~~~~");
		
		//	임의의 난수를 발생하고 20을 넘으면 종료
		double sum = 0;
		boolean bool = false;
		while(!bool) {
			double ran = Math.random();
			sum += ran;
			Thread.sleep(200);
			System.out.println("sum: " + sum);
			if (sum > 20) {
				break;
			}
		}
	}
}