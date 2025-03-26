package com.example.foodOrderingSystem.OrderingStratergies;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.example.foodOrderingSystem.Models.Restaurant;
import com.example.foodOrderingSystem.OrderingStratergies.StratergyInterface.FoodOrderingStratergy;

public class HighRatingStratergy implements FoodOrderingStratergy {

	@Override
	public Restaurant selectRestaurant(List<Restaurant> restaurants, Map<String, Integer> orderItems) {
		List<Restaurant> filteredRestaurants = FoodOrderingStratergy.getFilteredRestaurants(restaurants, orderItems);

		Collections.sort(filteredRestaurants, (a, b) -> Double.compare(b.getRating(), a.getRating()));

		try {

			return filteredRestaurants.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
