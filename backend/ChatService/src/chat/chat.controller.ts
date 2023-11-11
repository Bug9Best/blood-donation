import { Body, Controller, Get, Param, Post } from '@nestjs/common';
import { CreateChatDto } from './dto/create-chat.dto';
import { ChatService } from './chat.service';

@Controller('chat')
export class ChatController {
  constructor(private readonly chatService: ChatService) {}

  @Get(':userId')
  async getMessage(@Param('userId') userId: string) {
    return this.chatService.getMessage(userId);
  }

  @Post()
  async createMessage(@Body() createDto: CreateChatDto) {
    return this.chatService.createMessage(createDto);
  }
}
