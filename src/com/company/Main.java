package com.company;

import com.company.FoodOrderingStratergy.HighRatingStatergy;
import com.company.FoodOrderingStratergy.LowCostStratergy;
import com.company.FoodOrderingStratergy.ProvideStratergyFactory;
import com.company.Models.Order;
import com.company.Models.Restaurant;
import com.company.Service.OrderServiceImpl;

public class Main {

    public static void main(String[] args) {
	// write your code here
        OrderServiceImpl foodOrderingService = new OrderServiceImpl();

        Restaurant r1 = new Restaurant("r1", 4.5, 5);
        r1.addMenuItem("Veg Biryani", 100);
        r1.addMenuItem("Chicken Biryani", 150);
        foodOrderingService.onboardRestaurant(r1);

        Restaurant r2 = new Restaurant("r2", 4.0, 5);
        r2.addMenuItem("Idli", 10);
        r2.addMenuItem("Dosa", 50);
        r2.addMenuItem("Veg Biryani", 80);
        r2.addMenuItem("Chicken Biryani", 175);
        foodOrderingService.onboardRestaurant(r2);

        Restaurant r3 = new Restaurant("r3", 4.9, 1);
        r3.addMenuItem("Idli", 15);
        r3.addMenuItem("Dosa", 30);
        r3.addMenuItem("Gobi Manchurian", 150);
        r3.addMenuItem("Chicken Biryani", 175);
        foodOrderingService.onboardRestaurant(r3);

        r1.addMenuItem("Chicken65 ", 250);
        r2.updateMenuItem("Chicken Biryani", 150);

        Order order1 = new Order("SomeUserA", ProvideStratergyFactory.provideStratergy(ProvideStratergyFactory.StratergyEnum.LOWEST_COST));
        order1.addItem("Idli", 3);
        order1.addItem("Dosa", 1);
        foodOrderingService.placeOrder(order1);

        Order order2 = new Order("SomeUserB", ProvideStratergyFactory.provideStratergy(ProvideStratergyFactory.StratergyEnum.HIGHEST_RATING));
        order2.addItem("Veg Biryani", 3);
        order2.addItem("Dosa", 1);
        foodOrderingService.placeOrder(order2);

        foodOrderingService.completeOrder(order2);
    }
}
