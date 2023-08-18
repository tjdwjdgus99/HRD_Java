package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
	public static void main(String[] args) throws SQLException {
		// 1. DB연결
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/mydb";
		String id = "root";
		String pwd = "1234";
		PreparedStatement pst = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 연결 하기
			con = DriverManager.getConnection(url, id, pwd); // 최상위 클래스
			System.out.println("연결 성공");

			// 2. boards 테이블 정보 수정
//			String sql = "UPDATE boards SET btitle=?,bcontent = ?,bfilename = ?,bfiledata = ? WHERE bno = ?";

			String sql2 = "DELETE from boards where btitle = ?";
			// 3. 전송 객체

			pst = con.prepareStatement(sql2);
			pst.setString(1, "눈사람");
//			pst.setString(2, "눈으로 만든 사람");
//			pst.setString(3, "snowman.jpg");
//			pst.setBlob(4, new FileInputStream("snowman.jpg"));
//			pst.setInt(5, 3);

			// 4. 데이터 전송
			int n = pst.executeUpdate();
			System.out.println("저장된 행의 수 : " + n);

			if (n == 1) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패 해당번호는 존재하지 않습니다.");
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
