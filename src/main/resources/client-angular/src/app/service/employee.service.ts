import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from "../model/employee";
import { Observable } from "rxjs";
import { environment } from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private employeeUrl: string;

  constructor(private http: HttpClient) {
    this.employeeUrl = environment.baseUrl + "/employee";
  }

  public findAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeeUrl + "/list");
  }

  public save(employee: Employee) {
    return this.http.post<Employee>(this.employeeUrl, employee);
  }

  updateEmployee(rid: string, value: any): Observable<Object> {
    return this.http.put(`${this.employeeUrl}/${rid}`, value);
  }

  public deleteEmployee(rid: string): Observable<any> {
    return this.http.delete(`${this.employeeUrl}/${rid}`, { responseType: 'text' });
  }
}
