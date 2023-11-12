import {
  WebSocketGateway,
  SubscribeMessage,
  MessageBody,
  WebSocketServer,
} from '@nestjs/websockets';
import { ChatService } from './chat.service';
import { Server } from 'socket.io';

@WebSocketGateway()
export class ChatGateway {
  constructor(private readonly chatService: ChatService) {}

  @WebSocketServer()
  private readonly server: Server;

  @SubscribeMessage('message')
  async onMessage(@MessageBody() userId: string) {
    const message = await this.chatService.getMessage(userId);

    this.server.emit('onMessage', message);
  }
}
