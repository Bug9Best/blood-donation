import {
  HttpCode,
  HttpException,
  HttpStatus,
  Injectable,
} from '@nestjs/common';
import { PrismaService } from 'src/prisma/prisma.service';

@Injectable()
export class GoogleMapService {
  //import service
  constructor(private readonly prisma: PrismaService) { }

  async getLocations(): Promise<any> {
    return await this.prisma.location.findMany();
  }

  async createLocation(data: any): Promise<any> {
    const isExit = await this.prisma.location.findUnique({
      where: {
        name: data.name,
      },
    });
    if (isExit) {
      throw new HttpException('Location is exit', HttpStatus.BAD_REQUEST);
    }
    return await this.prisma.location.create({
      data,
    });
  }

  async getLocation(name: string): Promise<any> {
    return await this.prisma.location.findUnique({
      where: {
        name,
      },
    });
  }

  async deleteLocation(locationId: string): Promise<any> {
    return await this.prisma.location.delete({
      where: {
        id: locationId,
      },
    });
  }
}
