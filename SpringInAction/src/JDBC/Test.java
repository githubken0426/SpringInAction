package JDBC;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.mysql.jdbc.PreparedStatement;

public class Test {
	/**
	 * 插入
	 * 
	 * @return
	 * @throws SQLException
	 * @date 2017年7月6日 上午9:44:43
	 */
	public static int insert(Employee emp) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "insert into tb_employee (id,name,birthday,delete_flag,update_time,create_time) values(?,?,?,0,now(),now())";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getBirthday());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
		return 0;
	}

	/**
	 * 查询
	 * @throws SQLException 
	 * 
	 * @date 2017年7月6日 上午9:44:50
	 */
	public static Integer selecetAll() throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "select * from tb_employee";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(rs.getString(i) + "\t");
					if ((i == 2) && (rs.getString(i).length() < 8)) {
						System.out.print("\t");
					}
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
		return null;
	}

	public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
		/*Employee emp=new Employee();
		emp.setId(UUID.randomUUID().toString().replace("-", ""));
		emp.setName(new String("李四".getBytes("utf-8")));
		emp.setDeleteFlag(0);
		emp.setBirthday("2010-01-01");
		System.out.println(insert(emp));*/
		
		selecetAll();
	}
}
