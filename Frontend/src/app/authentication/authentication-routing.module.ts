import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ManagerloginComponent } from './managerlogin/managerlogin.component';
import { ManagersignupComponent } from './managersignup/managersignup.component';

const routes: Routes = [
  {path:'',component:ManagerloginComponent},
  {path:'managersignup',component:ManagersignupComponent},
  {path:'dashboard',component:DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthenticationRoutingModule { }
