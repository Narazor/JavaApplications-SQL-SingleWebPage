package ua.myHouseholdApliances;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class House {
	// The class creates an array the devices and filters them by parameters

	private Appliance[] appliances = createAllAppliances();

	public Appliance[] getAppliances() {
		return appliances;
	}

	private Appliance[] createAllAppliances() {
		Appliance[] device = new Appliance[9];
		device[0] = new ClothingAppliances("Clothes dryer", 5400);
		device[1] = new KitchenAppliances("Electric kettle", 2400);
		device[2] = new EntertainmentAppliances("Home theatre system", 800);
		device[3] = new ClothingAppliances("Iron", 2600);
		device[4] = new KitchenAppliances("Microwave", 900);
		device[5] = new EntertainmentAppliances("Music center", 300);
		device[6] = new KitchenAppliances("Refrigerator", 810);
		device[7] = new EntertainmentAppliances("Personal computer", 800);
		device[8] = new ClothingAppliances("Washing machine", 770);
		return device;
	}

	private Appliance getRandAppliance() {
		int rand = (int) (Math.random() * appliances.length);
		return appliances[rand];
	}

	// The method plugs a random device into the outlet and adds it to a collection
	public Set<Appliance> plugIntoTheOutlet() {
		Set<Appliance> plugged = new HashSet<Appliance>();
		int r = (int) (1 + (Math.random() * 9));
		for (int i = 0; i < r; i++) {
			plugged.add(getRandAppliance());
		}
		return plugged;
	}

	public double calcConsumedEnergy(Set<Appliance> set) {
		double sumConsumedEnerge = 0;
		for (Appliance appl : set) {
			sumConsumedEnerge += appl.getPower();
		}
		return sumConsumedEnerge / 1000;
	}

	// The method look for all the appliances on the kitchen which have a power >
	// 850W
	public List<Appliance> kitchenAppl() {
		List<Appliance> kitchAppl = new ArrayList<>();
		for (int i = 0; i < appliances.length; i++) {
			if (appliances[i] instanceof KitchenAppliances && appliances[i].getPower() > 850) {
				kitchAppl.add(appliances[i]);
			}
		}
		return kitchAppl;
	}

}
