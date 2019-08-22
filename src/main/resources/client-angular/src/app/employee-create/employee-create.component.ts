import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from "../service/employee.service";
import { Employee } from "../model/employee";

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {

  employee: Employee;

  constructor(private route: ActivatedRoute, private router: Router, private employeeService: EmployeeService) {
    this.employee = new Employee();
  }

  ngOnInit() {
  }

  onSubmit() {
    this.employeeService.save(this.employee).subscribe(result => this.employeeListLink());
  }

  employeeListLink(){
    this.router.navigate(['/employee']);
  }

}
