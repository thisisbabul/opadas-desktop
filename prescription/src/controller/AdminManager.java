package controller;

import java.util.List;

import dao.AdminDao;
import model.Admin;

public class AdminManager {
	private AdminDao ad;
	
	
	public AdminManager() {
		ad = new AdminDao();
	}


	public boolean isUsernamePassword(String username, String password) {	
		List<Admin> adminList = ad.getAdminList();
		for(Admin admin: adminList) {
			if(admin.getName().equals(username) && admin.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}


	public Object[][] getAdminUserList() {
		return ad.getAdminUserList();
	}


	public boolean insertAdminUser(Admin txt_admin) {
		
		return ad.insertAdmin(txt_admin);
	}


	public boolean update(Admin admin) {
		return ad.update(admin);
	}


	public boolean delete(Admin admin) {
		// TODO Auto-generated method stub
		return ad.delete(admin);
	}


	public Admin searchById(int id) {
		// TODO Auto-generated method stub
		return ad.searchById(id);
	}


	public boolean isUserExist(String txt_username) {
		List<Admin> adminList = ad.getAdminList();
		for(Admin admin: adminList) {
			if(admin.getName().equals(txt_username)){
				return true;
			}
		}
		return false;
	}
}
