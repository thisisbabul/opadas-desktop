package model;

public class Admin {
	private int id;
	private String name;
	private String password;
	private String status;

	public Admin() {

	}

	public Admin(String name, String password, String status) {
		this.name = name;
		this.password = password;
		this.status = status;
	}

	public Admin(int id, String name, String password, String status) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.status = status;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
