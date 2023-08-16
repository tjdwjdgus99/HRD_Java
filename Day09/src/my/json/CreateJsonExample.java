package my.json;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {
	public static void main(String[] args) throws IOException {
		//	JSON 객체 생성
		JSONObject root = new JSONObject();
		
		//	속성 추가
		root.put("id","winter");
		root.put("name","한겨울");
		root.put("age",25);
		root.put("student",true);
		
		//	객체 속성 추가
		JSONObject tel = new JSONObject();
		tel.put("home", "042-111-2222");
		tel.put("moblie", "010-3333-4444");
		
		root.put("tel", tel);
		
		JSONArray skill = new JSONArray();
		skill.put("JAVA");
		skill.put("C");
		skill.put("C++");
		skill.put("Python");
		root.put("skill", skill);
	
		//	JSON 객체 얻기
		String  json = root.toString();
		
		//	콘솔로 출력하기
		System.out.println(json);
		
		//	파일로 저장하기
		Writer writer = new FileWriter("member.json",Charset.forName("UTF-8"));
		writer.write(json);
		writer.flush();
		writer.close();
		
		
	}
}
