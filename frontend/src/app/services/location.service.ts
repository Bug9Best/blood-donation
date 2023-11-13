import { Injectable } from '@angular/core';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class LocationService extends BaseService {
  public override path: string = 'api-location';

  getLocation() {
    return this.http.get(this.getBaseUrl + ":3000");
  }
}
