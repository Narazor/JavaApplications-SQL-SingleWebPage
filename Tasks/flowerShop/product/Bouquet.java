package ua.flowerShop.product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bouquet extends Product {
	
	List<Flower> flowers;

	public Bouquet(String description, List<Flower> flowers) {
		super(description);
		this.flowers = flowers;
	}
	
	// The method returns a total price all flowers in the bouquet
	@Override
	public double getPrice() {
		int price = 0;
		for(Flower flower : flowers) {
			price += flower.getPrice();
		}
		return price;
	}
	
	// The method returns an associative array(<Name flower, Number of flowers>) flowers in the bouquet
	public Map<String, Integer> getTypeAndAmountFlowersInBouquet() {
		Map<String, Integer> typeAndAmount = new HashMap<String, Integer>();
		for (Flower flower : flowers) {
			int amount = 1;
			if (typeAndAmount.containsKey(flower.getDescription())) {
				amount += typeAndAmount.get(flower.getDescription());
			}
			typeAndAmount.put(flower.getDescription(), amount);
		}
		return typeAndAmount;
	}
	
	@Override
	public String toString() {
		return getDescription() + getTypeAndAmountFlowersInBouquet() + "(" + getPrice() + "hrn)";
	}

}
