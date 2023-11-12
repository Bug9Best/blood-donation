import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { PrimeNGModule } from 'src/app/modules/primeng.module';
import { ThaiModule } from 'src/app/modules/thai.module';
import { AppointmentComponent } from './appointment.component';
import { PageTitleComponent } from 'src/app/component/page-title/page-title.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppointmentFormComponent } from './appointment-form/appointment-form.component';
import { AppointmentQuestionComponent } from './appointment-question/appointment-question.component';

const routes: Routes = [
  {
    path: '',
    component: AppointmentComponent,
  },
];

@NgModule({
  declarations: [
    AppointmentComponent,
    AppointmentFormComponent,
    AppointmentQuestionComponent,
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule,
    ReactiveFormsModule,
    PrimeNGModule,
    ThaiModule,
    PageTitleComponent
  ]
})
export class AppointmentModule { }
