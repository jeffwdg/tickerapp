import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bid } from '../bid';

@Injectable({
  providedIn: 'root'
})
export class BidService {

  private basUrl = "http://localhost:8080/bid/getProperty/1"
  private bidUrl = "http://localhost:8080/bid/getPropertyBids"
  private mybidUrl = "http://localhost:8080/bid/getMyBids"

  constructor(private httpClient: HttpClient) {
  }

  getBidList(): Observable<Bid[]> {
    return this.httpClient.get<Bid[]>(`${this.basUrl}`);
  }

  getPropertyBids(id: string, bidderId: string): Observable<number[]> {
      const url = `${this.bidUrl}/${id}/${bidderId}`;
      return this.httpClient.get<number[]>(url);
  }

  getMyBids(id: string, bidderId: string): Observable<Bid[]> {
        console.log("getting mybids" + bidderId);
        const url = `${this.mybidUrl}/${id}/${bidderId}`;
        return this.httpClient.get<Bid[]>(url);
  }

}
