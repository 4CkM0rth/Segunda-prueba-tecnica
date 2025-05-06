import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
    const isAuth = this.authService.isAuthenticated();
    console.log('AuthGuard - authenticated:', isAuth);
    console.log('Token:', this.authService.getToken());
    if (isAuth) return true;
    this.router.navigate(['/login']);
    return false;
  }
}
