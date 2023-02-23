package main.java.models;

public class Condo extends Property {

	private String unitNumber;

	public Condo(String civicAddress, Address address, PropertySpecification propertySpecification, String unitNum) {
		super(civicAddress, address, propertySpecification);
		this.unitNumber = unitNum;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
}
