
public class Cafe {

	public static void main(String[] args) {
		CoffeeMachine machine = new CoffeeMachine(2,2,2);
		machine.mackCoffe(1);
		machine.mackCoffe(2, 2);
		
		System.out.println(machine.getSuger());
		machine.setSuger(1);
		System.out.println(machine.getSuger());
	}

}

class CoffeeMachine {

	private int coffee;
	private int cream;
	private int suger;
	
	public CoffeeMachine(){		//기본 생성자
		
	}

	public CoffeeMachine(int coffee, int cream, int suger) {	//인자 생성자: 초기화
		this.coffee = coffee;
		this.cream = cream;
		this.suger = suger;
	}

	// 메소드 오버로딩

	public void mackCoffe(int coffee) {
		System.out.println("아메리카노: " + coffee + "  잔 만듭니다.");
	}

	public void mackCoffe(int coffee, int cream) {
		System.out.println("커피: " + coffee + ", " + "설탕: " + cream + " 커피 만듭니다.");
	}

	public void mackCoffe(int coffee, int suger, int cream) {
		System.out.println("커피: " + coffee + ", " + "크림: " + suger + " 커피 만듭니다.");
	}

	public int getCoffee() {
		return coffee;
	}

	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}

	public int getCream() {
		return cream;
	}

	public void setCream(int cream) {
		this.cream = cream;
	}

	public int getSuger() {
		return suger;
	}

	public void setSuger(int suger) {
		this.suger = suger;
	}

	

}