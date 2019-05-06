import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ProjectService } from 'app/project.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-user-modal',
  templateUrl: './update-user-modal.component.html',
  styleUrls: ['./update-user-modal.component.scss']
})
export class UpdateUserModalComponent implements OnInit {
  @Output() public action = new EventEmitter();
  public userForm: FormGroup;

  constructor(
    private actibeModal: NgbActiveModal,
    private formBuilder: FormBuilder,
    private projectService: ProjectService,
    private router: Router
  ) { }

  ngOnInit() {
    this.setForm();
    this.getUser();
  }

  getUser() {
    this.projectService.getCurrentUser()
    .subscribe(res => {
      this.userForm.setValue(res);
    },
    error => {
      if (error.status === 403) {
        this.goLogin();
      } else {
        alert(error);
      }
    });
  }

  setForm() {
    this.userForm = this.formBuilder.group({
      id: new FormControl(),
      firstName: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      lastName: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      payoutAmount: new FormControl('', Validators.compose([
        Validators.required,
      ]))
    });
  }

  updateUser() {
    if (this.userForm.valid) {
      this.projectService.updateUser(this.userForm.value)
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
