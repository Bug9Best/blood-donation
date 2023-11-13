import { Injectable } from '@angular/core';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class ChatService extends BaseService {
  public override path: string = 'chat-service';

  getMessage(id: string) {
    return this.http.get("http://localhost:3001/chat/65514ea003ba6a6addc4ba6c");
  }

  sendMessage(data: any) {
    return this.http.post("http://localhost:3001/chat/send", data);
  }

}
