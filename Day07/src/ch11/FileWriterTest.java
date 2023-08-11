package ch11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest {

	public static void main(String[] args) throws IOException {

		// 파일에 문자열 입력
		Scanner scanner = new Scanner(System.in);

		File file = new File("test2.txt");
		FileOutputStream fos = new FileOutputStream(file);

		String data = "";
		data = scanner.nextLine();
		fos.write(data.getBytes());
		fos.close();

		// 파일 가져와서 출력
		FileReader fr = new FileReader("C:\\Users\\COMPUTER\\eclipse-workspace\\Day07\\test2.txt");
		BufferedReader br = new BufferedReader(fr);
		String result = null;

		while ((result = br.readLine()) != null) {
			System.out.println(result);
		}

	}
}
