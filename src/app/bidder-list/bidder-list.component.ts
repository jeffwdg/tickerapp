import { Component, OnInit } from '@angular/core';
import { Bidder } from '../bidder.model';
import { BidderService } from '../services/bidder.service';
import { Observable } from 'rxjs';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-bidder-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './bidder-list.component.html',
  styleUrl: './bidder-list.component.css',
})
export class BidderListComponent implements OnInit {

  bidders: Bidder[] | undefined;

  constructor(private bidderService: BidderService) {

  }

  ngOnInit(): void {
    this.getBidders();
  }

  private getBidders() {
    this.bidderService.getBidderList().subscribe(data => {
      this.bidders = data;
    });
  }
}
