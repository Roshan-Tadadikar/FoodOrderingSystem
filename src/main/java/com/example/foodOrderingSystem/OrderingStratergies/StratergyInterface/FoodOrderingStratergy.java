package com.example.foodOrderingSystem.OrderingStratergies.StratergyInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.foodOrderingSystem.Models.Restaurant;

public interface FoodOrderingStratergy {
	Restaurant selectRestaurant(List<Restaurant> restaurants, Map<String, Integer> orderItems);

	public static List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants,
			Map<String, Integer> orderItems) {
		
		List<Restaurant> filteredRestaurants = new ArrayList<>();
		
		for (Restaurant restaurant : restaurants) {
			Map<String, Integer> restaurantMenu = restaurant.getMenu();
			boolean containsAllItems = true;
			for (String items : orderItems.keySet()) {
				if (!restaurantMenu.containsKey(items)) {
					containsAllItems = false;
					break;
				}
			}

			if (containsAllItems) {
				filteredRestaurants.add(restaurant);
			}
		}
		
		return filteredRestaurants;
	}
}
