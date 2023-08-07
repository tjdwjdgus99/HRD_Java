
public class AICarTest {

	public static void main(String[] args) {
		
		Person hong = new Person();
		Car sportsCar = new Car();
		Car sedanCar = new Car(1000,"검정");
		
		hong.age = 20;
		hong.name = "홍길동";
		
//		sportsCar.run(50);
//		sedanCar.run(50);
		
		System.out.println(sportsCar.speed);
		
		System.out.println(sedanCar.speed);
		System.out.println(sedanCar.color);

		
		hong.eat();
		hong.smile();
		

	}

}
