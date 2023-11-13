import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PrimeNGModule } from 'src/app/modules/primeng.module';
import { ChatService } from 'src/app/services/chat.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    PrimeNGModule,
  ]

})
export class ChatComponent implements OnInit {

  currentUser = JSON.parse(localStorage.getItem('user') || '{}');
  content: string = '';
  listMessage: any = [];

  constructor(
    private chatService: ChatService
  ) { }

  ngOnInit() {
    this.getMessage();
  }

  getMessage() {
    this.chatService.getMessage(this.currentUser).subscribe(res => {
      this.listMessage = res;
    });
  }

  sendMessage() {
    let values = {
      senderId: this.currentUser,
      receiverId: "65514d7202516d0e127ef83c",
      content: this.content
    };
    this.chatService.sendMessage(values).subscribe({
      next: (res) => {
        this.getMessage();
        this.content = '';
      }
    });
  }
}
