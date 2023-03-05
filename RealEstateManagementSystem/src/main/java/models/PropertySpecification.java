package main.java.models;

public class PropertySpecification {
    private int numBedrooms;
    private int numBathrooms;
    private int squareFootage;

    public PropertySpecification(int numBedrooms, int numBathrooms, int squareFootage) {
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.squareFootage = squareFootage;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    @Override
    public String toString() {
        return "numBedrooms=" + numBedrooms +
                ", numBathrooms=" + numBathrooms +
                ", squareFootage=" + squareFootage;
    }
}
