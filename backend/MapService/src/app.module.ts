import { Module, ValidationPipe } from '@nestjs/common';
import { APP_PIPE } from '@nestjs/core';
import { PrismaModule } from './prisma/prisma.module';
import { EurekaModule } from 'nestjs-eureka';
import { PrismaService } from './prisma/prisma.service';
import { GoogleMapController } from './app.controller';
import { GoogleMapService } from './app.service';

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
    PrismaModule,
  ],
  controllers: [GoogleMapController],
  providers: [
    {
      provide: APP_PIPE,
      useClass: ValidationPipe,
    },
    PrismaService,
    GoogleMapService,
  ],
})
export class AppModule {}
