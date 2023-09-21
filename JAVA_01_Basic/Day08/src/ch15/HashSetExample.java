package ch15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("JAVA");
        set.add("JDBC");
        set.add("JSP");
        set.add("JAVA");    // 중복 개체는 저장하지 않음
        set.add("SPRING");

        // 저장된 클래스 출력
        int size = set.size();
        System.out.println("총 객체수 : " + size);

        // 객체를 하나씩 가져와서 처리
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if (element.equals("JSP")) {
                iterator.remove();
            }
        }

        for (String element : set) {
            System.out.println(element);
        }

    }
}
