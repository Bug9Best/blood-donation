import { PrismaService } from 'src/prisma/prisma.service';
export declare class GoogleMapService {
    private readonly prisma;
    constructor(prisma: PrismaService);
    getLocations(): Promise<any>;
    createLocation(data: any): Promise<any>;
    getLocation(name: string): Promise<any>;
    deleteLocation(locationId: string): Promise<any>;
}
