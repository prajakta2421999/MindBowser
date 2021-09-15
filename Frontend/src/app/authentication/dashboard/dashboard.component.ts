import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpmethodsService } from 'src/app/service/httpmethods.service';
import { employeeModelClass } from '../authenticationModel';
import { deleteEmployeeByIdURL, getAllEmployee, getEmployeeByIdURL, registerEmployeeURL, updateEmployeeURL } from '../authenticationURL';
declare var $: any;

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  employeeModel = new employeeModelClass();
  addEmpForm: FormGroup;
  isEdit: boolean = true;
  submitted = false;


  allEmployeeList: any[];
  constructor(private httpService: HttpmethodsService, private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    $(document).ready(function () {
      $("#myBtn2").click(function () {
        $("#myModal2").show();
      });
      $(".closeModal2").click(function () {
        $("#myModal2").hide();
      });
    });

    this.addEmpForm = this.formBuilder.group({
      employeeFirstName: new FormControl('', [Validators.required]),
      employeeLastName: new FormControl('', [Validators.required]),
      employeeAddress: new FormControl('', [Validators.required]),
      employeeBirthdate: new FormControl('', [Validators.required]),
      employeeMobileNo: new FormControl('', [Validators.required]),
      employeeCity: new FormControl('', [Validators.required]),
    })

    if(sessionStorage.getItem("managerId")==null)
    {
      this.router.navigateByUrl("/")
    }
    this.getAllEmployee();
  }
  getAllEmployee() {
    this.httpService.getRequest(getAllEmployee).subscribe((data: any) => {
      this.allEmployeeList = data;
    })
  }


  get f() { return this.addEmpForm.controls; }
  onSubmit() {

    this.submitted = true;
    if (this.addEmpForm.invalid) {
      return;
    }

    if (this.isEdit) {
      this.httpService.postRequest(registerEmployeeURL, this.employeeModel).subscribe((data: any) => {
        this.isEdit = true;
        alert("Save Successfully")
        this.getAllEmployee();
        this.addEmpForm.reset();
      })
    }
    else {
      this.httpService.putRequest(updateEmployeeURL, this.employeeModel).subscribe((data: any) => {
        this.isEdit = true;
        alert("Update Successfully")
        this.getAllEmployee();
        this.addEmpForm.reset();
      })
    }
  }

  getById(employeeId) {
    this.httpService.getRequest(getEmployeeByIdURL + "/" + employeeId).subscribe((data: any) => {
      this.employeeModel = data;
      $("#myModal2").show();
      this.isEdit = false;
    })
  }

  deleteById(employeeId) {
    this.httpService.deleteRequest(deleteEmployeeByIdURL + "/" + employeeId).subscribe((data: any) => {
      alert("Delete Successfully")
      this.getAllEmployee();
    })
  }

  logout()
  {
    sessionStorage.clear();
    if(sessionStorage.getItem("managerId")==null)
    {
      this.router.navigateByUrl("/")
    }
  }

}
