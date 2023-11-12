import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { PrimeNGModule } from 'src/app/modules/primeng.module';
import { ThaiModule } from 'src/app/modules/thai.module';
import { RewardComponent } from './reward.component';
import { PageTitleComponent } from 'src/app/component/page-title/page-title.component';

const routes: Routes = [
  {
    path: '',
    component: RewardComponent,
  },
];

@NgModule({
  declarations: [
    RewardComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    PrimeNGModule,
    ThaiModule,
    PageTitleComponent
  ]
})
export class RewardModule { }
