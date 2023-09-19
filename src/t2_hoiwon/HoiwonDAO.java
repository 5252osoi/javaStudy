package t2_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoiwonDAO {
	Connection conn =null;
	
	public HoiwonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user ="atom";
			String password ="1234";
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색을 못햇서요ㅠ : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동을 못햇서요ㅠ : "+e.getMessage());
			}
	
	}
	//conn객체 closs
	public void connClose() {
		try {
		conn.close();	
		} catch (Exception e) {}
	}
	
	//전체 회원 조회하기
	public void getList() {
		try {
			Statement stmt = conn.createStatement();	//sql에서 찾아오는객체 Statement
			String sql = "select * from hoiwon;";		//sql에서 입력할 문장
			ResultSet rs=stmt.executeQuery(sql);		//sql에서 입력하게만드는 Resultset executeQurery
			
			rs.next();
			System.out.println("번호 : "+rs.getInt("idx"));
			System.out.println("성명 : "+rs.getString("name"));
			System.out.println("나이 : "+rs.getInt("age"));
			System.out.println("주소 : "+rs.getString("address"));
			System.out.println("성별 : "+rs.getString("gender"));
			System.out.println();
			
			rs.next();
			System.out.println("번호 : "+rs.getInt("idx"));
			System.out.println("성명 : "+rs.getString("name"));
			System.out.println("나이 : "+rs.getInt("age"));
			System.out.println("주소 : "+rs.getString("address"));
			System.out.println("성별 : "+rs.getString("gender"));
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : "+e.getMessage());
		}
		
	}

}
