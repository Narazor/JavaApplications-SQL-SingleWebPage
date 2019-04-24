package com.myGem;

import java.util.ArrayList;
import java.util.List;

import com.PerciousStone.*;
import com.SemiPreciousStone.*;

public class Jelew {
	// The class describes the methods that create a collection of gems

	// The method returns a random instance a class PreciousStone
	public PreciousStone createArrPreciousStone() {
		PreciousStone[] prSt = { new Diamond("Diamond", 1.4, 14313.51, true, (byte) 10),
				new Diamond("Diamond", 0.8, 9300.1, true, (byte) 10), new Ruby("Ruby", 2.0, 10384.534, true, (byte) 9),
				new Ruby("Ruby", 1.5, 4214.5, true, (byte) 9), new Emerald("Emerald", 0.6, 3022.4, true, (byte) 8),
				new Emerald("Emerald", 0.9, 5611.14, true, (byte) 8),
				new BlueSapphire("Blue Sapphire", 0.3, 2021.9, true, (byte) 9),
				new BlueSapphire("Blue Sapphire", 0.6, 5891.32, true, (byte) 9), };
		int r = (int) (Math.random() * prSt.length);
		return prSt[r];

	}

	// The method returns a random instance a class Semi_PreciousStone
	public Semi_PreciousStone createArrSemi_PreciousStone() {
		Semi_PreciousStone[] smPrSt = { new Nephritis("Nephritis", 7.0, 74.58, false),
				new Aquamarine("Aquamarine", 7.7, 539.8, false), new Opal("Opal", 4.1, 141.70, false),
				new TigerEye("Tiger eye", 5.3, 2.3, false), };
		int r = (int) (Math.random() * smPrSt.length);
		return smPrSt[r];

	}

	// The method returns a random list of gems that creates a necklace
	public List<Gem> creatJelew() {
		List<Gem> g = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			g.add(createArrPreciousStone());
			g.add(createArrSemi_PreciousStone());
		}
		return g;
	}

}
