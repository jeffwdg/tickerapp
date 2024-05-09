import { Component, OnInit } from '@angular/core';
import { Property } from '../property';
import { PropertyService } from '../services/property-service.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-property-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './property-list.component.html',
  styleUrl: './property-list.component.css'
})
export class PropertyListComponent implements OnInit {
  properties: Property[];

  constructor(private propertyService: PropertyService) {
  }

  ngOnInit() {
    this.propertyService.findAll().subscribe(data => {
      this.properties = data;
    });
  }
}
