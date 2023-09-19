package T9_sale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ParentDAO {
	Connection conn = null;
	
	public ParentDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "atom";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
