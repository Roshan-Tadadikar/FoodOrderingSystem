package com.example.foodOrderingSystem.OrderingStratergies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.example.foodOrderingSystem.Models.Restaurant;
import com.example.foodOrderingSystem.OrderingStratergies.StratergyInterface.FoodOrderingStratergy;

public class LowCostStratergy implements FoodOrderingStratergy {

	@Override
	public Restaurant selectRestaurant(List<Restaurant> restaurants, Map<String, Integer> orderItems) {
		List<Restaurant> filteredRestaurants = FoodOrderingStratergy.getFilteredRestaurants(restaurants, orderItems);

		Restaurant restaurantWithLowestCost = null;
		int minCostOfItems = Integer.MAX_VALUE;
		for (Restaurant restaurant : filteredRestaurants) {
			int cost = 0;
			Map<String, Integer> currentMenu = restaurant.getMenu();
			for (String item : orderItems.keySet()) {
				cost += currentMenu.get(item);
			}
			if (cost < minCostOfItems) {
				cost = minCostOfItems;
				restaurantWithLowestCost = restaurant;
			}
		}

		return restaurantWithLowestCost;
	}

}
