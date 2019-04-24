package ua.myHouseholdApliances;

import java.util.Comparator;

public abstract class Appliance {
	// An abstract class Appliance describes all the necessary properties and
	// methods for all household appliances

	private static PowerComparator powerComparator = new PowerComparator();
	private String name;
	private int power; // volt(V)

	public Appliance(String name, int power) {
		this.name = name;
		this.power = power;
	}

	public static PowerComparator getPowerComparator() {
		return powerComparator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	private static class PowerComparator implements Comparator<Appliance> {
		@Override
		public int compare(Appliance appl1, Appliance appl2) {
			return appl1.getPower() - appl2.getPower();
		}
	}

	@Override
	public String toString() {
		return "Appliance: " + getName() + ", power = " + power + " V";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Appliance other = (Appliance) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
