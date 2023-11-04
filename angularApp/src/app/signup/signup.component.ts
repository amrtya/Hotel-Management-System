import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from '../models/user.model';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public signupForm !: FormGroup;

  constructor(private userService : UserService) { }

  ngOnInit(): void {
      this.signupForm = new FormGroup({
        firstName: new FormControl('', Validators.required), 
        lastName: new FormControl(''), 
        address: new FormControl(''),
        email: new FormControl('', Validators.required),
        mobileNo: new FormControl('', Validators.required), 
        jobRole: new FormControl('', Validators.required)
      })
  }

  onSubmit() {
      console.log(this.signupForm.value); 
      this.userService.pushSignupData(this.signupForm.value);
      this.signupForm.reset();
  }

}
