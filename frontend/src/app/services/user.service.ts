import { Injectable } from '@angular/core';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class UserService extends BaseService {
  public override path: string = 'user-service';

  getUser() {
    return this.http.get(this.getBaseUrl + '/users');
  }
}

