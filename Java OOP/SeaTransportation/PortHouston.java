package com.seaTransportation;

public class PortHouston extends Port {
	// The class inherit a class Port and sets default value of the corresponding
	// prices(per ton)

	public PortHouston(String country, String name) {
		super(country, name);
	}

	@Override
	public int getPriceForDryCargo() {
		return 53;
	}

	@Override
	public int getPriceForLiquids() {
		return 50;
	}

	@Override
	public int getPriceForWithoutTare() {
		return 54;
	}

	@Override
	public int getPriceForCargoOnWheels() {
		return 55;
	}
}
