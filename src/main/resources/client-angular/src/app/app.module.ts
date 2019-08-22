import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { FormsModule } from "@angular/forms";
import { EmployeeService } from "./service/employee.service";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EmployeeDeleteModalComponent } from './employee-list/employee-delete-modal/employee-delete-modal.component';
import { EmployeeDetailsModalComponent } from './employee-list/employee-details-modal/employee-details-modal.component';
import { EmployeeUpdateModalComponent } from './employee-list/employee-update-modal/employee-update-modal.component';
import { AngularMaterialModule } from './angular-material.module';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeDeleteModalComponent,
    EmployeeDetailsModalComponent,
    EmployeeUpdateModalComponent
  ],
  entryComponents: [EmployeeDeleteModalComponent, EmployeeDetailsModalComponent, EmployeeUpdateModalComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AngularMaterialModule,
    BrowserAnimationsModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule { }
