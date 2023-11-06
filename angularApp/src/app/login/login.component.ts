import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginForm !: FormGroup;

  constructor(private userService : UserService) { }

  ngOnInit(): void {
      this.loginForm = new FormGroup({
          mobNo: new FormControl('', Validators.required),
          password: new FormControl('', Validators.required), 
          role: new FormControl('', Validators.required)
      })
  }

  onSubmit() {
      this.userService.loginRequest(this.loginForm.value);
  }

}
