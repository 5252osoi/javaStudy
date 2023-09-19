package T8_sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SungjukDAO {
	
////////////////////////////////////////
/////////데이터베이스 이용할때 기본필드//////////
////////////////////////////////////////
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	SungjukVO vo = null;
	String sql="";
////////////////////////////////////////
	public SungjukDAO() {
		String url="jdbc:mysql://localhost:3306/javaProject";
		String user="atom";
		String password="1234";
		//1.드라이버 검색
		try {
			Class.forName("com.mysql.jdbc.Driver");
		//2.데이터베이스 검색(연결/연동)
			conn=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 오류 "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 오류 "+e.getMessage());
		}
	}
////////////////////////////////////////////////////
	//conn Close;
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			
		}
	}
	//pstmt Close;;
	public void pstmtClose() {
		try {
			if(pstmt !=null)pstmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	//rs close
	public void rsClose() {
		try {
			if(rs!=null)rs.close();
		} catch (SQLException e) {
		pstmtClose();
		// TODO: handle exception
		}
	}
	
	//성적자료 등록처리
	public int setInput(SungjukVO vo) {
		int res = 0;
		try {
			sql="insert into sungjuk values (default,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL오류 : "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	//전체 조회 처리
	public ArrayList<SungjukVO> getList() {
		ArrayList<SungjukVO> vos = new ArrayList<SungjukVO>();
		try {
			sql="select*from sungjuk order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//rs에 들어간 내용 vo에 담아서 vos만들기 
			while(rs.next()) {
				vo=new SungjukVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL오류 : "+e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
	
	//개별조회처리
	public SungjukVO getSearch(String name) {
		SungjukVO vo = new SungjukVO();
		try {
			sql="select*from sungjuk where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				
			}
			else vo=null;
		} catch (SQLException e) {
			System.out.println("SQL오류 : "+e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	public int setUpdate(String name, int kor, int eng, int mat) {
		int res=0;
		try {
			sql="update sungjuk set kor=?,eng=?,mat=? where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, kor);
			pstmt.setInt(2, eng);
			pstmt.setInt(3, mat);
			pstmt.setString(4, name);
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL오류 : "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	public void setDelete(String name) {
		try {
			sql="delete from sungjuk where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL오류 : "+e.getMessage());
		} finally {
			pstmtClose();
		}
	}
	
	
}
