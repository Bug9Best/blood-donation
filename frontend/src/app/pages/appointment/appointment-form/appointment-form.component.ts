import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { AppointmentService } from 'src/app/services/appointment.service';
import { LocationService } from 'src/app/services/location.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'appointment-form',
  templateUrl: './appointment-form.component.html',
  styleUrls: ['./appointment-form.component.scss']
})
export class AppointmentFormComponent implements OnInit {
  currentUserId: string = JSON.parse(localStorage.getItem('user') || '{}');
  selectedTime?: number;
  listLocation: any[] = [];

  listTime: any[] = [
    { id: 1, time: '09:00' },
    { id: 2, time: '09:30' },
    { id: 3, time: '10:00' },
    { id: 4, time: '10:30' },
    { id: 5, time: '11:00' },
    { id: 6, time: '11:30' },
    { id: 7, time: '13:00' },
    { id: 8, time: '13:30' },
    { id: 9, time: '14:00' },
    { id: 10, time: '14:30' },
    { id: 11, time: '15:00' },
    { id: 12, time: '15:30' },
  ]

  formData: FormGroup = new FormGroup({
    userid: new FormControl(''),
    firstname: new FormControl('', Validators.required),
    lastname: new FormControl('', Validators.required),
    bloodGroup: new FormControl('', Validators.required),
    location: new FormControl('', Validators.required),
    date: new FormControl(new Date(), Validators.required),
    appointment: new FormControl('', Validators.required),
  });

  constructor(
    private messageService: MessageService,
    private userService: UserService,
    private appointmentService: AppointmentService,
    private locationService: LocationService,
  ) { }

  ngOnInit(): void {
    if (this.currentUserId) {
      this.getUser();
      this.getLocations();
    }
  }

  getUser() {
    this.userService.getUser().subscribe((res: any) => {
      let user = res.find((item: any) => item._id == this.currentUserId);
      if (user) {
        this.formData.patchValue({
          firstname: user.firstname,
          lastname: user.lastname,
          bloodGroup: user.bloodGroup,
        })
      }
    });
  }

  getLocations() {
    this.locationService.getAll().subscribe((res: any) => {
      console.log(res);
      this.listLocation = res;
    });
  }

  onSelectedTime(time: any) {
    this.selectedTime = time.id
    this.formData.patchValue({ appointment: time.time })
  }

  @Output() onSave: EventEmitter<any> = new EventEmitter<any>();
  @Output() onCancel: EventEmitter<any> = new EventEmitter<any>();
  save() {
    this.messageService.add({
      key: 'app',
      severity: 'success',
      summary: 'สำเร็จ',
      detail: 'บันทึกข้อมูลสำเร็จ'
    });
    this.onSave.emit();
    // let values = this.formData.value;
    // values.userid = this.currentUserId;
    // this.appointmentService.createAppointment(values).subscribe({
    //   next: (res: any) => {
    //     this.messageService.add({
    //       key: 'app',
    //       severity: 'success',
    //       summary: 'สำเร็จ',
    //       detail: 'บันทึกข้อมูลสำเร็จ'
    //     });
    //     this.onSave.emit();
    //   },
    //   error: (err: any) => {
    //     this.messageService.add({
    //       key: 'app',
    //       severity: 'error',
    //       summary: 'Error',
    //       detail: err.message
    //     });
    //   },

    // });
  }

  cancel() {
    this.onCancel.emit();
  }
}
