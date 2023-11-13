"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.ChatService = void 0;
const common_1 = require("@nestjs/common");
const prisma_service_1 = require("../common/services/prisma.service");
const socket_io_1 = require("socket.io");
const websockets_1 = require("@nestjs/websockets");
let ChatService = class ChatService {
    constructor(prismaService) {
        this.prismaService = prismaService;
    }
    async getMessage(userId) {
        const con = await this.prismaService.conversations.findMany({
            where: {
                OR: [{ userId1: userId }, { userId2: userId }],
            },
            orderBy: {
                createdAt: 'asc',
            },
        });
        if (con.length === 0) {
            return {
                message: 'No conversation',
            };
        }
        const message = await Promise.all(con.map(async (item) => {
            const message = await this.prismaService.message.findMany({
                where: {
                    OR: [{ senderId: userId }, { receiverId: userId }],
                },
                select: {
                    content: true,
                    senderId: true,
                    receiverId: true,
                    createdAt: true,
                },
                orderBy: {
                    createdAt: 'asc',
                },
            });
            return {
                conversationId: item.id,
                message,
            };
        }));
        if (message.length === 0)
            return {
                message: 'No message',
            };
        return message;
    }
    async createMessage(conDto) {
        let newCon;
        const checkCon = await this.prismaService.conversations.findFirst({
            where: {
                OR: [
                    { userId1: conDto.receiverId, userId2: conDto.senderId },
                    { userId1: conDto.senderId, userId2: conDto.receiverId },
                ],
            },
        });
        if (!checkCon) {
            newCon = await this.prismaService.conversations.create({
                data: {
                    userId1: conDto.receiverId,
                    userId2: conDto.senderId,
                },
            });
        }
        const newMessage = await this.prismaService.message.create({
            data: {
                content: conDto.content,
                conversationId: checkCon ? checkCon.id : newCon.id,
                receiverId: conDto.receiverId,
                senderId: conDto.senderId,
            },
        });
        this.server.emit('onMessage', {
            message: 'Create message successfully',
            newMessage,
        });
        return {
            message: 'Create message successfully',
            newMessage,
        };
    }
};
exports.ChatService = ChatService;
__decorate([
    (0, websockets_1.WebSocketServer)(),
    __metadata("design:type", socket_io_1.Server)
], ChatService.prototype, "server", void 0);
exports.ChatService = ChatService = __decorate([
    (0, common_1.Injectable)(),
    (0, websockets_1.WebSocketGateway)(),
    __metadata("design:paramtypes", [prisma_service_1.PrismaService])
], ChatService);
//# sourceMappingURL=chat.service.js.map