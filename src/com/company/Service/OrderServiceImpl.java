package com.company.Service;

import java.util.ArrayList;
import java.util.List;

import com.company.FoodOrderingStratergy.SelectionStratergy;
import com.company.Models.Order;
import com.company.Models.Restaurant;

public class OrderServiceImpl implements OrderService {
	private List<Restaurant> restaurants;

	public OrderServiceImpl() {
		this.restaurants = new ArrayList<>();
	}

	@Override
	public void onboardRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		if (restaurant == null || restaurant.getName() == null || restaurant.getName().isEmpty()) {
			throw new IllegalArgumentException("Invalid restaurant details");
		}
		System.out.println("Restaurant onboarded: "+ restaurant.getName());
		restaurants.add(restaurant);
	}

	@Override
	public void updateRestaurantMenu(String restaurantName, String item, double price) {
		// TODO Auto-generated method stub
		Restaurant restaurant = findRestaurantByName(restaurantName);
		if (restaurant == null) {
			throw new IllegalArgumentException("Restaurant not found");
		}

		if (restaurant.getMenu().containsKey(item)) {
			restaurant.updateMenuItem(item, price);
		} else {
			restaurant.addMenuItem(item, price);
		}
	}

	@Override
	public Order placeOrder(Order order) {
		// TODO Auto-generated method stub
		SelectionStratergy strategy = order.getSelectionStratergy();
		Restaurant selectedRestaurant = strategy.selectRestaurant(order, restaurants);

		if (selectedRestaurant == null) {
			throw new IllegalStateException("No restaurant can fulfill this order");
		}

		order.assignRestaurant(selectedRestaurant);
		System.out.println("Order of "+ order.getUserId() +" has been assigned to restaurant " + selectedRestaurant.getName());
		return order;
	}

	@Override
	public void completeOrder(Order order) {
		// TODO Auto-generated method stub
		if (order.getStatus() == Order.OrderStatus.ACCEPTED) {
			order.markCompleted();
			System.out.println("Order of " + order.getUserId() + " has been completed");
		} else {
			throw new IllegalStateException("Only ACCEPTED orders can be completed");
		}
	}

	@Override
	public List<Restaurant> getRestaurants() {
		// TODO Auto-generated method stub
		return restaurants;
	}

	private Restaurant findRestaurantByName(String name) {
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getName().equals(name)) {
				return restaurant;
			}
		}

		return null;
	}
}
