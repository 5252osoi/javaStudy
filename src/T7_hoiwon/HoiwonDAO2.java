package T7_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HoiwonDAO2 {
	Connection conn = null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	
	String sql="";
	HoiwonVO vo =null;
	
	public HoiwonDAO2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다. . . " +e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동실패. . . " +e.getMessage());
		}
	}
	
	//conn객체close;;;
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	//pstmt객체 close;
	public void pstmtClose() {
		try {
			if(pstmt!=null) pstmt.close(); //pstmt!=null => pstmt가 사용됐을때 (초기값이 null이니까)
		} catch (SQLException e) {}
	}
	//rs객체 close;
	public void rsClose() {
		try {
			if(rs!=null) rs.close();
			pstmtClose(); //rs가 있다는건 pstmt도 무조건 있기때문에 같이 닫아도됨
		} catch (Exception e) {}
	}
	
	//전체회원조회
	public ArrayList<HoiwonVO> getList() {
		ArrayList<HoiwonVO>vos=new ArrayList<>();
		try {
			sql="select*from hoiwon order by idx desc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				vo = new HoiwonVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
				
				vos.add(vo);
			}			
					
		} catch (SQLException e) {
//			System.out.println("SQL 문장 오류 : "+e.getMessage());
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vos;
		
		
	}

	public HoiwonVO getSearch(String name) {
		HoiwonVO vo = new HoiwonVO();
		try {
			////////////////////////////////////////////
			sql="select*from Hoiwon where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			//////////1번째 ?위치에 name 들어가는것 //////////
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : "+e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	public void setDelete(String name) {
		//회원자료 삭제하기
		try {
			sql="delete from Hoiwon where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			//삭제니까 리턴값없음
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : "+e.getMessage());
		} finally {
			pstmtClose();
		}
	}

	// 회원가입처리 (sql : insert)
//	public void setHoiwonInput(String name, int age, String address, int gender) {
//
//	}
	
	public int setHoiwonInput(HoiwonVO vo) {
		int res=0;
		try {
			sql="insert into hoiwon values (default,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getGender());
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public int setHoiwonUpdate(String name, int age, String address, String strGender) {
		int res=0;
		try {
			sql="update hoiwon set age=?, address=?, gender=? where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setString(2, address);
			pstmt.setString(3, strGender);
			pstmt.setString(4, name);
					
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	
}
