package com.example.foodOrderingSystem.Models;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	
	private Map<String, Double> menu;
	
	public Menu() {
		menu = new HashMap<>();
	}
	
	
	public void addOrUpdateItemToMenu(String item, double price) {
		menu.put(item, price);
	}
	
	public void removeItemFromMenu(String item) {
		if(menu.containsKey(item)) {
			menu.remove(item);
		}
	}
	

}
