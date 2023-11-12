import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ThaiModule } from 'src/app/modules/thai.module';
import { ProfileComponent } from './profile.component';
import { PrimeNGModule } from 'src/app/modules/primeng.module';
import { PageTitleComponent } from 'src/app/component/page-title/page-title.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [
  {
    path: '',
    component: ProfileComponent,
  },
];

@NgModule({
  declarations: [
    ProfileComponent
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
export class ProfileModule { }
