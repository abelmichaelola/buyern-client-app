package com.buyern.buyern.Models;

public class  FoodItem {
    private String id;
    private String name;
    private Price price;
    private boolean quantitySelectable;
    private boolean isAvailable;
    private boolean onPublicListing;

    public FoodItem() {
    }

    public FoodItem(String id, String name, Price price, boolean quantitySelectable, boolean isAvailable, boolean onPublicListing) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantitySelectable = quantitySelectable;
        this.isAvailable = isAvailable;
        this.onPublicListing = onPublicListing;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public boolean isQuantitySelectable() {
        return quantitySelectable;
    }

    public void setQuantitySelectable(boolean quantitySelectable) {
        this.quantitySelectable = quantitySelectable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isOnPublicListing() {
        return onPublicListing;
    }

    public void setOnPublicListing(boolean onPublicListing) {
        this.onPublicListing = onPublicListing;
    }
}
