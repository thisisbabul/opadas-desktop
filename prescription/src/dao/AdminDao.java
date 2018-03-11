package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Admin;

public class AdminDao {
	Connection conn = null;
	Statement stm = null;
	private boolean status;
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String CONNECTION_URL = "jdbc:mysql://localhost:3306/prescription";
	final String USERNAME = "root";
	final String PASSWORD = "";

	public List<Admin> getAdminList() {
		List<Admin> adminList = new ArrayList<>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("select * from admin");
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				adminList.add(admin);
			}
			return adminList;

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	public Admin searchById(int id) {
		Admin admin = new Admin();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("select * from admin where id="+id);
			while (rs.next()) {
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setStatus(rs.getString("status"));
			}
			return admin;

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public Object[][] getAdminUserList() {
		Object[][] data = null;
		final String QUERY = "select * from admin";
		try {
			// Loading the Driver
			Class.forName(DRIVER_NAME);
			// Getting Database Connection Object by Passing URL, Username and Password
			Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(QUERY);
			int rowCount = getRowCount(rs); // Row Count
			int columnCount = getColumnCount(rs); // Column Count
			data = new Object[rowCount][columnCount];
			// Starting from First Row for Iteration
			rs.beforeFirst();
			int i = 0;
			while (rs.next()) {
				int j = 0;
				data[i][j++] = rs.getInt("id");
				data[i][j++] = rs.getString("name");
				data[i][j++] = rs.getString("password");
				data[i][j++] = rs.getString("status");
				i++;
			}
			status = true;
			// Closing the Resources;
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	// Method to get Row Count from ResultSet Object
	private int getRowCount(ResultSet rs) {
		try {
			if (rs != null) {
				rs.last();
				return rs.getRow();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	// Method to get Column Count from ResultSet Object
	private int getColumnCount(ResultSet rs) {
		try {
			if (rs != null)
				return rs.getMetaData().getColumnCount();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	public boolean insertAdmin(Admin txt_admin) {
		Connection conn = null;
		Statement stm = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			int count = stm.executeUpdate("INSERT INTO admin(name, password, status) values('" + txt_admin.getName()
					+ "','" + txt_admin.getPassword() + "','" + txt_admin.getStatus() + "')");
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Exception is caugth " + e.getMessage());
		} finally {
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean update(Admin admin) {

		Connection conn = null;
		Statement stm = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			int count = stm.executeUpdate("update admin set name='" + admin.getName() + "', password='"
					+ admin.getPassword() + "', status = '" + admin.getStatus() + "' where id = " + admin.getId());
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Exception is caugth " + e.getMessage());
		} finally {
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean delete(Admin admin) {

		Connection conn = null;
		Statement stm = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			int count = stm.executeUpdate("delete from admin where id = " + admin.getId());
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Exception is caugth " + e.getMessage());
		} finally {
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	
}
