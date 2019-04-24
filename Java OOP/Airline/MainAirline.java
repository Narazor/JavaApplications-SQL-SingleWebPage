package ua.myPlanes;

import java.util.Collections;

public class MainAirline {

	public static void main(String[] args) {
		
		Airline airline = new Airline();
		
		Collections.sort(airline.getPlanes(), Plane.getRangeOfFlightComparator());
		System.out.println("The planes are sorted by flight range: ");
		System.out.println(airline.getPlanes());
		
		System.out.println("Total number of seats for all airplanes is: \n" + airline.getTotalNumbOfSeats());
		System.out.println("Total load capacity for all airplanes is: \n" + airline.getTotalLoadCapacity());
		
		System.out.println("Find all airplanes with medium-haul flight and fuel consumption in a range[1900:2400]:");
		System.out.println(airline.searchPlanes());
		
	}
	
}
