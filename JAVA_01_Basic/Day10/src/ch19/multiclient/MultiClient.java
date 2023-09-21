package ch19.multiclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame implements ActionListener, Runnable {

	// 필드
	JButton btn1, btn2;
	JTextArea jta; // 여러줄 입력 가능 객체
	JTextField jtf; // 한줄 입력 가능 객체

	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;

	JPanel jp;

	// 생성자
	public MultiClient() {
		btn1 = new JButton("전송");
		jta = new JTextArea();
		jtf = new JTextField(20);
		jp = new JPanel();
		jp.setBackground(Color.GRAY);

		setLayout(new BorderLayout());

		jp.add(jtf);
		jp.add(btn1);
		add(jta, "Center");
		add(jp, "South");
		
		btn1.addActionListener(this);

		this.setTitle("멀티 채팅 프로그램_GUI버전");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Thread thread = new Thread(this);
		thread.run();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		String str = e.getActionCommand();	 버튼 이름으로 확인
//		if(str.equals("전송")) {
//			
//		}else if(str.equals("취소")) {
//			
//		}
		Object obj = e.getSource(); // 변수 이름으로 확인
		if (obj == btn1) {
			String result = jtf.getText().toString();
			try {
				dos.writeUTF(result);
				jta.setText("나: " + jtf.getText() + "\n" + jta.getText());
				jtf.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}
		}
	}

	@Override
	public void run() {
		try {
			socket = new Socket("localhost", 9999);// 10.10.108.161
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("[클라이언트] 서버 연결 연결됨");
			
			while(true) {
				String msg = dis.readUTF().toString();
				jta.setText("상대방: " + msg + "\n" + jta.getText());
				System.out.println("Message: " + msg);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new MultiClient();

	}

}
