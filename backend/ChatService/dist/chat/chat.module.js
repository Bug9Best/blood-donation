"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.ChatModule = void 0;
const common_1 = require("@nestjs/common");
const chat_service_1 = require("./chat.service");
const chat_controller_1 = require("./chat.controller");
const prisma_service_1 = require("../common/services/prisma.service");
const chat_gateway_1 = require("./chat.gateway");
const socket_io_1 = require("socket.io");
const nestjs_eureka_1 = require("nestjs-eureka");
let ChatModule = class ChatModule {
};
exports.ChatModule = ChatModule;
exports.ChatModule = ChatModule = __decorate([
    (0, common_1.Module)({
        imports: [
            nestjs_eureka_1.EurekaModule.forRoot({
                eureka: {
                    host: process.env.EUREKA_HOST,
                    port: process.env.EUREKA_PORT,
                    servicePath: process.env.EUREKA_PATH,
                    registryFetchInterval: 10000,
                    maxRetries: 10,
                },
                service: {
                    name: process.env.SERVICE_NAME,
                    port: Number(process.env.SERVICE_PORT),
                },
            }),
        ],
        controllers: [chat_controller_1.ChatController],
        providers: [chat_service_1.ChatService, prisma_service_1.PrismaService, chat_gateway_1.ChatGateway, socket_io_1.Server],
    })
], ChatModule);
//# sourceMappingURL=chat.module.js.map