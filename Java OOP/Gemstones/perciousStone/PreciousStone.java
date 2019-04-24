package com.PerciousStone;

import com.myGem.Gem;

public abstract class PreciousStone extends Gem {
	 // The abstract class PreciousStone inherits all properties and methods from the
	 // class of Gem and creates own field


	private byte hardness; // on the Mohs scale

	public PreciousStone(String name, double caratWeight, double price, boolean transparency, byte hardness) {
		 // The constructor inherits a parent constructor and initializes an instance
		 // variable
		super(name, caratWeight, price, transparency);
		this.hardness = hardness;
	}


	public byte getHardness() {
		return hardness;
	}

	public void setHardness(byte hardness) {
		this.hardness = hardness;
	}

}
