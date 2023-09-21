package ch19.my.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class ChatClient {
	public static void main(String[] args) {
		try {
			//Socket 생성과 동시에 localhost의 50001 port로 연결 요청
			Socket socket = new Socket("localhost",50001);
			
			System.out.println("[클라이언트] 연결 성공");
			
			//데이터 보내기
			int data1 = 20;
			double data2 = 15.25;
			
			System.out.print("[클라이언트] 보낼 데이터 입력: ");
			Scanner scanner = new Scanner(System.in);
			String message = scanner.next();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(message);
			dos.writeInt(data1);
			dos.writeDouble(data2);
			dos.flush();
			System.out.println("[클라이언트] 데이터를 보냄: " + message + " , " + data1 + " , " + data2);
			
			//데이터 받기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			message = dis.readUTF();
			int receiveData1 = dis.readInt();
			double receiveData2 = dis.readDouble();
			System.out.println("[클라이언트] 받은 데이터를 다시 보냄: " + message + " , " + receiveData1 + " , " + receiveData2);
			
			//Socket 닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
			
		}catch(UnknownHostException e) {
			//IP 표기 방법이 잘못되었을 경우
		}catch(IOException e) {
			//해당 포트의 서버에 연결할수 없는 경우
		}
		
	}

}