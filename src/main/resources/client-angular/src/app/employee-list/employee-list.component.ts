import {Component, OnInit} from '@angular/core';
import {Employee} from "../model/employee";
import {EmployeeService} from "../service/employee.service";
import {Router} from "@angular/router";
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { EmployeeDeleteModalComponent } from "./employee-delete-modal/employee-delete-modal.component";
import { EmployeeDetailsModalComponent } from "./employee-details-modal/employee-details-modal.component";
import { EmployeeUpdateModalComponent } from "./employee-update-modal/employee-update-modal.component";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[];

  constructor(private employeeService: EmployeeService, private router: Router, public dialog: MatDialog) {

  }

  ngOnInit() {
    this.fetchAllEmployee();
  }

  public fetchAllEmployee(){
    this.employeeService.findAll().subscribe(data => {
      // @ts-ignore
      const { employeeResourceList } = data;
      this.employees = employeeResourceList;
    });
  }

  employeeDelete(employee): void {
    const dialogRef = this.dialog.open(EmployeeDeleteModalComponent, {
      width: '600px',
      data: employee
    });
    dialogRef.afterClosed().subscribe(result => {
      this.fetchAllEmployee();
    });
  }

  employeeDetails(employee) {
    const dialogRef = this.dialog.open(EmployeeDetailsModalComponent, {
      width: '600px',
      data: employee
    });
  }

  employeeUpdate(employee) {
    const dialogRef = this.dialog.open(EmployeeUpdateModalComponent, {
      width: '600px',
      data: employee
    });
    dialogRef.afterClosed().subscribe(result => {
      this.fetchAllEmployee();
    });
  }

}
