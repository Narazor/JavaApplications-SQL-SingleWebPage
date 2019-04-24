package com.myGem;

import java.util.List;

public class MainGem {

	public static void main(String[] args) {

		Jelew jelew = new Jelew();
		Sorting sort = new Sorting();
		List<Gem> gem = jelew.creatJelew();

		System.out.println(gem);
		System.out.println("Sorted price: ");
		gem.sort(Gem.getPriceComparator());
		System.out.println(gem);
		System.out.println("Only transperent: ");
		System.out.println(sort.getAllTransperent(gem));
		System.out.printf("General weight - " + "%.2f \n", sort.getGeneralWeight(gem));
		System.out.printf("General price - " + "%.2f" + "$ \n", sort.getGeneralPrice(gem));
	}

}
