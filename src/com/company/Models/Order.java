package com.company.Models;

import java.util.ArrayList;
import java.util.List;

import com.company.FoodOrderingStratergy.SelectionStratergy;

public class Order {
	private String userId;

	@Override
	public String toString() {
		return "Order{" +
				"userId='" + userId + '\'' +
				", items=" + items +
				", status=" + status +
				", assignedRestaurant=" + assignedRestaurant +
				", selectionStrategy=" + selectionStrategy +
				'}';
	}

	private List<OrderItem> items;
	private OrderStatus status;
	private Restaurant assignedRestaurant;
	private SelectionStratergy selectionStrategy;

	public enum OrderStatus {
		PENDING, ACCEPTED, COMPLETED
	}

	public Order(String userId, SelectionStratergy strategy) {
		this.userId = userId;
		this.items = new ArrayList<>();
		this.status = OrderStatus.PENDING;
		this.selectionStrategy = strategy;
	}

	public void addItem(String item, int quantity) {
		items.add(new OrderItem(item, quantity));
	}

	public void assignRestaurant(Restaurant restaurant) {
		this.assignedRestaurant = restaurant;
		this.status = OrderStatus.ACCEPTED;
		restaurant.incrementOrderCount();
	}

	public void markCompleted() {
		if (status == OrderStatus.ACCEPTED) {
			status = OrderStatus.COMPLETED;
			assignedRestaurant.decrementOrderCount();
		}
	}
	
	public SelectionStratergy getSelectionStratergy() {
		return this.selectionStrategy;
	}

	public String getUserId() {
		return userId;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public Restaurant getAssignedRestaurant() {
		return assignedRestaurant;
	}
}
