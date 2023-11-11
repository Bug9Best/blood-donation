import { Module } from '@nestjs/common';
import { ChatService } from './chat.service';
import { ChatController } from './chat.controller';
import { PrismaService } from 'src/common/services/prisma.service';
import { ChatGateway } from './chat.gateway';
import { Server } from 'socket.io';
import { EurekaModule } from 'nestjs-eureka';

@Module({
  imports: [
    EurekaModule.forRoot({
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
  controllers: [ChatController],
  providers: [ChatService, PrismaService, ChatGateway, Server],
})
export class ChatModule {}
