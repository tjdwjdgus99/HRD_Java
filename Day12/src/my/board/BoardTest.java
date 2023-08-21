package my.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardTest {
	Scanner scanner = new Scanner(System.in);
	// 필드
	Connection con = null; // 자바와 db를 연결하는 객체
	PreparedStatement pst = null; // sql ???를 입력받음

	String url = "jdbc:mysql://localhost:3306/mydb";
	String id = "root";
	String pwd = "1234";

	ResultSet rs = null; // db에서 찾은 결과값 저장하는 객체
	String sql = "";
	boolean loginok = false;

	private String loggedInUserId = "";
	private String loggedInUserName = "";

	// 생성자
	public BoardTest() {
		connect();
	}

	public void connect() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("연결 성공 ");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// 게시물 전체 조회
	public void list() throws SQLException {
		try {

			sql = "SELECT * FROM boards ORDER BY bno DESC";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			System.out.println();
			System.out.println("[게시물 목록]");
			System.out.println("-----------------------------------------------------------");
			System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
			System.out.println("-----------------------------------------------------------");

			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontect(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));

				System.out.printf("%-6s%-12s%-16s%-40s \n", board.getBno(), board.getBwriter(), board.getBdate(),
						board.getBtitle());

			}
			rs.close();
			pst.close();

		} catch (Exception e) {
			e.getMessage();
		}
		mainMenu();
	}

	public void mainMenu() throws SQLException {
		if (loginok == false) {
			System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.Login | 6.Exit");
			System.out.print("메뉴 선택: ");
			String menuNo = scanner.nextLine();
			System.out.println();

			switch (menuNo) {
			case "1" -> create();
			case "2" -> read();
			case "3" -> clear();
			case "4" -> Join();
			case "5" -> Login();
			case "6" -> exit();
			}

		} else {
			if (loginok) {
				System.out.println();
				System.out.printf("[게시물 목록] 사용자: " + loggedInUserName + "\t" + "아이디: " + loggedInUserId + "\n");
			}
			System.out.println("-----------------------------------------------------------");
			System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Logout | 5.Exit");
			System.out.print("메뉴 선택: ");
			String menuNo = scanner.nextLine();
			System.out.println();

			switch (menuNo) {
			case "1" -> create();
			case "2" -> read();
			case "3" -> clear();
			case "4" -> Logout();
			case "5" -> exit();
			}
		}
	}

	public void create() throws SQLException {
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.printf("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.printf("내용: ");
		board.setBcontect(scanner.nextLine());
		System.out.printf("작성자: ");
		board.setBwriter(scanner.nextLine());

		// 보조 메뉴 출력

		System.out.println("-----------------------------------------------------------");
		System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
		System.out.printf("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if (menuNo.equals("1")) {
			// boards 테이블에 게시물 정보 저장
			try {
				String sql = "INSERT INTO boards( btitle, bcontent, bwriter, bdate) VALUES(?, ?, ? , now())";
				pst = con.prepareStatement(sql);
				pst.setString(1, board.getBtitle()); // 매개변수 인 파라미터 값의 갯수는 1부터 시작
				pst.setString(2, board.getBcontect());
				pst.setString(3, board.getBwriter());

				pst.executeUpdate();
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		} else {
			System.out.println("취소하였습니다.");
		}
		list();

	}

	public void read() {
		System.out.println("[게시물 읽기]");
		System.out.printf("bno: ");
		int bno = Integer.parseInt(scanner.nextLine());
//		scanner.nextInt();	만사용하면 앞입력에서 엔터를 사용하게 되면 nextLine의 오류가 걸린다 해결법 : 다음 라인에 scanner.nextLine 추가

		// boards 테이블에서 해당 게시물을 가져와 출력
		try {
			String sql = "SELECT * FROM boards WHERE bno=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, bno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontect(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println("############");
				System.out.println("번호: " + board.getBno());
				System.out.println("제목: " + board.getBtitle());
				System.out.println("내용: " + board.getBcontect());
				System.out.println("작성자: " + board.getBwriter());
				System.out.println("날짜: " + board.getBdate());
				System.out.println("############");
				// 보조 메뉴 출력
				System.out.println("-----------------------------------------------------------");
				System.out.println("보조 메뉴: 1. Update | 2. Delect | 3. List");
				System.out.printf("메뉴 선택: ");
				String menuNo = scanner.nextLine();
				System.out.println();

				if (menuNo.equals("1")) {
					update(board);
				} else if (menuNo.equals("2")) {
					delete(board);
				} else if (menuNo.equals("3")) {
					list();
				}
			}
			rs.close();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
	}

	// 수정
	public void update(Board board) throws SQLException {
		System.out.println("[수정 내용 입력]");
		System.out.printf("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.printf("내용: ");
		board.setBcontect(scanner.nextLine());
		System.out.printf("작성자: ");
		board.setBwriter(scanner.nextLine());

//		보조 메뉴 출력
		System.out.println("-----------------------------------------------------------");
		System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
		System.out.printf("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		if (menuNo.equals("1")) {
			try {
				String sql = "UPDATE boards SET btitle=?, bcontent=?, bwriter=? WHERE bno = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, board.getBtitle()); // 매개변수 인 파라미터 값의 갯수는 1부터 시작
				pst.setString(2, board.getBcontect());
				pst.setString(3, board.getBwriter());
				pst.setInt(4, board.getBno());
				pst.executeUpdate();
				pst.close();

			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}

		}
		list();

	}

	// 삭제
	public void delete(Board board) throws SQLException {
		try {
			String sql = "DELETE FROM boards WHERE bno=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, board.getBno());
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		list();
	}

	public void clear() throws SQLException {
		System.out.println("[게시물 전체 삭제]");
		System.out.println("-----------------------------------------------------------");
		System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
		System.out.printf("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		if (menuNo.equals("1")) {
			try {
				String sql = "TRUNCATE TABLE boards";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
				pst.close();

			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	public void Join() throws SQLException { // 회원가입
		Users user = new Users();
		System.out.println("[새 사용자 입력]");
		System.out.printf("아이디: ");
		user.setUserid(scanner.nextLine());
		System.out.printf("이름: ");
		user.setUsername(scanner.nextLine());
		System.out.printf("비밀번호: ");
		user.setUserpassword(scanner.nextLine());
		System.out.printf("나이: ");
		user.setUserage(scanner.nextInt());
		scanner.nextLine();
		System.out.printf("이메일: ");
		user.setUseremail(scanner.nextLine());

		sql = "INSERT INTO users (userid,username,userpassword,userage,useremail) VALUES(?,?,?,?,?)";
		pst = con.prepareStatement(sql);
		pst.setString(1, user.getUserid());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getUserpassword());
		pst.setInt(4, user.getUserage());
		pst.setString(5, user.getUseremail());

//		보조 메뉴 출력
		System.out.println("-----------------------------------------------------------");
		System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
		System.out.printf("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		if (menuNo.equals("1")) {
			try {
				System.out.println("** 회원가입 완료 **");
				pst.executeUpdate();
				pst.close();

			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}

		}
		list();

	}

	public void Login() throws SQLException {
		Users user = new Users();
		System.out.println("[로그인]");
		System.out.printf("아이디: ");
		user.setUserid(scanner.nextLine());
		System.out.printf("비밀번호: ");
		user.setUserpassword(scanner.nextLine());

		sql = "SELECT * FROM users WHERE userid=?";

		pst = con.prepareStatement(sql);

		pst.setString(1, user.getUserid());

		// 보조 메뉴 출력
		System.out.println("-----------------------------------------------------------");
		System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
		System.out.printf("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		if (menuNo.equals("1")) {
			try {
				rs = pst.executeQuery();
				if (rs.next()) {
					String dbpw = rs.getString("userpassword");
					if (dbpw.equals(user.getUserpassword())) {
						System.out.println("** 로그인 완료 **");
						loggedInUserId = rs.getString("userid");
						loggedInUserName = rs.getString("username");
						loginok = true;
						list();
					} else {
						System.out.println("비밀번호가 틀렸습니다.");
					}
				} else {
					System.out.println("아이디가 존재하지 않습니다.");
				}

				rs.close();
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	public void Logout() throws SQLException {
		System.out.println("로그아웃 되었습니다.");
		mainMenu();
	}

	public void exit() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		System.out.println("** 게시판 종료 **");
		System.exit(0); // 정상 종료
	}

	public static void main(String[] args) throws SQLException {
		BoardTest boardTest = new BoardTest();
		boardTest.list();
	}
}
