import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent {

  constructor(
    private router: Router
  ) { }

  signIn() {
    this.router.navigate(['/dashboard']);
  }

  signUp() {
    this.router.navigate(['/signup']);
  }

}
