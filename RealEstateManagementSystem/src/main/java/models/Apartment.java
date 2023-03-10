package main.java.models;

public class Apartment extends Property {

	private String apartmentNumber;

	public Apartment(String civicAddress, Address address, PropertySpecification propertySpecification,
			String apartmentNumber, double rent) {
		super(civicAddress, address, propertySpecification, rent);
		this.apartmentNumber = apartmentNumber;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
}
