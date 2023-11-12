"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.AppModule = void 0;
const common_1 = require("@nestjs/common");
const core_1 = require("@nestjs/core");
const prisma_module_1 = require("./prisma/prisma.module");
const nestjs_eureka_1 = require("nestjs-eureka");
const prisma_service_1 = require("./prisma/prisma.service");
const app_controller_1 = require("./app.controller");
const app_service_1 = require("./app.service");
let AppModule = class AppModule {
};
exports.AppModule = AppModule;
exports.AppModule = AppModule = __decorate([
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
            prisma_module_1.PrismaModule,
        ],
        controllers: [app_controller_1.GoogleMapController],
        providers: [
            {
                provide: core_1.APP_PIPE,
                useClass: common_1.ValidationPipe,
            },
            prisma_service_1.PrismaService,
            app_service_1.GoogleMapService,
        ],
    })
], AppModule);
//# sourceMappingURL=app.module.js.map