import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User, LoginData, RegisterData, Payment, PaymentType } from './project.model';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class ProjectService {
  private userUrl = `api/user`;
  private paymentUrl = `api/payment`;
  private paymentTypeUrl = `api/paymentType`;

  private refreshData: BehaviorSubject<any> = new BehaviorSubject<any>(null);
  public refreshData$: Observable<any> = this.refreshData.asObservable();

  constructor(
    private httpClient: HttpClient
  ) { }

  login(loginData: LoginData): Observable<boolean> {
    return this.httpClient.post<any>(this.userUrl + `/userLogin`, loginData);
  }

  logout(): Observable<User> {
    return this.httpClient.get<any>(this.userUrl + `/logoutUser`);
  }

  registerUser(registerData: RegisterData): Observable<boolean> {
    return this.httpClient.post<any>(this.userUrl + `/userRegister`, registerData);
  }

  getCurrentUser(): Observable<User> {
    return this.httpClient.get<any>(this.userUrl + `/getUser`);
  }

  getUserPayments(): Observable<Payment[]> {
    return this.httpClient.get<any>(this.paymentUrl + `/getAllPayments`);
  }

  getPayment(paymentId: number): Observable<Payment> {
    return this.httpClient.get<any>(this.paymentUrl + `/getPayment/${ paymentId }`);
  }

  savePayment(newPayment: Payment): Observable<Payment> {
    return this.httpClient.post<any>(this.paymentUrl + `/new`, newPayment);
  }

  deletePayment(paymentId: number): Observable<Payment> {
    return this.httpClient.post<any>(this.paymentUrl + `/delete`, paymentId);
  }

  updatePayment(payment: Payment): Observable<Payment> {
    return this.httpClient.post<any>(this.paymentUrl + `/update`, payment);
  }

  getPaymentTypes(): Observable<PaymentType[]> {
    return this.httpClient.get<any>(this.paymentTypeUrl + `/all`);
  }

  refreshGraphData(data: Payment[]) {
    this.refreshData.next(data);
  }
}
