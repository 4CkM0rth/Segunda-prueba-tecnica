import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent {
  name = '';
  description = '';
  price = 0;
  stock = 0;

  constructor(private productService: ProductService, private router: Router) {}

  createProduct() {
    const product = {
      name: this.name,
      description: this.description,
      price: this.price,
      stock: this.stock
    };

    this.productService.create(product).subscribe(
      () => this.router.navigate(['/products']),
      err => alert('Error al crear producto')
    );
  }
}
