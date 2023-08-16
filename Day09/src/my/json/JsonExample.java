package my.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonExample {
	public static void main(String[] args) throws IOException {
		// 파일로 부터 JSON 일기

		BufferedReader br = new BufferedReader(new FileReader("member.json"));
		String json = br.readLine();
		br.close();

		// JSON 파싱
		JSONObject root = new JSONObject(json);
		System.out.println("id" + root.getString("id"));
		System.out.println("name" + root.getString("name"));
		System.out.println("age" + root.getInt("age"));
		System.out.println("student" + root.getBoolean("student"));

		// 객새 속성 정보 열기
		JSONObject tel = root.getJSONObject("tel");
		System.out.println("home : " + tel.getString("home"));
		System.out.println("moblie : " + tel.getString("moblie"));

		// 배열 속성 정보 얻기
		JSONArray skill = root.getJSONArray("skill");

		System.out.print("skill : ");
		for (int i = 0; i < skill.length(); i++) {
			System.out.print(skill.get(i) + ", ");

		}

	}
}
