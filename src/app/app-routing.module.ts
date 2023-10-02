import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppLayoutComponent } from './layout/layout.component';

const routes: Routes = [
  {
    path: '', component: AppLayoutComponent,
    children: [
      { path: '', redirectTo: 'appointment', pathMatch: 'full' },
      {
        path: 'appointment',
        loadChildren: () => import('./pages/appointment/appointment.module').then(m => m.AppointmentModule)
      },
      {
        path: 'nearby',
        loadChildren: () => import('./pages/nearby/nearby.module').then(m => m.NearbyModule)
      },
      {
        path: 'blood-bank',
        loadChildren: () => import('./pages/blood-bank/blood-bank.module').then(m => m.BloodBankModule)
      },
      {
        path: 'reward',
        loadChildren: () => import('./pages/reward/reward.module').then(m => m.RewardModule)
      },
      {
        path: 'news',
        loadChildren: () => import('./pages/news/news.module').then(m => m.NewsModule)
      },
      {
        path: 'profile',
        loadChildren: () => import('./pages/profile/profile.module').then(m => m.ProfileModule)
      },
      {
        path: 'history',
        loadChildren: () => import('./pages/history/history.module').then(m => m.HistoryModule)
      },
      {
        path: 'notification',
        loadChildren: () => import('./pages/notification/notification.module').then(m => m.NotificationModule)
      },
      // {
      //   path: 'not-found',
      //   // loadChildren: () => import('./pages/news/news.module').then(m => m.NewsModule)
      // },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
