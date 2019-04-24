package ua.myPlanes;

import java.util.Comparator;

public abstract class Plane {
	// The class Plane describes all the necessary fields and methods for all airplanes
	
	// The class variable compares all instances a class Plane by range of flight
	private static RangeOfFlightComparator rangeOfFlightComparator = new RangeOfFlightComparator();
	private String name;
	private int maxLoadCapacity; // kg
	private int rangeOfFlight; // km
	private int fuelConsumption; // kg/hour
	private int numberOfSeats;
	
	public Plane(String name, int maxLoadCapacity, int rangeOfFlight, int fuelConsumption, int numberOfSeats) {
		this.name = name;
		this.maxLoadCapacity = maxLoadCapacity;
		this.rangeOfFlight = rangeOfFlight;
		this.fuelConsumption = fuelConsumption;
		this.numberOfSeats = numberOfSeats;
	}
	
	public static RangeOfFlightComparator getRangeOfFlightComparator() {
		return rangeOfFlightComparator;
	}

	public String getName() {
		return name;
	}

	public void setName(String type) {
		this.name = type;
	}

	public int getMaxLoadCapacity() {
		return maxLoadCapacity;
	}

	public void setMaxLoadCapacity(int maxLoadCapacity) {
		this.maxLoadCapacity = maxLoadCapacity;
	}

	public int getRangeOfFlight() {
		return rangeOfFlight;
	}

	public void setRangeOfFlight(int rangeOfFlight) {
		this.rangeOfFlight = rangeOfFlight;
	}

	public int getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(int hourlyFuelConsumption) {
		this.fuelConsumption = hourlyFuelConsumption;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	// The private class compares all instances a class Plane by range of flight
	private static class RangeOfFlightComparator implements Comparator<Plane> {
		@Override
		public int compare(Plane p1, Plane p2) {
			return p1.getRangeOfFlight() - p2.getRangeOfFlight();
		}
		
	}

	@Override
	public String toString() {
		return getName() + " - max load capacity=" + getMaxLoadCapacity() + " kg, range of flight="
				+ getRangeOfFlight() + " km, fuel consumption=" + getFuelConsumption() + " kg/hour";
	}

}
