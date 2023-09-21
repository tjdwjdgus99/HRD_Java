package ch19.my.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {

	// 서버
	ServerSocket serverSocket;
	// 10개 스레드로 요청하는 처리하는 스레드풀 생성
	protected ExecutorService executorService = Executors.newFixedThreadPool(100);
	// 소켓
	Socket socket;
	// 소켓 클라이언트를 관리하는 채팅방
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());

	public static void main(String[] args) {

		try {
			ChatServer chatServer = new ChatServer();
			// TCP 서버 시작
			chatServer.startServer();

			System.out.println("------------------------------------------------------------");
			System.out.println("서버를 종료하려면 Q 또는 q를 입력하고 Enter 키를 입력하세요");
			System.out.println("------------------------------------------------------------");
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
			chatServer.stopServer();

		} catch (Exception e) {
			System.out.println("[서버]" + e.getMessage());
		}

	}

	public void startServer() throws Exception {

		// ServerSocket 생성 및 Port 바인딩
		serverSocket = new ServerSocket(50001);
		System.out.println("[서버] 시작됨\n");
		// 작업 스레드 정의
		Thread thread = new Thread(() -> {
			try {

				while (true) {
					System.out.println("\n[서버] 연결 요청을 기다림\n");
					// 연결 수락
					Socket socket = serverSocket.accept(); // 소켓이 입력될때 까지 잠시 멈춤

					SocketClient sc = new SocketClient(this, socket);

					
				}
			} catch (Exception e) {
				System.out.println("[서버] " + e.getMessage());
			}

		});
		// 스레드 시작
		thread.start();
	}

	// SocketClient Map 에 추가, 삭제 메소드 구현
	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("입장 : " + key);
		System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
	}

	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("나감 : " + key);
		System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");

	}

	public void sendToAll(SocketClient sender, String message) {
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();

		Collection<SocketClient> SocketClients = chatRoom.values();
		for (SocketClient sc : SocketClients) {
			if (sc == sender)
				continue;
			sc.send(json);
		}

	}// sendToAll()---

	public void stopServer() {
		try {
			// ServerSocket을 닫고 Port 언바인딩
			serverSocket.close();
			executorService.shutdownNow();
			chatRoom.values().stream().forEach(sc -> sc.close());
			System.out.println("[서버] 종료됨");
		} catch (IOException e1) {
		}

	}

}
