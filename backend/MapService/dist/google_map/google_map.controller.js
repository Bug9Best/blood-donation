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
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.GoogleMapController = void 0;
const common_1 = require("@nestjs/common");
const google_map_service_1 = require("./google_map.service");
const swagger_1 = require("@nestjs/swagger");
const create_location_dto_1 = require("../dto/create-location.dto");
let GoogleMapController = class GoogleMapController {
    constructor(googleMapService) {
        this.googleMapService = googleMapService;
    }
    async createLocation(data) {
        return await this.googleMapService.createLocation(data);
    }
    async getLocation(name) {
        return await this.googleMapService.getLocation(name);
    }
    async deleteLocation(locationId) {
        return await this.googleMapService.deleteLocation(locationId);
    }
};
exports.GoogleMapController = GoogleMapController;
__decorate([
    (0, common_1.Post)(""),
    __param(0, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [create_location_dto_1.CreateLocation]),
    __metadata("design:returntype", Promise)
], GoogleMapController.prototype, "createLocation", null);
__decorate([
    (0, common_1.Get)(":name"),
    __param(0, (0, common_1.Param)('name')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String]),
    __metadata("design:returntype", Promise)
], GoogleMapController.prototype, "getLocation", null);
__decorate([
    (0, common_1.Delete)(":locationId"),
    __param(0, (0, common_1.Param)("locationId")),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String]),
    __metadata("design:returntype", Promise)
], GoogleMapController.prototype, "deleteLocation", null);
exports.GoogleMapController = GoogleMapController = __decorate([
    (0, swagger_1.ApiTags)('google-map'),
    (0, common_1.Controller)('google-map'),
    __metadata("design:paramtypes", [google_map_service_1.GoogleMapService])
], GoogleMapController);
//# sourceMappingURL=google_map.controller.js.map