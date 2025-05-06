import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../services/product.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})

export class ProductListComponent implements OnInit {
  products: any[] = [];

  filterName = '';
  filterPrice: number | null = null;
  filterDate = '';

  constructor(private productService: ProductService, private router: Router) {}


  ngOnInit(): void {
    this.productService.getAll().subscribe((data: any[]) => {
      this.products = data;
    });
  }

  navigateToCreate(): void {
    this.router.navigate(['/create']);
  }

  filteredProducts() {
    return this.products.filter(product => {
      return (!this.filterName || product.name.toLowerCase().includes(this.filterName.toLowerCase())) &&
        (!this.filterPrice || product.price === this.filterPrice) &&
        (!this.filterDate || product.createdAt.startsWith(this.filterDate));
    });
  }
}
