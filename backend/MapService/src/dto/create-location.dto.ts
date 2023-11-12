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
    longtitude:number;
    
    @ApiProperty()
    @IsNumber()
    latitude:number;
}