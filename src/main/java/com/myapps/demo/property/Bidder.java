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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



public class Bidder {

    public String id;
    public String username;

    public Bidder(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsernameString(String username) {
        this.username = username;
    }

}
