import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient } from "@angular/common/http";
import { Response } from '../models/response.model';
import { ToastrService } from 'ngx-toastr';
import { loginModel } from '../models/login.model';
import { error } from 'console';
import { Observable, catchError, retry, switchMap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

    constructor(private http: HttpClient, private toastr: ToastrService) { }

    private baseURL = "http://localhost:8081";
    public responseData!: Response;

    getAllUsers(): Observable<Response>{
        return this.http.get<Response>(this.baseURL + "/admin/getUsers")
    }
}
