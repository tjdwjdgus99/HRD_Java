
public class SingletonFactory {

	// 싱글톤 : 객체를 1개만 만들게 한다
	private SingletonFactory() {
		System.out.println("싱글톤 사용 객체");
	}

	private static SingletonFactory sf = new SingletonFactory();

	static SingletonFactory getInstance() {

		if (sf != null)
			return sf;
		else
			return new SingletonFactory();
	}

}
