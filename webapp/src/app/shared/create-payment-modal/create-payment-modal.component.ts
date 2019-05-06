import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ProjectService } from 'app/project.service';
import { PaymentType } from 'app/project.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-payment-modal',
  templateUrl: './create-payment-modal.component.html',
  styleUrls: ['./create-payment-modal.component.scss']
})
export class CreatePaymentModalComponent implements OnInit {
  @Output() public action = new EventEmitter();
  public paymentForm: FormGroup;
  public today = new Date();

  public types: PaymentType[];
  public selectedType: PaymentType;

  public minDateValue: Date = new Date();
  public maxDateValue: Date = new Date();

  constructor(
    private actibeModal: NgbActiveModal,
    private formBuilder: FormBuilder,
    private projectService: ProjectService,
    private router: Router
  ) { }

  ngOnInit() {
    // Setup min and max date for datepicker (only days in current month)
    this.minDateValue.setDate(1);
    this.maxDateValue.setDate(new Date(this.maxDateValue.getFullYear(), this.maxDateValue.getMonth() + 1, 0).getDate());

    this.setForm();
    this.getTypes();
  }

  getTypes() {
    this.projectService.getPaymentTypes()
    .subscribe(res => {
      this.types = res;
    },
    error => {
      alert(error);
    });
  }

  setForm() {
    this.paymentForm = this.formBuilder.group({
      id: new FormControl(0),
      note: new FormControl(''),
      realizationDate: new FormControl(this.today, Validators.compose([
        Validators.required,
      ])),
      amount: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      type: new FormControl('', Validators.compose([
        Validators.required,
      ])),
    });
  }

  savePayment() {
    if (this.paymentForm.valid) {
      this.projectService.savePayment(this.paymentForm.value)
      .subscribe(res => {
        this.action.emit(res);
      },
      error => {
        if (error.status === 403) {
          this.goLogin();
        } else {
          alert(error);
        }
      });
      this.actibeModal.close();
    } else {
      this.paymentForm.controls.realizationDate.markAsDirty({ onlySelf: true });
      this.paymentForm.controls.amount.markAsDirty({ onlySelf: true });
      this.paymentForm.controls.type.markAsDirty({ onlySelf: true });
    }
  }

  goLogin() {
    this.router.navigate(['/userLogin']);
  }
}
