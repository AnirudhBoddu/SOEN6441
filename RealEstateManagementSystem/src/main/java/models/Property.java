package main.java.models;

public abstract class Property {
	private String civicAddress;
	private Address address;
	private PropertySpecification propertySpecification;
	private boolean isOccupied;

	public Property(String civicAddress, Address address, PropertySpecification propertySpecification) {
		super();
		this.civicAddress = civicAddress;
		this.address = address;
		this.propertySpecification = propertySpecification;
		this.setOccupied(false);
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

}