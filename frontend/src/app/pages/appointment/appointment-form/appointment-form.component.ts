import { Component, EventEmitter, Output } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'appointment-form',
  templateUrl: './appointment-form.component.html',
  styleUrls: ['./appointment-form.component.scss']
})
export class AppointmentFormComponent {

  selectedTime?: number;

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
    first_name: new FormControl('', Validators.required),
    last_name: new FormControl('', Validators.required),
    citizen_id: new FormControl('', Validators.required),
    date: new FormControl(new Date(), Validators.required),
    time: new FormControl('', Validators.required),
  });

  onSelectedTime(time: any) {
    this.selectedTime = time.id
    this.formData.patchValue({ time: time.time })
  }

  @Output() onSave: EventEmitter<any> = new EventEmitter<any>();
  @Output() onCancel: EventEmitter<any> = new EventEmitter<any>();
  save() {
    let values = this.formData.value;
    values.time = this.selectedTime;
    this.onSave.emit(values);
  }

  cancel() {
    this.onCancel.emit();
  }
}
