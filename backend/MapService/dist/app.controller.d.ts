import { CreateLocation } from './dto/create-location.dto';
import { GoogleMapService } from './app.service';
export declare class GoogleMapController {
    private readonly googleMapService;
    constructor(googleMapService: GoogleMapService);
    getLocations(): Promise<any>;
    createLocation(data: CreateLocation): Promise<any>;
    getLocation(name: string): Promise<any>;
    deleteLocation(locationId: string): Promise<any>;
}
