package ua.flowerShop.properties;

import ua.flowerShop.enums.CountryEnum;

public class PropertiesFlowersWithConstantForm extends PropertyFlower {

	private double price;

	public PropertiesFlowersWithConstantForm(CountryEnum countrySupplier, double price) {
		super(countrySupplier);
		this.price = price;
	}

	// The method returns the price of flower, which depends on the supplier
	@Override
	public double getPrice() {
		if (getCountrySupplier().equals(CountryEnum.HOLLAND)) {
			price += 10;
		}
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertiesFlowersWithConstantForm other = (PropertiesFlowersWithConstantForm) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "supplier - " + getCountrySupplier();
	}

}
