import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Authentication/login/login.component';
import { SignupComponent } from './Authentication/signup/signup.component';
import { AdminComponent } from './homepage/admin/admin.component';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {path: 'login', component: LoginComponent},
    {path: 'signup', component: SignupComponent}, 
    {path: 'admin', component: AdminComponent}
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
