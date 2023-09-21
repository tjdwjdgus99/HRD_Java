package ch11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest {

	public static void main(String[] args) throws IOException {
		File file = new File("test2.txt");
		FileOutputStream fous = new FileOutputStream(file);
		int data = 10;
		
		FileInputStream fis = null;
		
		fous.write(data);

		try {
			fis = new FileInputStream(file);
			int n;
			while ((n = fis.read()) != -1) {
				System.out.print(n);

			}
			System.out.println();
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			fis.close();
			fous.close();
		}
		
	}

}
