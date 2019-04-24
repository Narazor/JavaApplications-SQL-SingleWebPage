package ua.myHypermarket;

import java.util.Comparator;

public abstract class Product implements Department {
	// An abstract class Product describes all the necessary properties and methods
	// for all goods

	private static PriceComparator priceComparator = new PriceComparator();
	private String name;
	private String producer;
	private int price;
	private int count; // in stock

	public Product(String name, String producer, int price, int count) {
		this.name = name;
		this.producer = producer;
		this.price = price;
		this.count = count;
	}

	public static PriceComparator getPriceComparator() {
		return priceComparator;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return this.producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private static class PriceComparator implements Comparator<Product> {
		@Override
		public int compare(Product g1, Product g2) {
			return g1.getPrice() - g2.getPrice();
		}
	}

}
