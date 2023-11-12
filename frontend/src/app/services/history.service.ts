import { Injectable } from '@angular/core';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class HistoryService extends BaseService{
  public override path: string = 'api-history';

}
