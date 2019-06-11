package ua.flowerShop.properties;

import ua.flowerShop.enums.CountryEnum;
import ua.flowerShop.enums.Size;

public class PropertiesFlowersWithSpines extends PropertyFlower {

	private double lengthOfStem;
	private Size sizeOfBud;

	public PropertiesFlowersWithSpines(CountryEnum countrySupplier, double lengthOfStem, Size sizeOfBud) {
		super(countrySupplier);
		this.lengthOfStem = lengthOfStem;
		this.sizeOfBud = sizeOfBud;
	}

	public double getLengthOfStem() {
		return lengthOfStem;
	}

	public Size getSizeOfBud() {
		return sizeOfBud;
	}

	// The method returns the price of flower, which depends on the length of stem,
	// on the size of bud and on the supplier
	public double getPrice() {
		int price = 35;
		if (getLengthOfStem() > 25) {
			price += 5;
		}
		if (getSizeOfBud() == Size.BIG) {
			price += 5;
		}
		if (getCountrySupplier() == CountryEnum.NETHERLANDS) {
			price += 7;
		}
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lengthOfStem);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sizeOfBud == null) ? 0 : sizeOfBud.hashCode());
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
		PropertiesFlowersWithSpines other = (PropertiesFlowersWithSpines) obj;
		if (Double.doubleToLongBits(lengthOfStem) != Double.doubleToLongBits(other.lengthOfStem))
			return false;
		if (sizeOfBud != other.sizeOfBud)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "supplier - " + getCountrySupplier() + ", length of the stem = " + getLengthOfStem()
				+ "cm, size of the bud - " + getSizeOfBud();
	}

}
