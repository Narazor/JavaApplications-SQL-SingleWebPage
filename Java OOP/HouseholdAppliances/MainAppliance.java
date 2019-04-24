package ua.myHouseholdApliances;

import java.util.Arrays;
import java.util.Set;

public class MainAppliance {

	public static void main(String[] args) {

		House h = new House();
		Set<Appliance> pluggedAppliances = h.plugIntoTheOutlet();

		System.out.println(pluggedAppliances.size() + " appliance(s) are plugged into the outlet appliance: \n"
				+ pluggedAppliances);
		System.out.println("Consumed energy for all plugged into the outlet appliance is "
				+ h.calcConsumedEnergy(pluggedAppliances) + " kW-h \n");

		Arrays.sort(h.getAppliances(), Appliance.getPowerComparator());

		System.out.println("All appliances are sorted by power in the room:");
		System.out.println(Arrays.toString(h.getAppliances()) + "\n");
		
		System.out.println("All appliances on the kitchen that have a power > 850W: \n" + h.kitchenAppl());
	}

}
