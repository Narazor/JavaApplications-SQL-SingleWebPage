package ua.myHypermarket;

public class Washbasin extends Plumbing {

	public Washbasin(String name, String producer, int price, int count, byte guarantee) {
		super(name, producer, price, count, guarantee);
	}

	@Override
	public String getNameOfProduct() {
		return "washbasins";
	}

}
