package com.seaTransportation;

public class Vessel {
	// The class Vessel describe all the necessary properties and methods for all
	// vessels

	private String type;
	private String specialization; // what kind of cargo can vessel transportation
	private int maxLoadCapacity; // in tons

	public Vessel(String type, String specialization, int maxLoadCapacity) {
		this.type = type;
		this.specialization = specialization;
		this.maxLoadCapacity = maxLoadCapacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getLoadCapacity() {
		return maxLoadCapacity;
	}

	public void setLoadCapacity(int loadCapacity) {
		this.maxLoadCapacity = loadCapacity;
	}

	@Override
	public String toString() {
		return "Vessel: type - " + type + ", specialization - " + specialization + ", maximum load capacity - "
				+ maxLoadCapacity + " tonns.";
	}

}
