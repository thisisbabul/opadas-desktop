package controller;

import java.util.List;

import dao.DoctorDao;
import model.Doctor;
import model.Patient;

public class DoctorManager {

	private DoctorDao dd;
	
	
	public DoctorManager() {
		dd = new DoctorDao();
	}


	public Object[][] getDoctorUserList() {
		return dd.getDoctorUserList();
	}
	
	public boolean isUsernamePassword(String username, String password) {	
		List<Doctor> doctorList = dd.getDoctorList();
		for(Doctor doctor: doctorList) {
			if(doctor.getUsername().equals(username) && doctor.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}

	public boolean insert(Doctor doctor) {
		return dd.insert(doctor);
	}


	public boolean isUserExist(String username) {
		List<Doctor> doctorList = dd.getDoctorList();
		for(Doctor doctor: doctorList) {
			if(doctor.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}


	public boolean update(Doctor doctor) {
		// TODO Auto-generated method stub
		return dd.update(doctor);
	}


	public boolean delete(Doctor doctor) {
		// TODO Auto-generated method stub
		return dd.delete(doctor);
	}


	public Doctor searchById(int id) {
		// TODO Auto-generated method stub
		return dd.searchById(id);
	}

}
