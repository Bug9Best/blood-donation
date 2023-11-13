import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent {

  formData: FormGroup = new FormGroup({
    email: new FormControl(null, Validators.required),
    password: new FormControl(null, Validators.required),
  });

  constructor(
    private router: Router,
    private messageService: MessageService,
    private authService: AuthService,
  ) { }

  signIn() {
    let values = this.formData.value;
    this.router.navigate(['/appointment']);
    // this.authService.signin(values).subscribe({
    //   next: (res) => {
    //     localStorage.setItem('user', JSON.stringify(res));
    //     this.router.navigate(['/appointment']);
    //   },
    //   error: (err) => {
    //     this.messageService.add({
    //       severity: 'error',
    //       summary: 'เกิดข้อผิดพลาด',
    //       detail: err.error.message
    //     });
    //   }
    // });
  }

  signUp() {
    this.router.navigate(['/signup']);
  }

}
