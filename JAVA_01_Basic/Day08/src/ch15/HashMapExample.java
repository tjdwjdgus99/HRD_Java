package ch15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap<>();
		
		//	객체 저장
		map.put("홍길동", 85);
		map.put("강길동", 75);
		map.put("부길동", 35);
		map.put("김길동", 71);
		map.put("차길동", 12);
		map.put("박길동", 22);
		
		System.out.println("총 객체수 : " + map.size());
		System.out.println();
		
		//	키로 값 얻기
		String key = "홍길동";
		int value = map.get("홍길동");
		System.out.println(key + " : " + value);
		System.out.println();
		
		//	키를 반복해서 키와 값을 모두 얻기
		Set<String>keySet = map.keySet();
		
		Iterator<String> iterator = keySet.iterator();
		
		while(iterator.hasNext()) {
			String s = iterator.next();
			Integer v = map.get(s);
			System.out.println(s + " : " + v);
		}
		
		map.remove("홍길동");
		System.out.println(map.size());
		
		
		System.out.println("================");
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet) {
			if(entry.getValue() > maxScore) {
				maxScore = entry.getValue();
				name = entry.getKey();
			}
			totalScore += entry.getValue();
			
		}
		
		System.out.println("평균 점수 : " + totalScore/map.size());
		System.out.println("최고 점수 : " + maxScore);
		System.out.println("최고 점수를 받은 아이디 : " + name);
		
	}

}
