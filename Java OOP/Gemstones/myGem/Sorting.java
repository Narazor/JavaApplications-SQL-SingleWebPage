package com.myGem;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
	// The class describes the methods which filter and sort a list of precious
	// stones

	public double getGeneralWeight(List<Gem> gems) {
		double generalWeight = 0;
		for (Gem g : gems) {
			generalWeight += g.getCaratWeight();
		}
		return generalWeight;
	}

	public double getGeneralPrice(List<Gem> gems) {
		double generalPrice = 0;
		for (Gem g : gems) {
			generalPrice += g.getPrice();
		}
		return generalPrice;
	}

	// The method returns all transparent gems 
	public List<Gem> getAllTransperent(List<Gem> gems) {
		List<Gem> transperent = new ArrayList<>();
		for (Gem g : gems) {
			if (g.checkTransperency().equals("transparent")) {
				transperent.add(g);
			}
		}
		return transperent;
	}

}
