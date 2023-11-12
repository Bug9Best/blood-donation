import { ApiProperty } from "@nestjs/swagger";
import { IsNumber, IsString } from "class-validator";

export class CreateLocation {
    @ApiProperty()
    @IsString()
    name:string;

    @ApiProperty()
    @IsString()
    description:string;

    @ApiProperty()
    @IsNumber()
    longitude:number;
    
    @ApiProperty()
    @IsNumber()
    latitude:number;

    @ApiProperty()
    @IsString()
    contact_phone:string;
}