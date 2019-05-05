import { Component, OnInit, Input } from '@angular/core';
import { Payment } from 'app/project.model';
import { ProjectService } from 'app/project.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CreatePaymentModalComponent } from 'app/shared/create-payment-modal/create-payment-modal.component';
import { UpdatePaymentModalComponent } from 'app/shared/update-payment-modal/update-payment-modal.component';
import { Router } from '@angular/router';
import { t } from '@angular/core/src/render3';

@Component({
  selector: 'app-table-data',
  templateUrl: './table-data.component.html',
  styleUrls: ['./table-data.component.scss']
})
export class TableDataComponent implements OnInit {
  @Input() public PAYMENTS: Payment[];
  @Input() collectionSize: number;

  page = 1;
  pageSize = 7;

  constructor(
    private modalService: NgbModal,
    private projectService: ProjectService,
    private router: Router
  ) {}

  ngOnInit() {
  }

  get payments(): Payment[] {
    return this.PAYMENTS
      .map((payment, i) => ({ id: i + 1, ...payment }))
      .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
  }

  newPayment() {
    const modalRef = this.modalService.open(CreatePaymentModalComponent);
    modalRef.componentInstance.action
    .subscribe((value) => {
      this.PAYMENTS.push(value);
      this.collectionSize++;

      this.refreshData(this.PAYMENTS);
    },
    error => {
      if (error.status === 403) {
        this.goToLoginPage();
      } else {
        alert(error);
      }
    });
  }

  update(paymentId: number) {
    const modalRef = this.modalService.open(UpdatePaymentModalComponent);
    modalRef.componentInstance.paymentId = paymentId;
    modalRef.componentInstance.action
    .subscribe((value) => {
      this.PAYMENTS.forEach(element => {
        if (element.id === value.id) {
          element.amount = value.amount;
          element.note = value.note;
          element.realizationDate = value.realizationDate;
          element.type = value.type;
        }
      });

      this.refreshData(this.PAYMENTS);
    },
    error => {
      if (error.status === 403) {
        this.goToLoginPage();
      } else {
        alert(error);
      }
    });
  }

  delete(paymentId: number) {
    this.projectService.deletePayment(paymentId)
    .subscribe(res => {
      this.PAYMENTS = this.PAYMENTS.filter(x => x.id !== res.id);
      this.collectionSize--;

      this.refreshData(this.PAYMENTS);
    },
    error => {
      if (error.status === 403) {
        this.goToLoginPage();
      } else {
        alert(error);
      }
    });
  }

  refreshData(data: Payment[]) {
    this.projectService.refreshGraphData(data);
  }

  goToLoginPage() {
    this.router.navigate(['/userLogin']);
  }
}
