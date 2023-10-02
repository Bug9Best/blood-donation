import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConfirmationService, MessageService } from 'primeng/api';
import { PrimeNGModule } from './modules/primeng.module';
import { AppLayoutModule } from './layout/layout.module';
import { RewardComponent } from './pages/reward/reward.component';
import { AppointmentComponent } from './pages/appointment/appointment.component';
import { NearbyComponent } from './pages/nearby/nearby.component';
import { BloodBankComponent } from './pages/blood-bank/blood-bank.component';
import { NewsComponent } from './pages/news/news.component';
import { HistoryComponent } from './pages/history/history.component';
import { ProfileComponent } from './pages/profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    RewardComponent,
    AppointmentComponent,
    NearbyComponent,
    BloodBankComponent,
    NewsComponent,
    HistoryComponent,
    ProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    PrimeNGModule,
    AppLayoutModule,
  ],
  providers: [
    MessageService,
    ConfirmationService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
