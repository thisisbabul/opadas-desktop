package controller;

import java.util.List;

import dao.DoctorDao;
import dao.PatientDao;
import model.Admin;
import model.Doctor;
import model.Patient;

public class PatientManager {

	private PatientDao pd;
	
	
	public PatientManager() {
		pd = new PatientDao();
	}


	public Object[][] getDoctorUserList() {
		return pd.getDoctorUserList();
	}


	public boolean insert(Patient patient) {
		return pd.insert(patient);
	}


	public boolean isUserExist(String mobile) {
		List<Patient> patientList = pd.getPatientList();
		for(Patient patient: patientList) {
			if(patient.getMobile().equals(mobile)) {
				return true;
			}
		}
		return false;
	}


	public boolean update(Doctor doctor) {
		// TODO Auto-generated method stub
		return pd.update(doctor);
	}


	public boolean delete(Patient patient) {
		// TODO Auto-generated method stub
		return pd.delete(patient);
	}


	public Doctor searchById(int id) {
		// TODO Auto-generated method stub
		return pd.searchById(id);
	}


	public List<Patient> getPatientList() {
		// TODO Auto-generated method stub
		return pd.getPatientList();
	}
	
	public boolean isUsernamePassword(String mobile, String password) {	
		List<Patient> patientList = pd.getPatientList();
		for(Patient patient: patientList) {
			if(patient.getMobile().equals(mobile) && patient.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}

}
