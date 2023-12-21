import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, AbstractControl, ValidatorFn } from '@angular/forms';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public signupForm !: FormGroup;

  password = new FormControl('', Validators.required)
  confPassword = new FormControl('', Validators.required);

  constructor(private userService : UserService) { }

  ngOnInit(): void {
      this.signupForm = new FormGroup({
        firstName: new FormControl('', Validators.required), 
        lastName: new FormControl(''),
        address: new FormControl(''),
        email: new FormControl('', Validators.required),
        mobileNo: new FormControl('', Validators.required), 
        jobRole: new FormControl('', Validators.required),
        password: this.password,
        confPassword: this.confPassword
        // password1: new FormControl('', [
        //   (c : AbstractControl) => Validators.required(c), 
        //     Validators.pattern(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*#?&^_-]).{8,}/)
        // ])
      },
      {
        validators : this.confirmPasswordValidator('password', 'confPassword')
      }
      )
  }

  confirmPasswordValidator(password1: String, password2: String) :ValidatorFn {
      return (control : AbstractControl) => {
          const p1 = control.get(password1.toString());
          const p2 = control.get(password2.toString());

          if(p2?.errors && !p2?.errors?.['confirmPasswordValidator']) 
            return null;

          if(p1?.value !== p2?.value) {
              const error = {confirmPasswordValidator: 'Password do not match !'};
              p2?.setErrors(error);
              return error;
          }
          else {
            p2?.setErrors(null);
            return null;
          }

      }
  }

  onSubmit() { 
      this.userService.pushSignupData(new User(
        this.signupForm.value.firstName, 
        this.signupForm.value.lastName,
        this.signupForm.value.address,
        this.signupForm.value.email,
        this.signupForm.value.mobileNo,
        this.signupForm.value.jobRole,
        this.signupForm.value.password,
      ));
      this.signupForm.reset();
  }

}
