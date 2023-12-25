import { Component, OnInit } from '@angular/core';
import { Observable, interval, switchMap } from 'rxjs';
import { User } from 'src/app/models/user.model';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public userList !: Array<User>;
  public user !: User;
  constructor(private adminService: AdminService) { }

  ngOnInit(): void { 
      // interval(3000).pipe(
      //   switchMap(() => this.adminService.getAllUsers())
      // ).subscribe(
      //     data => {
      //       this.userList = data.result;
      //       console.log(this.userList);
      //   }
      // )

      this.adminService.getAllUsers().subscribe(
          data => {
              this.userList = data.result;
              console.log(this.userList);
          }
      )
  }

  onEdit(user: User) {
      console.log(user.custId);
  }

  onDelete(id: String) {  
      this.adminService.deleteUser(id);
      // window.location.reload();
  }

}
