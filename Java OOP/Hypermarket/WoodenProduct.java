package ua.myHypermarket;

public abstract class WoodenProduct extends Product {

	private boolean insurancee;

	public WoodenProduct(String name, String producer, int price, int count, boolean insurancee) {
		super(name, producer, price, count);
		this.insurancee = insurancee;
	}

	public boolean getGuarantee() {
		return insurancee;
	}

	public void setGuarantee(boolean insurancee) {
		this.insurancee = insurancee;
	}

	@Override
	public String toString() {
		return "Product name - " + getName() + "; producer - " + getProducer() + "; price - " + getPrice() + "$"
				+ "; in stock - " + getCount() + "; insurancee - " + getGuarantee() + "....";
	}

}
