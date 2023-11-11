import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { PrimeNGModule } from 'src/app/modules/primeng.module';
import { ThaiModule } from 'src/app/modules/thai.module';
import { NearbyComponent } from './nearby.component';
import { PageTitleComponent } from 'src/app/component/page-title/page-title.component';
import { SearchbarComponent } from 'src/app/component/searchbar/searchbar.component';
import { GoogleMapsModule, } from '@angular/google-maps';


const routes: Routes = [
  {
    path: '',
    component: NearbyComponent,
  },
];

@NgModule({
  declarations: [
    NearbyComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    PrimeNGModule,
    ThaiModule,
    PageTitleComponent,
    SearchbarComponent,
    GoogleMapsModule
  ]
})
export class NearbyModule { }
