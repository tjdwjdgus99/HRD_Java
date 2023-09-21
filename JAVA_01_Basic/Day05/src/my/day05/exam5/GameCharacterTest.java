package my.day05.exam5;

import java.util.ArrayList;

public class GameCharacterTest {

	public static void main(String[] args) {
		Novice novice = new Novice();
		Wizard wizard = new Wizard();
		Knight knight = new Knight();

		ArrayList<Novice> gamelist = new ArrayList<Novice>();
		gamelist.add(novice);
		gamelist.add(wizard);	//	gamelist.add(new Wizard());
		gamelist.add(knight);

		novice.name = "노비";
		novice.hp = 5;
		novice.punch();

		novice.attack("노비", 6);

		wizard.name = "간달프";
		wizard.hp = 100;
		wizard.mp = 500;
		wizard.punch();
		wizard.fireball();

		knight.attack("이순신", 400);
		
		for(Novice n : gamelist) {
		    if (n instanceof Wizard) {
		        ((Wizard) n).fireball();
		    }else if(n instanceof Knight) {
		    	((Knight) n).slash();
		    }
		}

	}

}

class Novice {
	String name;
	int hp;

	public void attack(String name, int hp) {
		this.name = name;
		this.hp = hp;
		punch();
	}

	void punch() {
		System.out.printf("%s(HP : %d)의 펀치!\n", name, hp);
	}
}

class Wizard extends Novice {
	int mp;

	void fireball() {
		System.out.printf("%s(MP : %d)의 불마법!\n", name, mp);

	}
}

class Knight extends Novice {
	int stamina;

	public void attack(String name, int stamina) {
		this.name = name;
		this.stamina = stamina;
		slash();
	}

	void slash() {
		System.out.printf("%s(Slash : %d)의 검공격!\n", name, stamina);

	}

}