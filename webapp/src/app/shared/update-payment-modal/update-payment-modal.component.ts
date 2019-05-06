import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { PaymentType } from 'app/project.model';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ProjectService } from 'app/project.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-payment-modal',
  templateUrl: './update-payment-modal.component.html',
  styleUrls: ['./update-payment-modal.component.scss']
})
export class UpdatePaymentModalComponent implements OnInit {
  @Input() public paymentId: number;
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
      this.getPayment();
    },
    error => {
      alert(error);
    });
  }

  getPayment() {
    if (!!this.paymentId) {
      this.projectService.getPayment(this.paymentId)
      .subscribe(res => {
        this.paymentForm.controls.id.setValue(res.id);
        this.paymentForm.controls.amount.setValue(res.amount);
        this.paymentForm.controls.type.setValue(res.type);
        this.paymentForm.controls.realizationDate.setValue(new Date(res.realizationDate));
        this.paymentForm.controls.note.setValue(res.note);
      },
      error => {
        alert(error);
      });
    }
  }

  setForm() {
    this.paymentForm = this.formBuilder.group({
      id: new FormControl(),
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

  updatePayment() {
    if (this.paymentForm.valid) {
      this.projectService.updatePayment(this.paymentForm.value)
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
    }
  }

  goLogin() {
    this.router.navigate(['/userLogin']);
  }
}
