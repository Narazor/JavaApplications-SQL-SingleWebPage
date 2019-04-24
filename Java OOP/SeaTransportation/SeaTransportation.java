package com.seaTransportation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeaTransportation {
	/* The class creates different ways to offer goods transportation */

	private List<Vessel> vessels = createVessel();
	private List<Port> ports = createPort();

	public List<Vessel> createVessel() {
		List<Vessel> vessel = new ArrayList<>();
		vessel.add(new Vessel("Dry cargo", "dry cargo", 200000));
		vessel.add(new Vessel("Tanker", "liquids", 400000));
		vessel.add(new Vessel("Balker", "bulk cargo without tare", 150000));
		vessel.add(new Vessel("Ferry", "cargo on wheels", 60000));
		return vessel;
	}

	public List<Port> createPort() {
		List<Port> port = new ArrayList<>();
		port.add(new PortRotterdam("Netherlands", "Rotterdam"));
		port.add(new PortHouston("USA", "Houston"));
		port.add(new PortShanghai("China", "Shanghai"));
		return port;
	}

	// The method returns an instance of the ship that transporting the particular
	// product(which a customer has chosen)
	public Vessel getVesselByCargo(String specialization) {
		for (Vessel v : vessels) {
			if (v.getSpecialization().equals(specialization))
				switch (specialization.toLowerCase()) {
				case "dry cargo":
					return v;
				case "liquids":
					return v;
				case "bulk cargo without tare":
					return v;
				case "cargo on wheels":
					return v;
				default:
					return null;
				}
		}
		return null;
	}

	// The method returns an instance of the port (which a customer has chosen)
	public Port getPort(int number) {
		for (int i = 0; i < ports.size(); i++) {
			switch (number) {
			case 1:
				return ports.get(number - 1);
			case 2:
				return ports.get(number - 1);
			case 3:
				return ports.get(number - 1);
			}
		}
		return null;
	}

	// The method returns the price of the pre-selected product depending on the
	// tonnage
	public int getPriceForTransportation(Port inputedPort, String inputedCargo, int ton) {
		switch (inputedCargo.toLowerCase()) {
		case "dry cargo":
			return inputedPort.costsForDryCargo(ton);
		case "liquids":
			return inputedPort.costsForLiquids(ton);
		case "bulk cargo without tare":
			return inputedPort.costsForWithoutTare(ton);
		case "cargo on wheels":
			return inputedPort.costsForVehicle(ton);
		default:
			return 0;
		}
	}

	// The method returns the port with maximum price of the pre-selected product
	// depending on the tonnage
	public Port getMaxPrice(String inputedCargo) {
		switch (inputedCargo.toLowerCase()) {
		case "dry cargo":
			Collections.sort(ports, Port.getPriceDryCargoComparator());
			return ports.get(ports.size() - 1);
		case "liquids":
			Collections.sort(ports, Port.getPriceLiquidsComparator());
			return ports.get(ports.size() - 1);
		case "bulk cargo without tare":
			Collections.sort(ports, Port.getPriceWithoutTareComparator());
			return ports.get(ports.size() - 1);
		case "cargo on wheels":
			Collections.sort(ports, Port.getPriceCargoOnWheels());
			return ports.get(ports.size() - 1);
		default:
			return null;
		}
	}

}
