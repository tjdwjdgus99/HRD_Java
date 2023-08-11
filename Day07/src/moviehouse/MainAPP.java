package moviehouse;

import java.util.ArrayList;

public class MainAPP {
	
	static Movie moive;
	
	public static void main(String[] args) throws Exception {
		System.out.println("프로그램을 시작합니다!");
		
		ArrayList<Movie> list = Movie.findAll();
		
		for(Movie m : list) {
			System.out.println(m.toString());
		}
		
		System.out.println("프로그램을 종료합니다!");
		
	}
}
