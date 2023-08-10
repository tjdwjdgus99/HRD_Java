package Day06.weapon;

public class Game {

	public static void main(String[] args) {
		
		WeaponInterface weapon = null;
		
		weapon = new Gun();
		
		weapon.movement();
		
		weapon = new Bow();
		
		weapon.movement();
		
		KitchenTool kit = null;
		kit = new Knife();
		
		kit.movement();
		
		
	}
}