package moviehouse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Movie {
	private long id; // 영화 대푯값
	private String title; // 영화 제목
	private String genre; // 영화 장르
	private static final File file = new File("movies.txt");
	
	public Movie(long id, String title, String genre) {
		this.id = id;
		this.title = title;
		this.genre = genre;
	}

	public static ArrayList<Movie> findAll() throws IOException {//	예외 발생시 호출 위치로 전달
		ArrayList<Movie> movies = new ArrayList<Movie>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = br.readLine()) != null) { // 파일을 한 행씩 읽어와 반복
			String[] temp = line.split(","); // 쉼표를 기준으로 문자열을 나눔
			Movie m = new Movie( // 영화 객체 생성
					Long.parseLong(temp[0]), // 영화 대푯값
					temp[1], // 영화 제목
					temp[2] // 영화 장르
			);
			movies.add(m); // 생성 영화 객체를 arraylist에 추가
		}
		br.close();
		return movies;
	}

	public String toString() {	//	모든 영화 정보를 arraylist에 담아 반환
		return String.format("[%d]: %s(%s)", id, title, genre);
	}

}
