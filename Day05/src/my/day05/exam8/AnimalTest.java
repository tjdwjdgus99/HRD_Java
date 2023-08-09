package my.day05.exam8;

public class AnimalTest {
	
	//	매개변수의 다형성...
	static void animalSound(Animal animal) {
		animal.sound();
	}
	
	public static void main(String[] args) {
		
		Animal animal = new Dog();
		animal.name = "강아지";
		animal.sound();
		
		Cat cat =new Cat();
		cat.name = "야옹이";
		cat.sound();
		
		animalSound(animal);
		animalSound(cat);
		
	}

}
