package ua.myPlanes;

import java.util.ArrayList;
import java.util.List;

public class Airline {
	// The class creates all airplanes in the airline*/
	private List<Plane> planes = createsPlanes();
	
	public List<Plane> getPlanes() {
		return planes;
	}

	// The method creates different airplanes
	private List<Plane> createsPlanes() {
		List<Plane> planes = new ArrayList<Plane>();
		planes.add(new LongHaulFlightPlane("Boeing 777-200ER", 79200, 14260, 6700, 361));
		planes.add(new LongHaulFlightPlane("Boeing 767-300ER", 65150, 11070, 4800, 261));
		planes.add(new MediumHaulFlightPlane("Boeing 737-800", 61250, 6000, 2480, 186));
		planes.add(new MediumHaulFlightPlane("Boeing 737-900", 52400, 6000, 2650, 189));
		planes.add(new MediumHaulFlightPlane("EMBRAER-190", 47800, 3300, 1850, 104));
		planes.add(new MediumHaulFlightPlane("EMBRAER-195", 48790, 3900, 1900, 116));
		planes.add(new ShortHaulFlightPlane("Avro RJ100", 42200, 2075, 2180, 85));
		return planes;
	}
	
	// The method returns the total load capacity for all airplanes
	public int getTotalLoadCapacity() {
		int sumLoadCap = 0;
		for (Plane p : planes) {
			sumLoadCap += p.getMaxLoadCapacity();
		}
		return sumLoadCap;
	}
	
	// The method returns the total number of seats for all airplanes
	public int getTotalNumbOfSeats() {
		int sumNumbSeats = 0;
		for (Plane p : planes) {
			sumNumbSeats += p.getNumberOfSeats();
		}
		return sumNumbSeats;
	}
	
	// The method returns all airplanes with medium-haul flight and fuel consumption in a range[1900:2400]
	public List<Plane> searchPlanes() {
		List<Plane> plane = new ArrayList<>();
		for (Plane pl : planes) {
			if (pl instanceof MediumHaulFlightPlane && pl.getFuelConsumption() < 2400 && pl.getFuelConsumption() >= 1900) {
				plane.add(pl);
			}
		}
		return plane;
	}
	
}
