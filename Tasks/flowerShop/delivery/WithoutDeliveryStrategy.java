package ua.flowerShop.delivery;
import java.util.List;

import ua.flowerShop.product.Product;

public class WithoutDeliveryStrategy implements Delivery {

	@Override
	public boolean delivery(List<Product> products) {
		System.out.println("We are waiting for your arrival! \n");
		return true;
	}

	
	
}
