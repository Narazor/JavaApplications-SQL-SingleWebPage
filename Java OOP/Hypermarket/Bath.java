package ua.myHypermarket;

public class Bath extends Plumbing {

	public Bath(String name, String producer, int price, int count, byte guarantee) {
		super(name, producer, price, count, guarantee);
	}

	@Override
	public String getNameOfProduct() {
		return "bathes";
	}

}
