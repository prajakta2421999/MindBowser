import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthenticationRoutingModule } from './authentication-routing.module';
import { ManagersignupComponent } from './managersignup/managersignup.component';
import { ManagerloginComponent } from './managerlogin/managerlogin.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';



@NgModule({
  declarations: [ManagersignupComponent, ManagerloginComponent, DashboardComponent],
  imports: [
    CommonModule,
    AuthenticationRoutingModule,
    RouterModule, 
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class AuthenticationModule { }
