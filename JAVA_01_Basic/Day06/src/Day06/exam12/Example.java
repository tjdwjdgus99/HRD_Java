package Day06.exam12;

public class Example{
	
	public static void action(A a) {	//	부모 타입을 불러옴
		a.method1();
		if( a instanceof C) {	//	C 객체일 경우에만
			((C)a).method2();	//	강제 형변환
		}
		if( a instanceof C c) {	//	C 객체일 경우에만
			c.method2();
		}
	}
	
	public static void main(String[] args) {	
		action(new A());
		action(new B());
		action(new C());
	}
}
