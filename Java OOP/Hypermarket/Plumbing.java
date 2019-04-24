package ua.myHypermarket;

public abstract class Plumbing extends Product {

	private byte guarantee;

	public Plumbing(String name, String producer, int price, int count, byte guarantee) {
		super(name, producer, price, count);
		this.guarantee = guarantee;
	}

	public byte getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(byte guarantee) {
		this.guarantee = guarantee;
	}

	@Override
	public String toString() {
		return "Product name - " + getName() + "; producer - " + getProducer() + "; price - " + getPrice() + "$"
				+ "; in stock - " + getCount() + "; guarantee - " + getGuarantee() + " years....";
	}

}
