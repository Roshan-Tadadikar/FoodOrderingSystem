package com.example.foodOrderingSystem.Models;

import java.util.Map;

import com.example.foodOrderingSystem.AppConstants.AppConstants;

public class Order {
	private String user;
	private Map<String, Integer> itemsToCook;
	private String assignedRestaurant;
	private String orderStatus;

	public Order(String user, Map<String, Integer> itemsToCook) {
		this.user = user;
		this.itemsToCook = itemsToCook;
		this.orderStatus = "";
	}

	public void assignRestaurant(String restaurant) {
		this.assignedRestaurant = restaurant;
	}

	public void markCompleted() {
		if (orderStatus.equals(AppConstants.ORDER_COMPLETED)) {
			throw new IllegalStateException("Order is already completed.");
		}
		this.orderStatus = AppConstants.ORDER_COMPLETED;
	}

	public boolean isCompleted() {
		return orderStatus.equals(AppConstants.ORDER_COMPLETED);
	}

	public String getUser() {
		return user;
	}

	public Map<String, Integer> getItems() {
		return itemsToCook;
	}

	public String getAssignedRestaurant() {
		return assignedRestaurant;
	}
}
