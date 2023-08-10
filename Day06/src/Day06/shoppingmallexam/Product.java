package Day06.shoppingmallexam;

public abstract class Product {	//	상품의 기본 구조와 정보 출력 기능이 있는 추상 클래스
	
	String pname;
	int price;
	
	public void printDetail() {;
		System.out.println("상품명: " + pname + " , ");
		System.out.println("가격: " + price + " , ");
		printExtra();
	}
	public abstract void printExtra();
	
}
