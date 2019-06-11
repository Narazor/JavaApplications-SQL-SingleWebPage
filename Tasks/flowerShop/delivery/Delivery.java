package ua.flowerShop.delivery;
import java.util.List;

import ua.flowerShop.product.Product;

public interface Delivery {

	boolean delivery(List<Product> products);
	
}
