package ch19.my.chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class ClientExample {
	
	//	서버
	static ServerSocket server = null;
	//	포트번호
	static final int PORT = 50001;
	//	소켓
	static Socket socket;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("----------------------------");
		System.out.println("서버를 종료하려면 Q 또는 q를 입력하고 Enter 키를 입력하세요");
		System.out.println("----------------------------");
		
		try {
			socket = new Socket("localhost",50001);
			System.out.println("클라이언트와의 접속 성공");
			socket.close();
			System.out.println("클라이언트 연결 끊음");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
