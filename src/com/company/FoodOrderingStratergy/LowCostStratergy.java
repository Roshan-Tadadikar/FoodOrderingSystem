package com.company.FoodOrderingStratergy;

import com.company.Models.Order;
import com.company.Models.OrderItem;
import com.company.Models.Restaurant;

import java.util.List;


public class LowCostStratergy implements SelectionStratergy {

	@Override
	public Restaurant selectRestaurant(Order order, List<Restaurant> restaurants) {
		// TODO Auto-generated method stub
		Restaurant selectedRestaurant = null;
		double lowestCost = Double.MAX_VALUE;

		for (Restaurant restaurant : restaurants) {
			if (SelectionStratergy.canFulfillOrder(order, restaurant)) {
				double totalCost = calculateOrderCost(order, restaurant);

				if (totalCost < lowestCost && restaurant.canAcceptOrder()) {
					lowestCost = totalCost;
					selectedRestaurant = restaurant;
				}
			}
		}

		return selectedRestaurant;
	}
	

	public double calculateOrderCost(Order order, Restaurant restaurant) {
        double totalCost = 0;
        for (OrderItem item : order.getItems()) {
            totalCost += restaurant.getMenu().get(item.getItemName()) * item.getQuantity();
        }
        return totalCost;
    }
}
