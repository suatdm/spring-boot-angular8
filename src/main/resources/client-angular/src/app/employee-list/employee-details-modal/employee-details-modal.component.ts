import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Employee } from "../../model/employee";
import { EmployeeService } from "../../service/employee.service";

@Component({
  selector: 'app-employee-details-modal',
  templateUrl: './employee-details-modal.component.html',
  styleUrls: ['./employee-details-modal.component.css']
})
export class EmployeeDetailsModalComponent implements OnInit {

  constructor(
    private employeeService: EmployeeService,
    private dialogRef: MatDialogRef<EmployeeDetailsModalComponent>,
    @Inject(MAT_DIALOG_DATA) public employee: Employee) { }

  onNoClick(): void {
    this.dialogRef.close();
  }


  ngOnInit() {
  }

}
