import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient, HttpHeaders } from "@angular/common/http";
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

    updateUser(user: User) {
        this.http.post(this.baseURL + "/admin/updateUser/" + user.custId, user).subscribe({
            error: (err) => this.toastr.error("An Error Occured")
        })
    }

    deleteUser(id: String) {
        this.http.get(this.baseURL + `/admin/deleteUser?id=${id}`).subscribe({
            next: response => {
                this.responseData = response as Response
                if(this.responseData.responseType == "FAILURE")
                    this.toastr.error(this.responseData.responseMessage);
                else 
                    this.toastr.success(this.responseData.responseMessage);
            },
            error: err => this.toastr.error("An Error Occured")
        })
    }
}
