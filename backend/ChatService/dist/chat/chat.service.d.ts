import { PrismaService } from 'src/common/services/prisma.service';
import { CreateChatDto } from './dto/create-chat.dto';
export declare class ChatService {
    private readonly prismaService;
    constructor(prismaService: PrismaService);
    private readonly server;
    getMessage(userId?: string): Promise<{
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
    createMessage(conDto: CreateChatDto): Promise<{
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
