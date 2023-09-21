package ch11;

public class ExceptionExample {

	static void printLength(String data) throws Exception{
//		try {	//	한줄한줄실행
			int result = data.length();
			System.out.println("문자 수: " + result);
			
			Class.forName("java.lang.String");
			System.out.println("java.lang.String 클래스가 존재합니다.");
			
//		}catch (NullPointerException e) {	//	예외
//			System.out.println(e.getMessage());
//		}catch (ClassNotFoundException f) {
//			f.printStackTrace();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {	//	모두 실행
			System.out.println("[마무리실행]");
//		}
	}
	
	public static void main(String[] args) throws Exception{

		printLength("THISISJAVA");
		printLength("THIS IS JAVA!!");
		printLength(null);
		System.out.println("[프로그램 종료]");
	}
}
