package com.myapps.demo.property;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path="/bid")
@CrossOrigin(origins = "http://localhost:4200")
public class PropertyBidController {

        private final BidService bidService;

        public PropertyBidController(BidService bidService){
            this.bidService = bidService;
        }

        @GetMapping("/bidders")
        @ResponseStatus(value = HttpStatus.OK)
        public List<Bidder> getBidderList(Model model) {
            model.addAttribute("bidders", bidService.getBidderList());
            return bidService.getBidderList();
        }


        @GetMapping("/properties")
        @ResponseStatus(value = HttpStatus.OK)
        public List<Property> getProperties(Model model) {
            model.addAttribute("properties", bidService.getProperties());
            return bidService.getProperties();
        }

        @GetMapping(value = "/getProperty/{propertyId}")
        @ResponseStatus(value = HttpStatus.OK)
        public Property getProperty(@PathVariable("propertyId") String propertyId, Model model){
           System.out.println("prpertyId="+propertyId);
            if(propertyId != null){
                return bidService.getProperty(propertyId);
            }
           return new Property();
        }

        @GetMapping(value = "/getPropertyBids/{propertyId}/{bidderId}")
        @ResponseStatus(value = HttpStatus.OK)
        public List<Double> getPropertyBids(@PathVariable("propertyId") String propertyId, @PathVariable("bidderId") String bidderId, Model model){
            model.addAttribute("properties", bidService.getPropertyBids(propertyId, bidderId));
            return bidService.getPropertyBids(propertyId, bidderId);
        }

        @GetMapping(value = "/getMyBids/{propertyId}/{bidderId}")
        @ResponseStatus(value = HttpStatus.OK)
        public List<Bid> getMyBids( @PathVariable("propertyId") String propertyId, @PathVariable("bidderId") String bidderId){
            return bidService.getMyBids(propertyId, bidderId);
        }
    }
