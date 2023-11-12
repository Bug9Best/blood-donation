import { Injectable } from '@angular/core';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class BloodBankService extends BaseService {
  public override path: string = 'bloodbank-service';

  getBloodBank() {
    return this.http.get(this.getBaseUrl + '/bloodbanks');
  }
}
