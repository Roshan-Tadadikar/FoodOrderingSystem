package com.company.Service;

import java.util.List;

import com.company.Models.Order;
import com.company.Models.Restaurant;

public interface OrderService {
	 public void onboardRestaurant(Restaurant restaurant);
	 public void updateRestaurantMenu(String restaurantName, String item, double price);
	 public Order placeOrder(Order order);
	 public void completeOrder(Order order);
	 public List<Restaurant> getRestaurants();
}
