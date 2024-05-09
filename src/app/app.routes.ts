import { NgModule } from '@angular/core';
import { Routes } from '@angular/router';
import { RouterModule } from '@angular/router';
import { BidderListComponent } from './bidder-list/bidder-list.component';
import { TickerComponent } from './ticker/ticker.component';
import { PropertyListComponent } from './property-list/property-list.component';

export const routes: Routes = [
  { path: 'bidders',
    component: BidderListComponent
  },
  { path: 'ticker',
    component: TickerComponent
  },
  { path: 'properties',
    component: PropertyListComponent
  },
  { path: 'ticker/:id',
    component: TickerComponent
  },
  { path: 'ticker/:id/:bidderId',
      component: TickerComponent
  },
  { path: '',
    redirectTo: '',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

