import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bidder } from '../bidder.model';

@Injectable({
  providedIn: 'root'
})
export class BidderService {

  private basUrl = "http://localhost:8080/bid/bidders"

  constructor(private httpClient: HttpClient) {
  }

  getBidderList(): Observable<Bidder[]> {
    return this.httpClient.get<Bidder[]>(`${this.basUrl}`);
  }

}
