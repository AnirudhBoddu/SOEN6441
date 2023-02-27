package main.java.models;

public class Address {
	private String streetNumber;
	private String streetName;
	private String city;
	private String province;
	private String postalCode;

	public Address(String streetNumber, String streetName, String city, String province, String postalCode) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "'" + streetNumber +
				" " + streetName +
				", " + city +
				", " + province +
				", " + postalCode + '\'';
	}
}
