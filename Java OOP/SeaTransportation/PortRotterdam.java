package com.seaTransportation;

public class PortRotterdam extends Port {
	// The class inherit a class Port and sets default value of the corresponding
	// prices(per ton)

	public PortRotterdam(String country, String name) {
		super(country, name);
	}

	@Override
	public int getPriceForDryCargo() {
		return 55;
	}

	@Override
	public int getPriceForLiquids() {
		return 48;
	}

	@Override
	public int getPriceForWithoutTare() {
		return 53;
	}

	@Override
	public int getPriceForCargoOnWheels() {
		return 56;
	}

}
