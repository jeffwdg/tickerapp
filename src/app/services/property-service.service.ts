import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Property } from '../property';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PropertyService{

  private basUrl = "http://localhost:8080/bid/properties";
  private propertyUrl = "http://localhost:8080/bid/getProperty";

  constructor(private httpClient: HttpClient) {
  }

   public findAll(): Observable<Property[]> {
       return this.httpClient.get<Property[]>(`${this.basUrl}`);
   }

  getProperty(id: string): Observable<Property> {
      const url = `${this.propertyUrl}/${id}`;
      return this.httpClient.get<Property>(url);
  }

   public getPropertyV2(): Observable<Property[]> {
          return this.httpClient.get<Property[]>(`${this.propertyUrl}`);
   }
}
