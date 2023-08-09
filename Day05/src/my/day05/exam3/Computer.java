package my.day05.exam3;

public class Computer extends Calculator {
	
	@Override
	public double areaCicle(double r) {
		System.out.println("Computer 객체의 araCircle()실행");
		return r * r * Math.PI;
	};
}
