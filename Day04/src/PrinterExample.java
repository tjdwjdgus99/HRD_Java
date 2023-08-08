public class PrinterExample {

	public static void main(String[] args) {

		Printer printer = new Printer();

		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");

		Printer.println(10);
		Printer.println(true);
		Printer.println(5.7);
		Printer.println("홍길동");

	}

}

class Printer {
	int a;
	boolean b;
	double c;
	String d;

	public Printer() {

	}

	public Printer(int a) {
		this(a, true, 5.7, "홍길동");
	}

	public Printer(boolean b) {
		this(10, b, 5.7, "홍길동");

	}

	public Printer(double c) {
		this(10, true, c, "홍길동");

	}

	public Printer(String d) {
		this(10, true, 5.7, d);

	}

	public Printer(int a, boolean b, double c, String d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public static void println(int a) {
		System.out.println(a);
	}

	public static void println(boolean b) {
		System.out.println(b);
	}

	public static void println(double c) {
		System.out.println(c);
	}

	public static void println(String d) {
		System.out.println(d);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

}