import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpmethodsService } from 'src/app/service/httpmethods.service';
import { signUpModelClass } from '../authenticationModel';
import { registerManagerURL } from '../authenticationURL';

@Component({
  selector: 'app-managersignup',
  templateUrl: './managersignup.component.html',
  styleUrls: ['./managersignup.component.scss']
})
export class ManagersignupComponent implements OnInit {
  signUpForm: FormGroup;
  signUpModel=new signUpModelClass();
  submitted = false;

  constructor(private formBuilder: FormBuilder,private httpService: HttpmethodsService,private router: Router) { }

  ngOnInit(): void {

    this.signUpForm = this.formBuilder.group({
      managerFirstName: new FormControl('', [Validators.required]),
      managerLastName: new FormControl('',[Validators.required]),
      managerPassword: new FormControl('', [Validators.required]),
      managerAddress: new FormControl('', [Validators.required]),
      managerBirthdate: new FormControl('', [Validators.required]),
      managerCompanyName: new FormControl('', [Validators.required]),
      managerMailAddress: new FormControl('', [Validators.required]),
    })
  }

  get f() { return this.signUpForm.controls; }

  onSubmit() {

    this.submitted = true;
    if (this.signUpForm.invalid) {
      return;
    }

    //signup
    this.httpService.postRequest(registerManagerURL, this.signUpModel).subscribe((data: any) => {
      this.signUpForm.reset();
      alert(data.message)
      this.router.navigateByUrl("/")
    })
}


}
