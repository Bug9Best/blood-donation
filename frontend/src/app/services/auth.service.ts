import { Injectable } from '@angular/core';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService extends BaseService {
  public override path: string = 'auth-service';

  createUser(data: any) {
    return this.http.post("http://localhost:3004/auths/create-user", data);
  }

  signin(data: any) {
    return this.http.post("http://localhost:3004/auths/sign-in", data);
  }

}
