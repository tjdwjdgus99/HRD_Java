public class ArrayTest3 {

	public static void main(String[] args) {

		// 2차원 배열...
		// 행열구조( 표 구조 )
		// 2 X 3 행렬 구조
		int arr[][] = new int[2][3];

		arr[0][0] = 20;
		arr[0][1] = 30;
		arr[0][2] = 40;
		arr[1][0] = 50;
		arr[1][1] = 60;
		arr[1][2] = 70;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("arr[" + i + "]" + "arr[" + j + "] = " +arr[i][j]);
			}
		}
		
		

	}

}
