import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ProjectService } from 'app/project.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.scss']
})
export class LoginUserComponent implements OnInit {
  public loginForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private projectService: ProjectService,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.setForm();
  }

  setForm() {
    this.loginForm = this.formBuilder.group({
      login: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      password: new FormControl('', Validators.compose([
        Validators.required,
      ]))
    })
  }

  login() {
    if (this.loginForm.valid) {
      this.projectService.login(this.loginForm.value)
        .subscribe(res => {
          // loged
        },
          error => {
            // login failed
          });
    } else {
      this.loginForm.controls.login.markAsDirty({ onlySelf: true });
      this.loginForm.controls.password.markAsDirty({ onlySelf: true });
    }
  }

  open() {
  }
}
