import { Injectable } from '@angular/core';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService extends BaseService {
  public override path: string = 'auth-service';

  createUser(data: any) {
    return this.http.post("http://localhost:8082/auth-service/addUser", data);
  }

  signin(data: any) {
    return this.http.post("http://localhost:8082/auth-service/validatelogin", data);
  }

}
