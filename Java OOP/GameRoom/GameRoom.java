package com.gameRoom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRoom {
	// The class describes the methods that create a collection of toys which
	// depends on the dedicated sum of money

	private List<Toy> toys = createListOfToys();

	private List<Toy> createListOfToys() {
		List<Toy> toys = new ArrayList<>();
		toys.add(new Car("car", SizeToy.BIG, 16));
		toys.add(new Car("car", SizeToy.BIG, 19));
		toys.add(new Doll("doll", SizeToy.BIG, 12));
		toys.add(new Doll("doll", SizeToy.BIG, 15));
		toys.add(new Ball("ball", SizeToy.BIG, 11));
		toys.add(new Ball("ball", SizeToy.BIG, 14));
		toys.add(new Cube("cubes", SizeToy.BIG, 10));
		toys.add(new Cube("cubes", SizeToy.BIG, 13));
		toys.add(new Car("car", SizeToy.MEDIUM, 10));
		toys.add(new Car("car", SizeToy.MEDIUM, 12));
		toys.add(new Doll("doll", SizeToy.MEDIUM, 8));
		toys.add(new Doll("doll", SizeToy.MEDIUM, 9));
		toys.add(new Ball("ball", SizeToy.MEDIUM, 8));
		toys.add(new Ball("ball", SizeToy.MEDIUM, 9));
		toys.add(new Cube("cubes", SizeToy.MEDIUM, 7));
		toys.add(new Cube("cubes", SizeToy.MEDIUM, 8));
		toys.add(new Car("car", SizeToy.SMALL, 8));
		toys.add(new Car("car", SizeToy.SMALL, 10));
		toys.add(new Doll("doll", SizeToy.SMALL, 6));
		toys.add(new Doll("doll", SizeToy.SMALL, 7));
		toys.add(new Ball("ball", SizeToy.SMALL, 5));
		toys.add(new Ball("ball", SizeToy.SMALL, 6));
		toys.add(new Cube("cubes", SizeToy.SMALL, 5));
		toys.add(new Cube("cubes", SizeToy.SMALL, 6));
		return toys;
	}

	// The method searches for toys by type
	public List<Toy> getToyByType(int type) {
		List<Toy> typeToy = new ArrayList<>();
		for (Toy t : toys) {
			switch (type) {
			case 1:
				if (t.getType().equals("car")) {
					typeToy.add(t);
				}
				break;
			case 2:
				if (t.getType().equals("ball")) {
					typeToy.add(t);
				}
				break;
			case 3:
				if (t.getType().equals("doll")) {
					typeToy.add(t);
				}
				break;
			case 4:
				if (t.getType().equals("cubes")) {
					typeToy.add(t);
				}
				break;
			default:
				return null;
			}
		}
		return typeToy;
	}

	// The method searches for toys by size and returns a sorted list
	public List<Toy> getToyBySize(List<Toy> list, int size) {
		List<Toy> sizeToy = new ArrayList<>();
		for (Toy t : list) {
			switch (size) {
			case 1:
				if (t.getSize() == SizeToy.BIG) {
					sizeToy.add(t);
				}
				break;
			case 2:
				if (t.getSize() == SizeToy.MEDIUM) {
					sizeToy.add(t);
				}
				break;
			case 3:
				if (t.getSize() == SizeToy.SMALL) {
					sizeToy.add(t);
				}
				break;
			default:
				return null;
			}
		}
		Collections.sort(sizeToy, Toy.getPriceComparator());
		return sizeToy;
	}

	// The method searches for toys and returns a number of toys which depends on
	// dedicated sum of money
	public List<Toy> searchToyBySumOfMoney(List<Toy> sizeToy, int sum) {
		List<Toy> sumToy = new ArrayList<>();
		for (int i = sizeToy.size() - 1; i >= 0; i--) {
			do {
				if (sum >= sizeToy.get(i).getPrice()) {
					sum -= sizeToy.get(i).getPrice();
					sumToy.add(sizeToy.get(i));
				}
			} while (sum >= sizeToy.get(i).getPrice());
		}
		return sumToy;
	}

	// The method checks the balance of the user's money
	public int getRemainder(List<Toy> list, int sum) {
		int remainder = 0;
		for (Toy t : list) {
			remainder += t.getPrice();
		}
		return sum - remainder;
	}

	// The method adds the toy and its amount to map
	public Map<Toy, Integer> getToys(List<Toy> list) {
		Map<Toy, Integer> mapToy = new HashMap<Toy, Integer>();
		for (Toy t : list) {
			int count = 1;
			if (mapToy.containsKey(t)) {
				count += mapToy.get(t);
			}
			mapToy.put(t, count);
		}
		return mapToy;
	}

}