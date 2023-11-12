import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { AuthService } from 'src/app/services/auth.service';
import { environment } from '../../environment/environment';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  listGender: any[] = [
    { id: 1, name: 'ชาย' },
    { id: 2, name: 'หญิง' },
    { id: 3, name: 'อื่นๆ' },
  ];

  listBloodGroup: any[] = [
    { id: 1, name: 'A (เอ)' },
    { id: 2, name: 'B (บี)' },
    { id: 3, name: 'AB (เอบี)' },
    { id: 4, name: 'O (โอ)' },
  ];


  formData: FormGroup = new FormGroup({
    firstname: new FormControl(null, Validators.required),
    lastname: new FormControl(null, Validators.required),
    email: new FormControl(null, Validators.required),
    password: new FormControl(null, Validators.required),
    phoneNumber: new FormControl(null, Validators.required),
    bloodGroup: new FormControl(null, Validators.required),
    gender: new FormControl(null, Validators.required),
    dateOfBirth: new FormControl(new Date(), Validators.required),
    weight: new FormControl(null, Validators.required),
    height: new FormControl(null, Validators.required),
    congenitalDisease: new FormControl(null, Validators.required),
    role: new FormControl('USER', Validators.required),
  });

  constructor(
    private router: Router,
    private messageService: MessageService,
    private authService: AuthService,
  ) { }

  ngOnInit(): void {
    if (!environment.production) {
      this.formData.patchValue({
        firstname: "ณัฐพล",
        lastname: "ดิษฐวิบูลย์",
        email: "Bug9Best@gmail.com",
        password: "Best1539.",
        phoneNumber: "0934422123",
        weight: 85.6,
        height: 186,
        congenitalDisease: "ไม่มี",

      });
    }
  }

  submit() {
    let values = this.formData.value;
    this.authService.createUser(values).subscribe(
      {
        next: (res) => {
          this.messageService.add({
            severity: 'success',
            summary: 'สำเร็จ!',
            detail: 'สมัครสมาชิกสำเร็จ'
          });
        },
      }
    );
  }

  signIn() {
    this.router.navigate(['/signin']);
  }

}
