import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Employee } from "../../model/employee";
import { EmployeeService } from "../../service/employee.service";

@Component({
  selector: 'app-employee-update-modal',
  templateUrl: './employee-update-modal.component.html',
  styleUrls: ['./employee-update-modal.component.css']
})
export class EmployeeUpdateModalComponent implements OnInit {

  constructor(
    private employeeService: EmployeeService,
    private dialogRef: MatDialogRef<EmployeeUpdateModalComponent>,
    @Inject(MAT_DIALOG_DATA) public employee: Employee) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  updateEmployee(employee) {
    debugger;
    this.employeeService.updateEmployee(employee.rid, employee).subscribe(result => {
      console.log(result);
    }, error => console.log(error));
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}
