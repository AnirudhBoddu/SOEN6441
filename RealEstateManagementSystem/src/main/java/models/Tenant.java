package main.java.models;

public class Tenant {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private Address address;

	//TODO: Remove attribute address

	public Tenant(String firstName, String lastName, String phoneNumber, String email, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	// Getters and setters for all fields
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "'" + firstName + '\'' +
				", '" + lastName + '\'' +
				", '" + phoneNumber + '\'' +
				", " + email + '\'' +
				", " + address;
	}
}
