import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpmethodsService } from 'src/app/service/httpmethods.service';
import { managerLoginModel } from '../authenticationModel';
import { managerLoginURL } from '../authenticationURL';

@Component({
  selector: 'app-managerlogin',
  templateUrl: './managerlogin.component.html',
  styleUrls: ['./managerlogin.component.scss']
})
export class ManagerloginComponent implements OnInit {
  loginForm: FormGroup;
  loginModel = new managerLoginModel();
  submitted = false;
  constructor(private formBuilder: FormBuilder, private httpService: HttpmethodsService, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      managerMailAddress: new FormControl('', [Validators.required]),
      managerPassword: new FormControl('', [Validators.required]),
    })
  }

  get f() { return this.loginForm.controls; }


  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    //login 
    this.httpService.postRequest(managerLoginURL, this.loginModel).subscribe((data: any) => {
      if (data.responseCode == 200) {
        alert("Login Successfull")
        sessionStorage.setItem("token", data.token)
        sessionStorage.setItem("managerId", data.managerId)
        this.router.navigateByUrl("/dashboard")
      }
      if (data.responseCode == 404) {
        alert("User Name is Not Found")
        this.router.navigateByUrl("/")

      }
      if (data.responseCode == 400) {
        alert("Incorrect Password")
        this.router.navigateByUrl("/")
      }
      if (data.responseCode == 403) {
        this.router.navigateByUrl("/")
      }
    })
  }


}
