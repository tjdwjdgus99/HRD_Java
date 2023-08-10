package Day06.weapon;

public class Knife implements WeaponInterface,KitchenTool{

	@Override
	public void movement() {
		System.out.println("칼이 동작합니다.");
		
	}

	@Override
	public void cooking() {
		// TODO Auto-generated method stub
		System.out.println("요리가 동작합니다.");
		
	}
	
}