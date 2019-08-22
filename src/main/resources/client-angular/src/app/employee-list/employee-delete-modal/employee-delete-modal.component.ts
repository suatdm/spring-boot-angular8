import {Component, Inject, OnInit} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Employee } from "../../model/employee";
import { EmployeeService } from "../../service/employee.service";

@Component({
  selector: 'app-employee-delete-modal',
  templateUrl: './employee-delete-modal.component.html',
  styleUrls: ['./employee-delete-modal.component.css']
})
export class EmployeeDeleteModalComponent implements OnInit {

  constructor(
    private employeeService: EmployeeService,
    private dialogRef: MatDialogRef<EmployeeDeleteModalComponent>,
    @Inject(MAT_DIALOG_DATA) public employee: Employee) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onDeleteClick(id): void {
    this.employeeService.deleteEmployee(id).subscribe( result => {
        console.log(result);
      },
      error => console.log(error));
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}
