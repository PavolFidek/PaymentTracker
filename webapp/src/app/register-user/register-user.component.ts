import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ProjectService } from 'app/project.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.scss']
})
export class RegisterUserComponent implements OnInit {
  public registerForm: FormGroup;

  constructor(
    private projectService: ProjectService,
    private formBuilder: FormBuilder,
    private location: Location
  ) { }

  ngOnInit() {
    this.setForm();
  }

  setForm() {
    this.registerForm = this.formBuilder.group({
      login: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      password: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      passwordRepeat: new FormControl('', Validators.compose([
        Validators.required,
      ]))
    })
  }

  register() {
    if (this.registerForm.valid) {
      this.projectService.registerUser({
        login: this.registerForm.controls.login.value,
        password: this.registerForm.controls.password.value
      })
      .subscribe(res => {
        // registred
      },
      error => {
        // failed
      })
    } else {
      this.registerForm.controls.login.markAsDirty({ onlySelf: true });
      this.registerForm.controls.password.markAsDirty({ onlySelf: true });
      this.registerForm.controls.passwordRepeat.markAsDirty({ onlySelf: true });
    }
  }

  goBack() {
    this.location.back();
  }
}
