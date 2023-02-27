package main.java.models;

public class Condo extends Property {

	private String unitNumber;

	public Condo(String civicAddress, Address address, PropertySpecification propertySpecification, String unitNum, double rent) {
		super(civicAddress, address, propertySpecification, rent);
		this.unitNumber = unitNum;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
}
