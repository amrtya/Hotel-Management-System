import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient } from "@angular/common/http";
import { Response } from '../models/response.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

    constructor(private http: HttpClient) { }

    private baseURL = "http://localhost:8081/admin";

    getAllUsers(): Observable<Response>{
        return this.http.get<Response>(this.baseURL + "/getUsers")
    }

    updateUser(id: String, user: User):Observable<Response> {
        console.log(user);
        return this.http.post<Response>(this.baseURL + `/updateUser?id=${id}`, user)
    }

    deleteUser(id: String): Observable<Response>{
        return this.http.get<Response>(this.baseURL + `/deleteUser?id=${id}`)
    }
}
