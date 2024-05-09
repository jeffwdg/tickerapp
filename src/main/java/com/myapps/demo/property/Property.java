package com.myapps.demo.property;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.*;

/*
develop the ticker API endpoint that returns data on
your_bids (broken down into outbid, active and winning bid counts),
your_bid_amounts (broken_down into dollar value amount of outbid, active and winning bids),
and property_listing (the street address of property, the current winning bid amount,
and the negative or positive value of the last bid amount, different images)

you can use fake data so long as i can toggle through different properties and their information (address, image) would change
*/

public class Property {

    public String id;
    public String street;
    public String address;
    public String image;
    public Double reservePrice;
    public Double marketValue;


    public Property() {
    }

    public Property(String id, String street,String address, String image, Double reservePrice, Double marketValue) {
        this.id = id;
        this.street = street;
        this.address = address;
        this.image = image;
        this.reservePrice = reservePrice;
        this.marketValue = marketValue;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Double reservePrice) {
        this.reservePrice = reservePrice;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}