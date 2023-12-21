import { User } from "./user.model";

export class Response {
    responseType !: string;
    responseMessage !: string;
    result !: Array<User>;
}