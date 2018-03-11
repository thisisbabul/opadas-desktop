package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Doctor;
import model.Pharmacy;

public class PharmacyDao {

	Connection conn = null;
	Statement stm = null;
	private boolean status;
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String CONNECTION_URL = "jdbc:mysql://localhost:3306/prescription";
	final String USERNAME = "root";
	final String PASSWORD = "";
	
	public Pharmacy searchById(int id) {
		Pharmacy pharmacy = new Pharmacy();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("select * from pharmacy where id="+id);
			while (rs.next()) {
				pharmacy.setId(rs.getInt("id"));
				pharmacy.setName(rs.getString("name"));
				pharmacy.setUsername(rs.getString("username"));
				pharmacy.setPassword(rs.getString("password"));
				pharmacy.setPhone(rs.getString("phone"));
				pharmacy.setAddress(rs.getString("address"));
			}
			return pharmacy;

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
	
	public boolean update(Pharmacy pharmacy) {

		Connection conn = null;
		Statement stm = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			int count = stm.executeUpdate("update pharmacy set name='"+pharmacy.getName()+"', username='"+pharmacy.getUsername()+"', password='"+pharmacy.getPassword()+"', phone='"+pharmacy.getPhone()+"', address='"+pharmacy.getAddress()+"' where id = " + pharmacy.getId());
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

	public boolean delete(Pharmacy pharmacy) {

		Connection conn = null;
		Statement stm = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			int count = stm.executeUpdate("delete from pharmacy where id = " + pharmacy.getId());
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
	
	public List<Pharmacy> getPharmacyList() {
		List<Pharmacy> pharmacyList = new ArrayList<>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("select * from pharmacy");
			while (rs.next()) {
				Pharmacy pharmacy = new Pharmacy();
				pharmacy.setId(rs.getInt("id"));
				pharmacy.setName(rs.getString("name"));
				pharmacy.setUsername(rs.getString("username"));
				pharmacy.setPassword(rs.getString("password"));
				pharmacy.setPhone(rs.getString("phone"));
				pharmacy.setAddress(rs.getString("address"));
				pharmacyList.add(pharmacy);
			}
			return pharmacyList;

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
	
	
	public boolean insert(Pharmacy pharmacy) {
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			int count = stm.executeUpdate("INSERT INTO pharmacy(name, username, password, phone, address) values('" + pharmacy.getName()
					+ "','" + pharmacy.getUsername() + "','" + pharmacy.getPassword() + "','" + pharmacy.getPhone() + "','" + pharmacy.getAddress()+ "')");
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
	
	
	public Object[][] getPharmacyUserList() {
		Object[][] data = null;
		final String QUERY = "select * from pharmacy";
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
				data[i][j++] = rs.getString("username");
				data[i][j++] = rs.getString("password");
				data[i][j++] = rs.getString("phone");
				data[i][j++] = rs.getString("address");
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

}
