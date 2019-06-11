package ua.flowerShop.shop;
import java.util.LinkedList;
import java.util.List;

import ua.flowerShop.delivery.Delivery;
import ua.flowerShop.payment.Payment;
import ua.flowerShop.product.Product;

public class Order {
	
	private List<Product> products;
	private double totalCost = 0;
	private boolean isCompleted = false;
	private Payment paymentStrategy;
	private Delivery deliveryStrategy;
	
	public Order() {
		products = new LinkedList<Product>();
	}
	
	public Payment getPaymentStrategy() {
		return paymentStrategy;
	}
	
	public void setPaymentStrategy(Payment paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public Delivery getDeliveryStrategy() {
		return deliveryStrategy;
	}
	
	public void setDeliveryStrategy(Delivery deliveryStrategy) {
		this.deliveryStrategy = deliveryStrategy;
	}
	
	public List<Product> addGoods(Product product) {
		products.add(product);
		return products;
	}
	
	public void removeGoods(List<Product> product) {
		products.removeAll(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost += totalCost;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted() {
		isCompleted = true;
	}
	
}
