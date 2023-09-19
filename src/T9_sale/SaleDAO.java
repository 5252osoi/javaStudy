package T9_sale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleDAO extends ParentDAO{
//	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql;
	ProductVO pVO = null;
	SaleVO sVO = null;
	

	//	public SaleDAO() {
//		String url = "jdbc:mysql://localhost:3306/javaProject";
//		String user = "atom";
//		String password = "1234";
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	public void pstmtClose() {
		try {
			if(pstmt!=null)pstmt.close();
		} catch (Exception e) {}
	}
	//rs객체 close
	public void rsClose() {
		try {
			if(rs!=null)rs.close();
		} catch (Exception e) {}
		pstmtClose();
	}


	public int setSaleInput(SaleVO sVO) {
		int res=0;
		try {
			sql="insert into product values(default,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sVO.getpName());
			pstmt.setInt(2, sVO.getEa());
			pstmt.setString(3, sVO.getpDate());
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {}
		finally {
			pstmtClose();
		}
		return res;
	}
	//등록된기존상품검색
	public ProductVO getNameSearch(String pName) {
		ProductVO vo=new ProductVO();
		
		try {
			sql="select * from product where pName=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pName"));
				vo.setPrice(rs.getInt("price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return vo;
	}
	public ArrayList<SaleVO> getSaleNameSearch(String pName) {
		ArrayList<SaleVO> vos = new ArrayList<SaleVO>();
		ResultSet rs2=null;
		try {
			sql="select * from sale where pName=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs2=pstmt.executeQuery();
			while(rs2.next()) {
				sVO.setIdx(rs2.getInt("idx"));
				sVO.setpName(rs2.getString("pName"));
				sVO.setEa(rs2.getInt("Ea"));
				sVO.setpDate(rs2.getString("pDate"));
				
//				int salePrice = getNameSearch(pName).getPrice();
//				sVO.setSalePrice(salePrice);
				sVO.setSalePrice(getNameSearch(pName).getPrice());
				
				vos.add(sVO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return vos;
	}
	public ArrayList<SaleVO> getSaleDateSearch(String pDate) {
		ArrayList<SaleVO> vos = new ArrayList<SaleVO>();
		ResultSet rs2=null;
		try {
			sql="select * from sale where pDate=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pDate);
			rs2=pstmt.executeQuery();
			while(rs2.next()) {
				sVO.setIdx(rs2.getInt("idx"));
				sVO.setpName(rs2.getString("pName"));
				sVO.setEa(rs2.getInt("Ea"));
				sVO.setpDate(rs2.getString("pDate"));
				
//				int salePrice = getNameSearch(pName).getPrice();
//				sVO.setSalePrice(salePrice);
				sVO.setSalePrice(getNameSearch(sVO.getpName()).getPrice());
				
				vos.add(sVO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return vos;
		
	}
	//전체판매상품조회
	public ArrayList<SaleVO> getSaleList() {
		ArrayList<SaleVO> vos = new ArrayList<SaleVO>();
		ResultSet rs2=null;
		try {
			sql="select * from sale";
			pstmt=conn.prepareStatement(sql);
			rs2=pstmt.executeQuery();
			
			while(rs2.next()) {
				sVO.setIdx(rs2.getInt("idx"));
				sVO.setpName(rs2.getString("pName"));
				sVO.setEa(rs2.getInt("Ea"));
				sVO.setpDate(rs2.getString("pDate"));
				
//				int salePrice = getNameSearch(pName).getPrice();
//				sVO.setSalePrice(salePrice);
				sVO.setSalePrice(getNameSearch(sVO.getpName()).getPrice());
				
				vos.add(sVO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return vos;
		
	}
	
	
}
