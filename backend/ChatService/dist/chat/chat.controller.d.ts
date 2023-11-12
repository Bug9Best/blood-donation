import { CreateChatDto } from './dto/create-chat.dto';
import { ChatService } from './chat.service';
export declare class ChatController {
    private readonly chatService;
    constructor(chatService: ChatService);
    getMessage(userId: string): Promise<{
        conversationId: string;
        message: {
            senderId: string;
            receiverId: string;
            content: string;
            createdAt: Date;
        }[];
    }[] | {
        message: string;
    }>;
    createMessage(createDto: CreateChatDto): Promise<{
        message: string;
        newMessage: {
            id: string;
            content: string;
            receiverId: string;
            senderId: string;
            conversationId: string;
            createdAt: Date;
            updatedAt: Date;
        };
    }>;
}
