package ch20;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSelectExample {

	// 필드
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	String url = "jdbc:mysql://localhost:3306/mydb";
	String id = "root";
	String pwd = "1234";
	
	String sql = "";

	public UserSelectExample() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,id,pwd);
		System.out.println("연결 성공");
		}catch (Exception e) {
			e.getMessage();
			System.out.println("연결 실패");
		}
	}
	
	//	조회 메소드
	public List<User> selectAll() {
		sql = "SELECT * FROM users";
		List<User> list = new ArrayList<>();
		try {
			pst  = con.prepareStatement(sql);
			rs = pst.executeQuery();
			User user1;
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);
				int age = rs.getInt(4);
				String maile = rs.getString(5);
				user1 = new User(id,name,pwd,age,maile);
				list.add(user1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//	입력
	public void insertsql(User user) throws ClassNotFoundException, SQLException, FileNotFoundException {
	    sql = "INSERT INTO users (userid,username,userpassword,userage,useremail)" 
	            + " VALUES(?,?,?,?,?)";    // 인 파라미터로 저장
	    // 연결 하기
	    pst  = con.prepareStatement(sql);
	    
	    pst.setString(1, user.getUserid());
	    pst.setString(2, user.getUsername());
	    pst.setString(3, user.getUserpassword());
	    pst.setInt(4, user.getUserage());
	    pst.setString(5, user.getUseremail());

	    
	   int result = pst.executeUpdate();
	    try {
	       // insertsql() 메서드 호출
	        if (result == 1) {
	        	System.out.println("데이터 추가 완료");	        	
	        }else {
	        	System.out.println("데이터 추가 실패");	        	
	        	
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}
	//	수정
	
	//	삭제

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException {
		UserSelectExample use = new UserSelectExample();
		
		List<User> list = use.selectAll();
		
		for(User u : list) {
			System.out.println("아이디: " + u.getUserid());
			System.out.println("이름: " + u.getUserpassword());
			System.out.println("패스워드: " + u.getUserpassword());
			System.out.println("나이: " + u.getUserage());
			System.out.println("이메일: " + u.getUseremail());
			System.out.println("");
		}
		// 사용자 정보 객체 생성
	    User user = new User("SUN", "태양", "12345", 30, "Sun@mydb.com");
	    use.insertsql(user); 
	   
	}
}
