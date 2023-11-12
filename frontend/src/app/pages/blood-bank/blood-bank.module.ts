import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { PrimeNGModule } from 'src/app/modules/primeng.module';
import { ThaiModule } from 'src/app/modules/thai.module';
import { BloodBankComponent } from './blood-bank.component';
import { PageTitleComponent } from 'src/app/component/page-title/page-title.component';
import { BloodBankDetailComponent } from './blood-bank-detail/blood-bank-detail.component';
import { BloodBankListComponent } from './blood-bank-list/blood-bank-list.component';
import { SearchbarComponent } from 'src/app/component/searchbar/searchbar.component';

const routes: Routes = [
  {
    path: '',
    component: BloodBankComponent,
  },
  {
    path: ':id',
    component: BloodBankDetailComponent,
  },
];

@NgModule({
  declarations: [
    BloodBankComponent,
    BloodBankDetailComponent,
    BloodBankListComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    PrimeNGModule,
    ThaiModule,
    PageTitleComponent,
    SearchbarComponent
  ]
})
export class BloodBankModule { }
