import { Injectable } from '@angular/core';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class ChatService extends BaseService {
  public override path: string = 'chat-service';

  getMessage(id: string) {
    return this.http.get(this.getBaseUrl + ":3001/chat/" + id);
  }

  sendMessage(data: any) {
    return this.http.post(this.getBaseUrl + ":3001/chat/send", data);
  }

}
