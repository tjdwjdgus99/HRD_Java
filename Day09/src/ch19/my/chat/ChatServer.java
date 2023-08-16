package ch19.my.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

	// 서버
	private static ServerSocket serverSocket = null;
	// 10개 스레드로 요청하는 처리하는 스레드풀 생성
	protected static ExecutorService executorService = Executors.newFixedThreadPool(10);
	// 포트번호
	static final int PORT = 50001;
	// 소켓
	static Socket socket;

	public static void main(String[] args) {

		System.out.println("----------------------------");
		System.out.println("서버를 종료하려면 Q 또는 q를 입력하고 Enter 키를 입력하세요");
		System.out.println("----------------------------");

		// TCP 서버 시작
		startServer();

		// 키보드 입력
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();

		// TCP 서버 종료
		stopServer();

	}

	private static void startServer() {
		// 작업 스레드 정의
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// ServerSocket 생성 및 Port 바인딩
					serverSocket = new ServerSocket(PORT);
					System.out.println("[서버] 시작됨\n");

					while (true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						// 연결 수락
						Socket socket = serverSocket.accept(); // 소켓이 입력될때 까지 잠시 멈춤

						executorService.execute(() -> {
							try {
								// 연결된 클라이언트 정보 얻기
								InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
								System.out.println("[서버]" + isa.getHostName() + "의 연결 요청을 수락함");

								// ------------------------------------------------------
								// 데이터 받기
								DataInputStream dis = new DataInputStream(socket.getInputStream());
								String message = dis.readUTF();
								int data1 = dis.readInt();
								Double data2 = dis.readDouble();

								// 데이터 보내기
								DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
								dos.writeUTF(message);
								dos.writeInt(data1);
								dos.writeDouble(data2);
								dos.flush();
								System.out.println("[서버] 받은 데이터를 다시 보냄: " + message + " , " + data1 + " , " + data2);

								// ------------------------------------------------------
								// 연결 끊기
								socket.close();
								System.out.println("[서버]" + isa.getHostName() + "의 연결을 끊음");
							} catch (IOException e) {
								System.out.println("[서버] " + e.getMessage());
							}

						});
					}

				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		// 스레드 시작
		thread.start();
	}

	private static void stopServer() {
		try {
			// ServerSocket을 닫고 Port 언바인딩
			serverSocket.close();
			executorService.shutdown();
			System.out.println("[서버] 종료됨");
		} catch (IOException e1) {
		}

	}

	public void sendToAll(SocketClient socketClient, String string) {
		// TODO Auto-generated method stub
		
	}

	public void addSocketClient(SocketClient socketClient) {
		// TODO Auto-generated method stub
		
	}

}
