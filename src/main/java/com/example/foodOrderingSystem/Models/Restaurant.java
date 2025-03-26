package com.example.foodOrderingSystem.Models;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {
	private String name;
	private int ordersAllowed;
	private double rating;
	private Map<String, Integer> menu;
	private int totalOrders;

	public Restaurant(String name, int maxOrders, double rating) {
		this.name = name;
		this.ordersAllowed = maxOrders;
		this.rating = rating;
		this.menu = new HashMap<>();
		totalOrders = 0;
	}

	public boolean canAcceptOrder(Map<String, Integer> orderItems) {
		for(String item : orderItems.keySet()) {
			if(!menu.containsKey(item)) {
				return false;
			}
		}

		return true;
	}

	public void addOrUpdateMenuItem(String itemName, int price) {
		menu.put(itemName, price);
	}

	public boolean isAvailable() {
		return totalOrders < ordersAllowed;
	}

	public void incrementOrders() {
		totalOrders++;
	}

	public void decrementOrders() {
		totalOrders--;
	}

	public String getName() {
		return name;
	}

	public double getRating() {
		return rating;
	}

	public Map<String, Integer> getMenu() {
		return menu;
	}
}
