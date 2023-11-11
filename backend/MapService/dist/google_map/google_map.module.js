"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.GoogleMapModule = void 0;
const common_1 = require("@nestjs/common");
const google_map_service_1 = require("./google_map.service");
const google_map_controller_1 = require("./google_map.controller");
const prisma_service_1 = require("../prisma/prisma.service");
let GoogleMapModule = class GoogleMapModule {
};
exports.GoogleMapModule = GoogleMapModule;
exports.GoogleMapModule = GoogleMapModule = __decorate([
    (0, common_1.Module)({
        controllers: [google_map_controller_1.GoogleMapController],
        providers: [google_map_service_1.GoogleMapService, prisma_service_1.PrismaService],
    })
], GoogleMapModule);
//# sourceMappingURL=google_map.module.js.map