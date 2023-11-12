import { IsString } from 'class-validator';
import { IsObjectId } from 'class-validator-mongo-object-id';

export class CreateChatDto {
  @IsObjectId()
  senderId: string;
  @IsObjectId()
  receiverId: string;
  @IsString()
  content: string;
}
