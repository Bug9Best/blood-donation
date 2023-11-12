import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from 'express';
import { MenuItem } from 'primeng/api';
import { BloodBankService } from 'src/app/services/blood-bank.service';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-blood-bank-detail',
  templateUrl: './blood-bank-detail.component.html',
  styleUrls: ['./blood-bank-detail.component.scss']
})
export class BloodBankDetailComponent implements OnInit {
  locationId: string = '';
  selectedLocation: any = {};
  listBloodBank: any = []
  percentA: number = 0;
  percentB: number = 0;
  percentAB: number = 0;
  percentO: number = 0;


  items: MenuItem[] = [
    { label: 'ธนาคารเลิอด', routerLink: '/blood-bank' },
    { label: 'รายละเอียด' }
  ];


  constructor(
    private bloodBankService: BloodBankService,
    private activatedRoute: ActivatedRoute,
  ) {
    this.activatedRoute.paramMap.subscribe(params => {
      if (params.get('id')) {
        console.log(params.get('id'));
        this.locationId = params.get('id')!;
      }
    })
  }

  ngOnInit(): void {
    this.getHospital()
  }

  calculationBlood(blood: any) {
    this.percentA = Math.round((blood.blood_already_a / blood.blood_required_a) * 100) > 100 ? 100 : Math.round((blood.blood_already_a / blood.blood_required_a) * 100)
    this.percentB = Math.round((blood.blood_already_b / blood.blood_required_b) * 100) > 100 ? 100 : Math.round((blood.blood_already_b / blood.blood_required_b) * 100)
    this.percentAB = Math.round((blood.blood_already_ab / blood.blood_required_ab) * 100) > 100 ? 100 : Math.round((blood.blood_already_ab / blood.blood_required_ab) * 100)
    this.percentO = Math.round((blood.blood_already_o / blood.blood_required_o) * 100) > 100 ? 100 : Math.round((blood.blood_already_o / blood.blood_required_o) * 100)
  }

  getHospital() {
    this.bloodBankService.getBloodBank().subscribe(res => {
      this.listBloodBank = res
      this.listBloodBank.forEach((element: any) => {
        if (element._id == this.locationId) {
          this.selectedLocation = element
          this.calculationBlood(this.selectedLocation)
        }
      });
    })
  }
}
