package com.gameRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class MainGameRoom {

	GameRoom gm = new GameRoom();
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println(new MainGameRoom().checkByMoney(bf));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Toy> checkByType(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.println("What type of toy do you want: 1) car; 2) ball; 3)doll; 4)cubes?");
		int type = Integer.parseInt(bf.readLine());
		return gm.getToyByType(type);
	}
	
	public List<Toy> checkBySize(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.println("What size of toy do you want: 1) big; 2) medium; 3)small?");
		int size = Integer.parseInt(bf.readLine());
		return gm.getToyBySize(checkByType(bf), size);
	}
	
	public Map<Toy, Integer> checkByMoney(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.println("What sum of money can you spend (in hrn)?");
		int sum = Integer.parseInt(bf.readLine());
		List<Toy> list = gm.searchToyBySumOfMoney(checkBySize(bf), sum);
		System.out.println("Your remainder: " + gm.getRemainder(list, sum) + " hrn.");
		System.out.println("At you disposal the following toys: ");
		return gm.getToys(list);
	}
	

}
