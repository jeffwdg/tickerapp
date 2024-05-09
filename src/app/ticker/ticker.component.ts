import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Property } from '../property';
import { PropertyService } from '../services/property-service.service';
import { Bidder } from '../bidder.model';
import { Bid } from '../bid';
import { BidderService } from '../services/bidder.service';
import { BidService } from '../services/bid-service.service';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { NgModule } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-ticker',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ticker.component.html',
  styleUrl: './ticker.component.css'
})
export class TickerComponent implements OnInit {
  bidders: Bidder[] | undefined;
  bids: Bid[] | undefined;
  mybid: Bid[] | undefined;
  property: Property;
  properties!: Property[] | undefined;
  pBids: number[];


  constructor(
    private bidService: BidService,
    private propertyService: PropertyService,
    private route: ActivatedRoute) {

    this.mybid = [ { id: '2', propertyId: '3', bidderId: '1', bidAmount: "3200" } ];
  }

  ngOnInit(): void {
    this.getProperty();
    this.getProperties();
    this.getPropertyBids();
    this.getMyBids();
  }

  getProperty(): void {
    const id = this.route.snapshot.params['id'];
    this.propertyService.getProperty(id).subscribe(property => this.property = property);
  }

  private getProperties() {
    this.propertyService.findAll().subscribe(data => {
      this.properties = data;
    });
  }

  private getPropertyBids() {
    const id = this.route.snapshot.params['id'];
    const bidderId = this.route.snapshot.params['bidderId'];
        console.log(bidderId);

    this.bidService.getPropertyBids(id, bidderId).subscribe(data => {
      this.pBids = data;
    });
  }


  private getMyBids() {
      const id = this.route.snapshot.params['id'];
      const bidderId = this.route.snapshot.params['bidderId'];

      this.bidService.getMyBids(id, bidderId).subscribe(data => {
        this.mybid = data;
      });

    }

  private getBids() {
    this.bidService.getBidList().subscribe(data => {
      this.bids = data;
    });
  }
}

