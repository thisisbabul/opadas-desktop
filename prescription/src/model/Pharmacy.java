package model;

public class Pharmacy {
	private int id;
	private String name;
	private String username;
	private String password;
	private String phone;
	private String address;

	public Pharmacy() {

	}

	public Pharmacy(String name, String username, String password, String phone, String address) {

		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public Pharmacy(int id, String name, String username, String password, String phone, String address) {

		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
