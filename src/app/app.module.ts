import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BidderListComponent } from './bidder-list/bidder-list.component';
import { FormsModule } from '@angular/forms';
import { PropertyListComponent } from './property-list/property-list.component';
import { BidderService } from './services/bidder.service';
import { PropertyService } from '../services/property-service.service';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    BidderListComponent,
    PropertyListComponent,
    TickerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    NgModule,
    CommonModule,
    TickerComponent
  ],
  providers: [BidderService, PropertyService, BidService],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA,CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
