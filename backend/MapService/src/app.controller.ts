import { Body, Controller, Delete, Get, Param, Post } from '@nestjs/common';
import { ApiTags } from '@nestjs/swagger';
import { CreateLocation } from './dto/create-location.dto';
import { GoogleMapService } from './app.service';

@ApiTags('google')
@Controller('')
export class GoogleMapController {
  constructor(private readonly googleMapService: GoogleMapService) {}

  @Get('')
  async getLocations(): Promise<any> {
    return await this.googleMapService.getLocations();
  }

  @Post('')
  async createLocation(@Body() data: CreateLocation): Promise<any> {
    return await this.googleMapService.createLocation(data);
  }

  @Get(':locationId')
  async getLocation(@Param('locationId') locationId: string): Promise<any> {
    return await this.googleMapService.getLocation(locationId);
  }

  @Delete(':locationId')
  async deleteLocation(@Param('locationId') locationId: string): Promise<any> {
    return await this.googleMapService.deleteLocation(locationId);
  }
}
