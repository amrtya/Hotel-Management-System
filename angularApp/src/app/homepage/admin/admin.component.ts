import { Component, OnInit, ViewChild } from '@angular/core';
import {MatTable} from '@angular/material/table';
import { User } from 'src/app/models/user.model';
import { AdminService } from 'src/app/services/admin.service';
import { ToastrService } from 'ngx-toastr';
import { Response } from 'src/app/models/response.model';
import { interval } from 'rxjs';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public userList !: Array<User>;
  public user !: User;
  public responseData!: Response;
  public EditUserForm !: FormGroup;
  editSection !: Boolean;

  constructor(private adminService: AdminService, private toastr: ToastrService) { }

  displayedColumns: any[] = ['FirstName', 'LastName', 'MobileNo', 'EmailID', 'JobRole', 'actions'];
  @ViewChild(MatTable) table!: MatTable<Array<User>>

  ngOnInit(): void { 

      this.editSection = false;

      this.adminService.getAllUsers().subscribe({
        next: response => {
            this.responseData = response as Response;
            if(this.responseData.responseType == "FAILURE")
                this.toastr.error(this.responseData.responseMessage);
            else {
                this.userList = response.result;
            }
        }, 
        error: () => this.toastr.error("An Error Occured")
      })

  }

  onEdit(user: User) {
      this.user = user;

      this.EditUserForm = new FormGroup({
        custId: new FormControl(user.custId),
        firstName: new FormControl(user.firstName),
        lastName: new FormControl(user.lastName),
        mobileNo: new FormControl(user.mobileNo),
        email: new FormControl(user.emailId),
        role: new FormControl(user.jobRole)
      })

      this.editSection = true;
  }

  onDelete(id: String) {  
      this.adminService.deleteUser(id).subscribe({
        next: response => {
            this.responseData = response as Response;
            if(this.responseData.responseType == "FAILURE")
                this.toastr.error(this.responseData.responseMessage);
            else {
                this.userList = this.userList.filter(user => user.custId !== id);
                this.toastr.success(this.responseData.responseMessage); 
            }
        }, 
        error: () => this.toastr.error("An Error Occured")
      })

      this.table.renderRows();
  }

  onSubmitEditedUser() {
    this.adminService.updateUser(this.user.custId, new User(
        this.EditUserForm.value.firstName, 
        this.EditUserForm.value.lastName,
        this.EditUserForm.value.email,
        this.EditUserForm.value.mobileNo,
        this.EditUserForm.value.role
    )).subscribe({
        next: response => {
            this.responseData = response as Response;
            if(this.responseData.responseType == "FAILURE")
                this.toastr.error(this.responseData.responseMessage);
            else {
                this.toastr.success(this.responseData.responseMessage); 
                var indx = this.userList.findIndex(user => user.custId == this.user.custId)
                this.userList[indx].firstName = this.EditUserForm.value.firstName;
                this.userList[indx].lastName = this.EditUserForm.value.lastName;
                this.userList[indx].emailId = this.EditUserForm.value.email;
                this.userList[indx].mobileNo = this.EditUserForm.value.mobileNo;
                this.userList[indx].jobRole = this.EditUserForm.value.role;
            }
        }, 
        error: () => this.toastr.error("An Error Occured")
      })

      this.table.renderRows();
  }

}
