package com.company.FoodOrderingStratergy;

import com.company.Models.Order;
import com.company.Models.OrderItem;
import com.company.Models.Restaurant;

import java.util.List;


public interface SelectionStratergy {
	Restaurant selectRestaurant(Order order, List<Restaurant> restaurants);

	public static boolean canFulfillOrder(Order order, Restaurant restaurant) {
		for (OrderItem item : order.getItems()) {
			if (!restaurant.getMenu().containsKey(item.getItemName())) {
				return false;
			}
		}
		return true;
	}

}
