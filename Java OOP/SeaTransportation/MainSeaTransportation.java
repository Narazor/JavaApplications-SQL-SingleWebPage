package com.seaTransportation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainSeaTransportation {

	public static void main(String[] args) {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		SeaTransportation offer = new SeaTransportation();
		try {
			new MainSeaTransportation().createOffer(bf, offer);
		} catch (NumberFormatException | IOException e) {
			System.out.println("Please, check you inputed date and try again!");
		}
		
	}
	
	public void createOffer(BufferedReader bf, SeaTransportation offer) throws NumberFormatException, IOException {
		Port p;
		int port;
		int tonnage;

		System.out.print("What needs to transport: dry cargo, liquids, bulk cargo without tare, cargo on wheels?: ");
		String str = bf.readLine();
		if (offer.getVesselByCargo(str) != null) {
			System.out.println("We can offer the followin vessel:");
			System.out.println(offer.getVesselByCargo(str) + "\n");
		} else {
			System.out.println("We can't help you, we're sorry!");
			System.exit(0);
		}
		System.out.println("Destination port is Ukraine(Odessa)!");
		System.out.print("Port of departure: 1)Rotterdam; 2)Houston; 3)Shanghai: ");
		port = Integer.parseInt(bf.readLine());
		if (offer.getPort(port) != null) {
		System.out.println(offer.getPort(port) + " - it's a good choice! \n");
		p = offer.getPort(port);
		System.out.print("Please, input tonnage of goods:");
		tonnage = Integer.parseInt(bf.readLine());
		System.out.println("Price for transportation = " + offer.getPriceForTransportation(p, str, tonnage) + "$ \n");
		System.out.println("Maximum payment price for this product in the following port - " + offer.getMaxPrice(str) + ".");
	}
	
}
}