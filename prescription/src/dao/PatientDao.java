package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Doctor;
import model.Patient;

public class PatientDao {

	Connection conn = null;
	Statement stm = null;
	private boolean status;
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String CONNECTION_URL = "jdbc:mysql://localhost:3306/prescription";
	final String USERNAME = "root";
	final String PASSWORD = "";
	
	public Doctor searchById(int id) {
		Doctor doctor = new Doctor();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("select * from doctor where id="+id);
			while (rs.next()) {
				doctor.setId(rs.getInt("id"));
				doctor.setName(rs.getString("name"));
				doctor.setUsername(rs.getString("username"));
				doctor.setPassword(rs.getString("password"));
				doctor.setPhone(rs.getString("phone"));
				doctor.setEmail(rs.getString("email"));
				doctor.setEducation(rs.getString("education"));
				doctor.setSpecialist(rs.getString("specialist"));
				doctor.setExperience(rs.getString("experience"));
				doctor.setChamber(rs.getString("chamber"));
			}
			return doctor;

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
	
	public boolean update(Doctor doctor) {

		Connection conn = null;
		Statement stm = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			int count = stm.executeUpdate("update doctor set name='"+doctor.getName()+"', username='"+doctor.getUsername()+"', password='"+doctor.getPassword()+"', phone='"+doctor.getPhone()+"', email='"+doctor.getEmail()+"', education='"+doctor.getEducation()+"', specialist='"+doctor.getSpecialist()+"', experience='"+doctor.getExperience()+"', chamber='"+doctor.getChamber()+"' where id = " + doctor.getId());
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

	public boolean delete(Doctor doctor) {

		Connection conn = null;
		Statement stm = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			int count = stm.executeUpdate("delete from doctor where id = " + doctor.getId());
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
	
	public List<Patient> getPatientList() {
		List<Patient> patientList = new ArrayList<>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			ResultSet rs = stm.executeQuery("select * from patient");
			while (rs.next()) {
				Patient patient = new Patient();
				patient.setId(rs.getInt("id"));
				patient.setName(rs.getString("name"));
				patient.setAddress(rs.getString("address"));
				patient.setMobile(rs.getString("mobile"));
				patient.setPassword(rs.getString("password"));
				patient.setRefperson(rs.getString("refperson"));
				patientList.add(patient);
			}
			return patientList;

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
	
	
	public boolean insert(Patient patient) {
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();

			
	        
			int count = stm.executeUpdate("INSERT INTO patient(name, address, mobile, password, refperson) values('" + patient.getName()	+ "','" + patient.getAddress() + "','" + patient.getMobile() + "','" +  patient.getPassword() + "','" + patient.getRefperson()+ "')");
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
	
	
	public Object[][] getDoctorUserList() {
		Object[][] data = null;
		final String QUERY = "select * from doctor";
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
				data[i][j++] = rs.getString("email");
				data[i][j++] = rs.getString("education");
				data[i][j++] = rs.getString("specialist");
				data[i][j++] = rs.getString("experience");
				data[i][j++] = rs.getString("chamber");
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
