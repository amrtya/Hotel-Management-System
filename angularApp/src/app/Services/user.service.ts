import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient } from "@angular/common/http";
import { Response } from '../models/response.model';
import { ToastrService } from 'ngx-toastr';
import { loginModel } from '../models/login.model';
import { error } from 'console';

@Injectable({
  providedIn: 'root'
})
export class UserService {

    constructor(private http: HttpClient, private toastr: ToastrService) { }

    private baseURL = "http://localhost:8081";
    public responseData!: Response;

    pushSignupData(newUser: User) {
        this.http.post(this.baseURL + "/signup", newUser).subscribe(
            (response) => {
                this.responseData = response as Response; 
                if(this.responseData.responseType == "FAILURE")
                  this.toastr.error(this.responseData.responseMessage);
                else 
                  this.toastr.success(this.responseData.responseMessage);
            }, 
            (error) => {
              this.toastr.error("An Error Occured");
            }
        );
    }

    loginRequest(login : loginModel) {
        this.http.post(this.baseURL + "/login", login).subscribe(
            (response) => {
              this.responseData = response as Response; 
              console.log(this.responseData);
              if(this.responseData.responseType == "FAILURE")
                this.toastr.error(this.responseData.responseMessage);
              else 
                this.toastr.success(this.responseData.responseMessage);
            },  
            (error) => {
              this.toastr.error("An Error Occured");
            }
        );
    }
    
}
