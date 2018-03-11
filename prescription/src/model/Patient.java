package model;

public class Patient {
	private int id;
	private String name;
	private String address;
	private String mobile;
	private String password;
	private String refperson;

	public Patient() {

	}

	public Patient(String name, String address, String mobile, String password, String refperson) {

		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.password = password;
		this.refperson = refperson;
	}

	public Patient(int id, String name, String address, String mobile, String password, String refperson) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.password = password;
		this.refperson = refperson;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRefperson() {
		return refperson;
	}

	public void setRefperson(String refperson) {
		this.refperson = refperson;
	}

}
