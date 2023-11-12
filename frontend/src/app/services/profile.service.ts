import { Injectable } from '@angular/core';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class ProfileService extends BaseService {
  public override path: string = 'api-profile';
}

