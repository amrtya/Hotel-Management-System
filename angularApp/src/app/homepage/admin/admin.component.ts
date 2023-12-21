import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public userList !: Array<User>;
  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
      this.adminService.getAllUsers().subscribe(
          data => {
              this.userList = data.result;
              console.log(this.userList);
          }
      )
  }

}
