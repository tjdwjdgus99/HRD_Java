public class ArrayTest1 {

	public static void main(String[] args) {
		//	배열을 이용해서 10개의 정수를 저장하고 , 평균 값을 구하는 프로그램 작성
		
		//	1. 배열 선언
		int [] scores;
		
		//	2. 배열 초기화
		scores = new int[10];
		
		//	3. 명시적 초기화
		scores[0] = 83;
		scores[1] = 43;
		
		//	4. 배열 선언과 초기화 동시에
		int[] scores1 = {83,90,70,60,51,23,52,16,72,35,67};
		
		//	5. 원소의 값을 꺼내서 합산 후, 배열 갯수로 나눈다...
		int sum = 0; 
		scores1[5] = 90;	//	인덱스 5번 수정
		for(int i =0; i < scores1.length; i++) {
			sum += scores1[i];
			System.out.print(scores1[i] + " ");
		}
		System.out.println("");
		System.out.println("평균 : " + sum / scores1.length);
		
	}

}
