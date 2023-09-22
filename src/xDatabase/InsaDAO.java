package xDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InsaDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql="";
	InsaVO vo=null;

	public InsaDAO() {
		String url ="jdbc:mysql://localhost:3306/javaProject";
		String user="root";
		String password="1234";
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace(); //데이터베이스연결실패
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			e.printStackTrace(); //드라이버검색실패
		}
	}
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	public void pstmtClose() {
		try {
			if(pstmt!=null);
		} catch (Exception e) {}
	}
	public void rsClose() {
		try {
			if(rs!=null) rs.close();
		} catch (Exception e) {}
		pstmtClose();
	}
	
	//회원명 검색 (회원중복처리)
	public InsaVO getNameSearch(String name) {
		vo=new InsaVO();
		try {
			sql="select*from insa where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
				
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
			
		} catch (Exception e) {
			System.out.println("SQL 오류 : "+e.getMessage());
//			e.printStackTrace();
		}finally {
			rsClose();
		}
		return vo;
	}
	//회원가입처리
	public int setInsaInput(InsaVO vo) {
		int res=0;
		try {
			sql="insert into insa value(default,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
//			System.out.println("SQL 오류 : "+e.getMessage());
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return res;
	}

}
