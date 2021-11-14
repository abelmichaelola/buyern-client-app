package com.buyern.buyern.Models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class Food {
    private String name;
    private String about;
    private ArrayList<FoodItem> items;
    private boolean isAvailable;
    private String id;
    private boolean isDraft;
    private Price price;
    private String dateAdded;
    private boolean privateListing;
    private boolean publicListed;
    private Array publicListings;
    private String image;

    public Food() {
    }

    public Food(String id, String name, String about, ArrayList<FoodItem> items, boolean isAvailable, boolean isDraft, Price price, String dateAdded, boolean privateListing, boolean publicListed, Array publicListings, String image) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.items = items;
        this.isAvailable = isAvailable;
        this.isDraft = isDraft;
        this.price = price;
        this.dateAdded = dateAdded;
        this.privateListing = privateListing;
        this.publicListed = publicListed;
        this.publicListings = publicListings;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public ArrayList<FoodItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<FoodItem> items) {
        this.items = items;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isPrivateListing() {
        return privateListing;
    }

    public void setPrivateListing(boolean privateListing) {
        this.privateListing = privateListing;
    }

    public boolean isPublicListed() {
        return publicListed;
    }

    public void setPublicListed(boolean publicListed) {
        this.publicListed = publicListed;
    }

    public Array getPublicListings() {
        return publicListings;
    }

    public void setPublicListings(Array publicListings) {
        this.publicListings = publicListings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
