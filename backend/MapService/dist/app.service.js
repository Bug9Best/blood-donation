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
exports.GoogleMapService = void 0;
const common_1 = require("@nestjs/common");
const prisma_service_1 = require("./prisma/prisma.service");
let GoogleMapService = class GoogleMapService {
    constructor(prisma) {
        this.prisma = prisma;
    }
    async getLocations() {
        return await this.prisma.location.findMany();
    }
    async createLocation(data) {
        const isExit = await this.prisma.location.findUnique({
            where: {
                name: data.name,
            },
        });
        if (isExit) {
            throw new common_1.HttpException('Location is exit', common_1.HttpStatus.BAD_REQUEST);
        }
        return await this.prisma.location.create({
            data,
        });
    }
    async getLocation(name) {
        return await this.prisma.location.findUnique({
            where: {
                name,
            },
        });
    }
    async deleteLocation(locationId) {
        return await this.prisma.location.delete({
            where: {
                id: locationId,
            },
        });
    }
};
exports.GoogleMapService = GoogleMapService;
exports.GoogleMapService = GoogleMapService = __decorate([
    (0, common_1.Injectable)(),
    __metadata("design:paramtypes", [prisma_service_1.PrismaService])
], GoogleMapService);
//# sourceMappingURL=app.service.js.map