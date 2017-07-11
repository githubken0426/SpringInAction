package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	/**
	 * Java DataBase Connectivity
	 * 获取连接
	 * @return
	 * @date 2017年7月6日 上午9:33:15
	 * oracle.jdbc.driver.OracleDriver
	 * jdbc:oracle:thin:@localhost:1521:orcl
	 */
	public static Connection getConnection() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/dl_travel?useUnicode=true&characterEncoding=utf-8";
	    String username = "root";
	    String password = "root";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
}
