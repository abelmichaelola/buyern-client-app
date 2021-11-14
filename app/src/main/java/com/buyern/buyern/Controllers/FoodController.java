package com.buyern.buyern.Controllers;

import com.buyern.buyern.Models.Food;
import com.buyern.buyern.Models.FoodItem;
import com.buyern.buyern.Models.Price;

import java.util.ArrayList;

public class FoodController {
    public ArrayList<Food> getFoods() {
        ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
        foodItems.add(new FoodItem("String id", "String name", new Price("NGN", 204325,6584), true, true, true));
        Food food = new Food(
                "foodId", "amala and ewedu", "about Amala", foodItems, true, false, new Price("NGN", 204325,6584), "5th June 2021", true, false, null, "www.image.com"
        );
        ArrayList<Food> foodsList = new ArrayList<Food>();
        foodsList.add(food);
        foodsList.add(food);
        foodsList.add(food);
        foodsList.add(food);
        foodsList.add(food);
        foodsList.add(food);
        foodsList.add(food);
        foodsList.add(food);
        foodsList.add(food);
    return foodsList;
    }
}
