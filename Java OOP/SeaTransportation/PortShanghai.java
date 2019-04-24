package com.seaTransportation;

public class PortShanghai extends Port {
	// The class inherit a class Port and sets default value of the corresponding
	// prices(per ton)

	public PortShanghai(String country, String name) {
		super(country, name);
	}

	@Override
	public int getPriceForDryCargo() {
		return 52;
	}

	@Override
	public int getPriceForLiquids() {
		return 53;
	}

	@Override
	public int getPriceForWithoutTare() {
		return 49;
	}

	@Override
	public int getPriceForCargoOnWheels() {
		return 54;
	}

}
