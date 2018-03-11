package model;

public class Doctor {
	private int id;
	private String name;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String education;
	private String specialist;
	private String experience;
	private String chamber;

	public Doctor() {

	}

	public Doctor(String name, String username, String password, String phone, String email, String education,
			String specialist, String experience, String chamber) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.education = education;
		this.specialist = specialist;
		this.experience = experience;
		this.chamber = chamber;
	}

	public Doctor(int id, String name, String username, String password, String phone, String email, String education,
			String specialist, String experience, String chamber) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.education = education;
		this.specialist = specialist;
		this.experience = experience;
		this.chamber = chamber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getChamber() {
		return chamber;
	}

	public void setChamber(String chamber) {
		this.chamber = chamber;
	}

}
