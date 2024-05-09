package com.myapps.demo.property;

/*
develop the ticker API endpoint that returns data on
your_bids (broken down into outbid, active and winning bid counts),
your_bid_amounts (broken_down into dollar value amount of outbid, active and winning bids),
and property_listing (the street address of property, the current winning bid amount,
and the negative or positive value of the last bid amount, different images)

you can use fake data so long as i can toggle through different properties and their information (address, image) would change
*/
import org.springframework.web.bind.annotation.*;

public class Bid {

    public String id;
    public String propertyId;
    public String bidderId;
    public Double bidAmount;


    public Bid(String id, String propertyId, String bidderId, Double bidAmount) {
        this.id = id;
        this.propertyId = propertyId;
        this.bidderId = bidderId;
        this.bidAmount = bidAmount;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getBidderId() {
        return bidderId;
    }

    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }
}
