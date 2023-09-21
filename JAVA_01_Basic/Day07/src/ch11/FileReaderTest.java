package ch11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\COMPUTER\\eclipse-workspace\\Day07\\src\\ch11\\FileOutputTest.java");
		BufferedReader br = new BufferedReader(fr);
		String result = null;
		
		while((result = br.readLine()) != null) {
			System.out.println(result);
		}

	}

}
