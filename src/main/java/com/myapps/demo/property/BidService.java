package com.myapps.demo.property;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BidService {

    public List<Property> getProperties() {
        return List.of(new Property(
                        "1",
                        "14 Flood St",
                        "New Orleads, LA70122",
                        "https://images.pexels.com/photos/388830/pexels-photo-388830.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                        5000.0, 40000.0),
                new Property(
                        "2",
                        "24 Washington Ave",
                        "New Orleads, LA70122",
                        "https://images.pexels.com/photos/259588/pexels-photo-259588.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",4000.0, 30000.0),
                new Property(
                        "3",
                        "289 Heampsted St",
                        "New Orleads, LA70122",
                        "https://images.pexels.com/photos/4526153/pexels-photo-4526153.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",6000.0, 35000.0),
                new Property(
                        "4",
                        "57 West Ave St",
                        "New Orleads, LA70122",
                        "https://images.pexels.com/photos/210617/pexels-photo-210617.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",7000.0,45000.0)
        );
    }

    public List<Bidder> getBidderList() {
        return List.of(new Bidder("1", "bidder1"),
                new Bidder("2", "bidder2"),
                new Bidder("3", "bidder3"),
                new Bidder("4", "bidder4"),
                new Bidder("5", "bidder5"),
                new Bidder("6", "bidder6"));
    }

    public List<Bid> sampleBidsProperty(String propertyId) {

        if(propertyId.equals("1")) {
            return List.of(new Bid("1", "1", "4",2200.0),
                    new Bid("2", "1", "2",3200.0),
                    new Bid("3", "1", "3",4200.0),
                    new Bid("4", "1", "6",5300.0),
                    new Bid("5", "1", "8",6300.0),
                    new Bid("6", "1", "11",7300.0),
                    new Bid("7", "1", "1",8200.0));
        }

        else if(propertyId.equals("2")) {
            return List.of(new Bid("1", "2", "2",2200.0),
                    new Bid("2", "2", "1",3200.0),
                    new Bid("3", "2", "2",4200.0),
                    new Bid("4", "2", "3",5300.0),
                    new Bid("3", "2", "4",4200.0),
                    new Bid("3", "2", "5",4400.0),
                    new Bid("3", "2", "5",4400.0),
                    new Bid("5", "2", "6",6300.0),
                    new Bid("6", "2", "7",7300.0),
                    new Bid("7", "2", "8",9200.0));
        }

        else if(propertyId.equals("3")) {
            return List.of(new Bid("1", "3", "4",2200.0),
                    new Bid("2", "3", "1",5200.0),
                    new Bid("3", "3", "3",4200.0),
                    new Bid("4", "3", "2",5300.0),
                    new Bid("7", "3", "5",4200.0));
        }

        else if(propertyId.equals("4")) {
            return List.of(new Bid("1", "4", "1",6200.0),
                    new Bid("2", "4", "7",3200.0),
                    new Bid("3", "4", "4",4200.0),
                    new Bid("5", "4", "2",2300.0),
                    new Bid("6", "4", "1",7300.0),
                    new Bid("7", "4", "2",4200.0));
        }

        return new ArrayList<>();
    }


    public Property getProperty(String propertyId) {
        if(propertyId == null){
            propertyId = "1";
        }

        if(propertyId != null) {
            if (propertyId.equals("1")) {
                return new Property(
                        "1",
                        "14 Flood St",
                        "New Orleads, LA70122",
                        "https://images.pexels.com/photos/388830/pexels-photo-388830.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                        5000.0,40000.0);
            }
            else if (propertyId.equals("2")) {
                System.out.println("pro"+propertyId);

                return new Property(
                        "2",
                        "24 Washington Ave",
                        "New Orleads, LA70122",
                        "https://images.pexels.com/photos/259588/pexels-photo-259588.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2", 4000.0,30000.0);
            }
            else if (propertyId.equals("3")) {
                return new Property(
                        "3",
                        "289 Heampsted St",
                        "New Orleads, LA70122",
                        "https://images.pexels.com/photos/4526153/pexels-photo-4526153.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2", 6000.0,35000.0);
            }
            else if (propertyId.equals("4")) {
                return new Property(
                        "4",
                        "57 West Ave St",
                        "New Orleads, LA70122",
                        "https://images.pexels.com/photos/210617/pexels-photo-210617.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2", 7000.0,45000.0);
            }
        }

        return  new Property();
    }
    

    public List<Double> getPropertyBids(String propertyId, String bidderId) {
        //this gets the winning, active and outbids;
        if(propertyId == null){
            propertyId = "1";
        }

        List<Bid> propertyBids = sampleBidsProperty(propertyId);
        List<Double> bids = new ArrayList<>();

        //get winning bid
        Double winningbid = propertyBids.stream()
                .mapToDouble(v -> v.getBidAmount())
                .max().orElseThrow(NoSuchElementException::new);
        bids.add(winningbid);

        //get active bid
        bids.add(Double.valueOf(propertyBids.size()));

        //get outbid
        bids.add(getOutBid(propertyBids,bidderId, propertyId));

        return bids;
    }

    public Double getOutBid(List<Bid> propertyBids, String bidderId, String propertyId){
        Double myBidVal = 0.0;
        Optional<Bid> myBid = propertyBids.stream().filter(p -> p.bidderId.equals(bidderId)).findFirst();

        if(!myBid.isEmpty()){
            myBidVal = myBid.get().getBidAmount();
         }

        Double maxBid = propertyBids.stream().mapToDouble(p -> p.getBidAmount()).max().orElseThrow(NoSuchElementException::new);
        List<Double> bids =  propertyBids.stream().mapToDouble(s -> s.getBidAmount()).boxed().collect(Collectors.toList());

        return greaterCounter(bids, myBidVal);
    }

    public Double greaterCounter(List<Double> input, Double myBidVal){
            Integer count = 0;

            for (Double j : input){
                if (myBidVal > j) {
                    count++;
                }
            }
            return (count).doubleValue();
    }

    public List<Bid> getMyBids(String propertyId, String bidderId) {
        System.out.println(bidderId);

        List<Bid> myBids = sampleBidsProperty(propertyId).stream().filter(b -> b.getBidderId().equals(bidderId)).collect(Collectors.toList());
        return myBids;
    }
}