import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {
  editMode: boolean = false;

  formData: FormGroup = new FormGroup({
    firstName: new FormControl(null, Validators.required),
    lastName: new FormControl(null, Validators.required),
    email: new FormControl(null, [Validators.required, Validators.email]),
    phoneNumber: new FormControl(null, Validators.required),
    bloodGroup: new FormControl(null, Validators.required),
    gender: new FormControl(null, Validators.required),
    dateofbirth: new FormControl(null, Validators.required),
    weight: new FormControl(null, Validators.required),
    height: new FormControl(null, Validators.required),
    congenitalDisease: new FormControl(null, Validators.required),
    // userimage: new FormGroup(null, Validators.required),
  });

  editProfile() {
    this.editMode = !this.editMode;
  }

}
