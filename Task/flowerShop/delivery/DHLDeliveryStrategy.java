package ua.flowerShop.delivery;
import java.util.List;

import ua.flowerShop.product.Product;

public class DHLDeliveryStrategy implements Delivery {

	@Override
	public boolean delivery(List<Product> products) {
		System.out.printf("Delivery the following goods %s using DHL Express! \n", products);
		return true;
	}

}
