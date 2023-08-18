package ch20;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionExample {
	public static void main(String[] args) throws SQLException {
		// 1. DB연결
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/mydb";
		String id = "root";
		String pwd = "1234";
//		PreparedStatement pst = con.prepareStatement(null);
		PreparedStatement pst2 = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 연결 하기
			con = DriverManager.getConnection(url, id, pwd); // 최상위 클래스
			System.out.println("연결 성공");
			
			//	2. users 테이블에 사용자 정보 저장(데이터 저장)
//			String sql = "INSERT INTO users(userid,username,userpassword,userage,useremail)" 
//					  + " VALUES(?,?,?,?,?)";	//	인 파라미터로 저장
//			
			String sql2 = "INSERT INTO boards(btitle,bcontent,bwriter,bdate,bfilename,bfiledata)" 
					+ " VALUES(?,?,?,now(),?,?)";	//	인 파라미터로 저장
//			
			//	3. 전송 객체
//			pst.setString(1, "spring");
//			pst.setString(2, "봄");
//			pst.setString(3, "12345");
//			pst.setInt(4, 24);
//			pst.setString(5, "spring@mydb.com");
//			
			pst2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			pst2.setString(1, "눈 오는 날");
			pst2.setString(2, "함박눈이 내려요");
			pst2.setString(3, "winter");
			pst2.setString(4, "snow.jpg");
			pst2.setBlob(5, new FileInputStream("snow.jpg"));
			
			//	4. 데이터 전송
			int n = pst2.executeUpdate();
			System.out.println("저장된 행의 수 : " + n);
			
			if(n == 1) {
				System.out.println("저장 성공");
				
				//	현재 row의 bno 값을 확인하기
				ResultSet rs = pst2.getGeneratedKeys();

				if(rs.next()) {
					int no = rs.getInt(1);
//					String title = rs.getString("btitle");
					System.out.println("저장된 bno : " + no);
//					System.out.println("저장된 btitle : " + title);
				}
				rs.close();
			}else {
				System.out.println("저장 실패");
			}
			
			
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.getMessage();
		} finally {
			if (con != null) {
				con.close();
				
				System.out.println("연결 끊기");
			}
		}

	}
}
