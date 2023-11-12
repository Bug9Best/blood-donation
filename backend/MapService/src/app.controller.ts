import { Body, Controller, Delete, Get, Param, Post } from '@nestjs/common';
import { ApiTags } from '@nestjs/swagger';
import { CreateLocation } from './dto/create-location.dto';
import { GoogleMapService } from './app.service';

@ApiTags('google')
@Controller('')
export class GoogleMapController {
  constructor(private readonly googleMapService: GoogleMapService) {}

  @Get()
  checkHealth(): string {
    return 'OK';
  }

  @Post('')
  async createLocation(@Body() data: CreateLocation): Promise<any> {
    return await this.googleMapService.createLocation(data);
  }

  @Get(':name')
  async getLocation(@Param('name') name: string): Promise<any> {
    return await this.googleMapService.getLocation(name);
  }

  @Delete(':locationId')
  async deleteLocation(@Param('locationId') locationId: string): Promise<any> {
    return await this.googleMapService.deleteLocation(locationId);
  }
}
