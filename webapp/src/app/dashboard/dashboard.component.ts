import { Component, OnInit } from '@angular/core';
import { User, Payment } from 'app/project.model';
import { ProjectService } from 'app/project.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  public user: User = null;
  public PAYMENTS: Payment[];
  public data: any;
  public paymentAmount: number;
  public collectionSize: number;
  public paymentAmountAllSum: number;

  constructor(
    private projectService: ProjectService,
    private router: Router
  ) { }

  ngOnInit() {
    this.getPayments();

    this.projectService.refreshData$
    .subscribe(data => {
      if (!!data) {
        this.PAYMENTS = data;
        this.paymentAmountAllSum = this.paymentAmountSum();
        this.setData();
      }
    });
  }

  getCurrentUser() {
    this.projectService.getCurrentUser()
      .subscribe(res => {
        this.user = res;
        this.setData();
      },
        error => {
          if (error.status === 403) {
            this.goToLoginPage();
          } else {
            alert(error);
          }
        });
  }

  getPayments() {
    this.projectService.getUserPayments()
      .subscribe(res => {
        this.PAYMENTS = res;
        this.collectionSize = this.PAYMENTS.length;
        this.paymentAmountAllSum = this.paymentAmountSum();
        this.getCurrentUser();
      },
        error => {
          if (error.status === 403) {
            this.goToLoginPage();
          } else {
            alert(error);
          }
        });
  }

  setData() {
    this.data = {
      labels: ['Available', 'Costs'],
      datasets: [
        {
          data: [
            (this.user.payoutAmount - this.paymentAmountAllSum > 0 ? this.user.payoutAmount - this.paymentAmountAllSum : 0),
            this.paymentAmountAllSum
          ],
          backgroundColor: [
            "#35e005",
            "#ee0c19"
          ],
          hoverBackgroundColor: [
            "#35e005",
            "#ee0c19"
          ]
        }]
    };
  }

  getSavings(): number {
    return this.user.payoutAmount - this.paymentAmountAllSum;
  }

  positiveBalance(): boolean {
    return this.user.payoutAmount - this.paymentAmountAllSum > 0 ? true : false;
  }

  paymentAmountSum(): number {
    let amount = 0;

    this.PAYMENTS.forEach(element => {
      amount += element.amount;
    });

    return amount;
  }

  goToLoginPage() {
    this.router.navigate(['/userLogin']);
  }

  logout() {
    this.projectService.logout()
    .subscribe(res => {
      this.goToLoginPage();
    },
    error => {
      if (error.status === 403) {
        this.goToLoginPage();
      } else {
        alert(error);
      }
    })
  }

}
