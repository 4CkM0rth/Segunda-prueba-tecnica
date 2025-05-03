import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  imports: [
    FormsModule
  ],
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent {
  name = '';
  price = 0;

  constructor(private productService: ProductService) {}

  createProduct() {
    const product = { name: this.name, price: this.price };
    this.productService.create(product).subscribe(
      () => alert('Product created'),
      err => alert('Creation failed')
    );
  }
}
