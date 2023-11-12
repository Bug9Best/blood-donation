import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from 'express';
import { MenuItem } from 'primeng/api';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-blood-bank-detail',
  templateUrl: './blood-bank-detail.component.html',
  styleUrls: ['./blood-bank-detail.component.scss']
})
export class BloodBankDetailComponent {
  locationId: string = '';

  items: MenuItem[] = [
    { label: 'ธนาคารเลิอด', routerLink: '/blood-bank' },
    { label: 'รายละเอียด' }
  ];


  constructor(
    private activatedRoute: ActivatedRoute,
  ) {
    this.activatedRoute.paramMap.subscribe(params => {
      if (params.get('id')) {
        console.log(params.get('id'));
        this.locationId = params.get('id')!;
      }
    })
  }


}
