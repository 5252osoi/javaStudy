package T8_bonbong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SBDAO {
	Connection conn =null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	
	BonbongVO voB=null;
	String sql="";
	
	
	public SBDAO() {
		String url="jdbc:mysql://localhost:3306/javaProject";
		String user="atom";
		String password="1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	public void pstmtClose() {
		try {
			if(pstmt!=null)pstmt.close();
		} catch (SQLException e) {}
	}
	
	public void rsClose() {
		try {
			if(rs!=null)rs.close();
		} catch (Exception e) {
			pstmtClose();
		}
	}
	
	
	
	//직급 검색용 조회
	public BonbongVO getSearchB(String jikkub){
		BonbongVO vo=new BonbongVO();
		try {
			sql="select*from bonbong where jikkub=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, jikkub);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo.setJikkub(rs.getString("jikkub"));
			}
		} catch (SQLException e) {
			System.out.println("SQL오류 : "+e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return vo;
	}
	
	

	public int setInputB(BonbongVO voB) {
		int res=0;
		try {
			sql="insert into bonbong values (?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, voB.getJikkub());
			pstmt.setInt(2, voB.getBonbong());
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL오류 : "+e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	public ArrayList<BonbongVO> getListB() {
		ArrayList<BonbongVO> vos = new ArrayList<BonbongVO>();
		try {
			sql="select*from bonbong order by bonbong desc";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				voB=new BonbongVO();
				voB.setJikkub(rs.getString("jikkub"));
				voB.setBonbong(rs.getInt("bonbong"));
				vos.add(voB);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL오류 : "+e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	public int setUpdateB(String jikkub, String newJikkub, int bonbong) {
		int res=0;
		try {
			sql="update bonbong set jikkub=?, bonbong=? where jikkub=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, newJikkub);
			pstmt.setInt(2, bonbong);
			pstmt.setString(3, jikkub);
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL오류 : "+e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	public int setDeleteB(String jikkub) {
		int res=0;
		try {
			sql="delete from bonbong where jikkub=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, jikkub);
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL오류 : "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	//////////////////////////여기서부터 사원관리자 출력용 메소드/////////////////////////////

	public ArrayList<SawonVO> getListS() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
