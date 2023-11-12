import { GoogleMapService } from './google_map.service';
import { CreateLocation } from '../dto/create-location.dto';
export declare class GoogleMapController {
    private readonly googleMapService;
    constructor(googleMapService: GoogleMapService);
    createLocation(data: CreateLocation): Promise<any>;
    getLocation(name: string): Promise<any>;
    deleteLocation(locationId: string): Promise<any>;
}
