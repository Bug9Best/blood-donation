import { ChatService } from './chat.service';
export declare class ChatGateway {
    private readonly chatService;
    constructor(chatService: ChatService);
    private readonly server;
    onMessage(userId: string): Promise<void>;
}
