package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public Statement stm;
		public static Connection getConnection() {
	        Connection c = null;

	        try {
	            // Đăng kí MySQL Driver với DriverManager
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Các thông số
	            String url = "jdbc:mysql://localhost:3306/ontap";
	            String username = "root";
	            String password = "";

	            // Tạo kết nối
	            c = DriverManager.getConnection(url, username, password);

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	        return c;
	    }

	    public static void closeConnection(Connection c) {
	        // Đóng kết nối
	        try {
	            if (c != null) {
	            	
	                c.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	}

//	
//		public Statement stm;
//		public Connection con;
//		public JDBC(){
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				try {
//					this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlixe","root","");
//				    this.stm = con.createStatement();
//				    System.out.println("OK");
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		
//}
