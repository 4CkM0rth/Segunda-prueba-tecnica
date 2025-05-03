import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  imports: [
    FormsModule
  ],
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  username = '';
  password = '';

  constructor(private authService: AuthService) {}

  register() {
    this.authService.register({ username: this.username, password: this.password }).subscribe(
      res => alert('User registered'),
      err => alert('Registration failed')
    );
  }
}
