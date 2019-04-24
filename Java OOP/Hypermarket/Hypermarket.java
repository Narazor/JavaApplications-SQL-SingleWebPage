package ua.myHypermarket;

import java.util.ArrayList;
import java.util.List;

public class Hypermarket {
	// The class creates a list of products and describes the product filtering
	// methods by parameters

	private List<Product> products = createListOfProducts();

	private List<Product> createListOfProducts() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Bath("Bath", "Germany", 480, 34, (byte) 5));
		products.add(new Door("Door", "Germany", 50, 340, true));
		products.add(new Wardrobe("Wardrobe", "Germany", 60, 200, true));
		products.add(new Washbasin("Washbasin", "Germany", 180, 40, (byte) 5));
		products.add(new Bath("Bath", "Italy", 420, 22, (byte) 5));
		products.add(new Door("Door", "Italy", 45, 280, true));
		products.add(new Wardrobe("Wardrobe", "Italy", 75, 144, true));
		products.add(new Washbasin("Washbasin", "Italy", 200, 28, (byte) 4));
		products.add(new Bath("Bath", "China", 300, 70, (byte) 2));
		products.add(new Door("Door", "China", 20, 500, false));
		products.add(new Wardrobe("Wardrobe", "China", 35, 500, true));
		products.add(new Washbasin("Washbasin", "China", 150, 70, (byte) 1));
		return products;
	}

	// The method returns a list of goods that the user has chosen (plumbing or
	// wooden products in this case)
	public List<Product> getPlumbingOrWoodenProducts(String findProduct) {
		List<Product> prod = new ArrayList<Product>();
		for (Product p : products) {
			switch (findProduct.toLowerCase()) {
			case "plumbing":
				if (p instanceof Plumbing) {
					prod.add(p);
				}
				break;
			case "wooden products":
				if (p instanceof WoodenProduct) {
					prod.add(p);
				}
				break;
			default:
				break;
			}
		}
		return prod;
	}

	// The method returns a list of goods that the user has chosen
	// (bathes/washbasins/wardrobes/door in this case)
	public List<Product> getSpecificProduct(String findProduct) {
		List<Product> specificProduct = new ArrayList<Product>();
		for (Product p : products) {
			if (p.getNameOfProduct().equals(findProduct)) {
				specificProduct.add(p);
			}
		}
		return specificProduct;
	}

	 // The method returns a list of goods that the user has chosen and if the price
	 // is less than the specified
	public List<Product> getCheaperProduct(List<Product> specificProduct, int price) {
		List<Product> cheaperThan = new ArrayList<Product>();
		for (Product p : specificProduct) {
			if (p.getPrice() <= price) {
				cheaperThan.add(p);
			}
		}
		return cheaperThan;
	}

	public int getMinPrice(List<Product> product) {
		product.sort(Product.getPriceComparator());
		return product.get(0).getPrice();
	}

	public int getMaxPrice(List<Product> product) {
		product.sort(Product.getPriceComparator());
		return product.get(product.size() - 1).getPrice();
	}

}
