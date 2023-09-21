package ch11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyResource {

	private String name;

	private MyResource(String name) {
		this.name = name;
		System.out.println("[My Resource(" + name + ") 열기]");
	}

	public String read1() {
		System.out.println("[My Resource(" + name + ") 읽기]");
		return "100";
	}

	public String read2() {
		System.out.println("[My Resource(" + name + ") 읽기]");
		return "abc";
	}

	public void close() {
		System.out.println("[My Resource(" + name + ") 닫기]");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			int n;
			while ((n = fis.read()) != -1) {
				System.out.print((char) n);

			}
			System.out.println();
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			fis.close();
		}

		MyResource myResource = new MyResource("test");
//		System.out.println(myResource.read1());
//		System.out.println(myResource.read2());
//		myResource.close();
	}

}
