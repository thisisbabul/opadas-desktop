package controller;

import java.util.List;

import dao.PharmacyDao;
import model.Pharmacy;

public class PharmacyManager {

	private PharmacyDao fd;
	
	
	public PharmacyManager() {
		fd = new PharmacyDao();
	}


	public Object[][] getPharmacyUserList() {
		return fd.getPharmacyUserList();
	}


	public boolean insert(Pharmacy pharmacy) {
		return fd.insert(pharmacy);
	}


	public boolean isUserExist(String username) {
		List<Pharmacy> pharmacyList = fd.getPharmacyList();
		for(Pharmacy pharmacy: pharmacyList) {
			if(pharmacy.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}


	public boolean update(Pharmacy pharmacy) {
		// TODO Auto-generated method stub
		return fd.update(pharmacy);
	}


	public boolean delete(Pharmacy pharmacy) {
		// TODO Auto-generated method stub
		return fd.delete(pharmacy);
	}


	public Pharmacy searchById(int id) {
		// TODO Auto-generated method stub
		return fd.searchById(id);
	}


	
}
