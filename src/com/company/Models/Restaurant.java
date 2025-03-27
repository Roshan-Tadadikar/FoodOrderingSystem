package com.company.Models;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {
	private String name;
	private double rating;
	private int ordersAllowed;
	private int currentOrderCount;
	private Map<String, Double> menu;

	public Restaurant(String name, double rating, int maxOrders) {
		this.name = name;
		this.rating = rating;
		this.ordersAllowed = maxOrders;
		this.currentOrderCount = 0;
		this.menu = new HashMap<>();
	}

	public void addMenuItem(String item, double price) {
		menu.put(item, price);
		System.out.println("Menu : {name = "+ item + ", price ="+ price + "} added for Restaurant "+this.name);
	}

	public void updateMenuItem(String item, double price) {
		if (menu.containsKey(item)) {
			menu.put(item, price);
			System.out.println("Menu : {name = "+ item + ", price ="+ price + "} udpated for Restaurant "+this.name);
		}
	}

	public boolean canAcceptOrder() {
		return currentOrderCount < ordersAllowed;
	}

	public void incrementOrderCount() {
		currentOrderCount++;
	}

	public void decrementOrderCount() {
		if (currentOrderCount > 0) {
			currentOrderCount--;
		}
	}

	public String getName() {
		return name;
	}

	public double getRating() {
		return rating;
	}

	public Map<String, Double> getMenu() {
		return menu;
	}

	public int getCurrentOrderCount() {
		return currentOrderCount;
	}
}