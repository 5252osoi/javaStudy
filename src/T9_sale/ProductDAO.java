package T9_sale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends ParentDAO{
//	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql;
	ProductVO pVO = null;
	SaleVO sVO = null;
	
//	public ProductDAO() {
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
	//conn객체 close
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
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
	
	//신규상품등록
	public int setProductInput(ProductVO vo) {
		int res=0;
		try {
			sql="insert into product values(default,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getpName());
			pstmt.setInt(2, vo.getPrice());
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {}
		finally {
			pstmtClose();
		}
		return res;
	}
	
	
	//전체상품조회
	public List<ProductVO> getProductList() {
		List<ProductVO> vos=new ArrayList<>();
		
		try {
			sql="select * from product order by idx desc";
			pstmt =conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO vo=new ProductVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pName"));
				vo.setPrice(rs.getInt("price"));
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			rsClose();
		}
		
		return vos;
	}
	public int setProductDelete(int idx) {
		int res=0;
		try {
			sql="delete from product where idx=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			pstmtClose();
		}
		return res;
	}
	
	
}
