package com.company.FoodOrderingStratergy;

import com.company.Models.Order;
import com.company.Models.Restaurant;

import java.util.List;

public class HighRatingStatergy implements SelectionStratergy{

	@Override
	public Restaurant selectRestaurant(Order order, List<Restaurant> restaurants) {
		// TODO Auto-generated method stub
		Restaurant selectedRestaurant = null;
        double highestRating = -1;

        for (Restaurant restaurant : restaurants) {
            if (SelectionStratergy.canFulfillOrder(order, restaurant)) {
                if (restaurant.getRating() > highestRating && restaurant.canAcceptOrder()) {
                    highestRating = restaurant.getRating();
                    selectedRestaurant = restaurant;
                }
            }
        }

        return selectedRestaurant;
	}

}
