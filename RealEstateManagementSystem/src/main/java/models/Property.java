package main.java.models;

public abstract class Property {
	private String civicAddress;
	private Address address;
	private PropertySpecification propertySpecification;
	private boolean isOccupied;

	private double rentAmount;

	public Property(String civicAddress, Address address, PropertySpecification propertySpecification, double rent) {
		super();
		this.civicAddress = civicAddress;
		this.address = address;
		this.propertySpecification = propertySpecification;
		this.setOccupied(false);
		this.rentAmount = rent;
	}

	public String getCivicAddress() {
		return civicAddress;
	}

	public void setCivicAddress(String civicAddress) {
		this.civicAddress = civicAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PropertySpecification getPropertySpecification() {
		return propertySpecification;
	}

	public void setPropertySpecification(PropertySpecification propertySpecification) {
		this.propertySpecification = propertySpecification;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	@Override
	public String toString() {
		return "Civic Address='" + civicAddress + '\'' +
				", Address=" + address +
				", " + propertySpecification +
				", Rent=$" + rentAmount ;
	}
}