package ua.flowerShop.delivery;
import java.util.List;

import ua.flowerShop.product.Product;

public class PostDeliveryStrategy implements Delivery{

	@Override
	public boolean delivery(List<Product> products) {
		System.out.printf("Delivery the following goods %s using New Post! \n", products);
		return true;
	}

}
